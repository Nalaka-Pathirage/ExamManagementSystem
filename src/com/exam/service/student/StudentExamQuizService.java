package com.exam.service.student;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.AttemptDao;
import com.exam.dao.ExamQuizDao;
import com.exam.model.Attempt;
import com.exam.model.ExamQuiz;
import com.exam.model.Student;
import com.exam.utility.HelperUtility;
import com.exam.wrappers.QuizExamWrapper;

public class StudentExamQuizService {

	private ExamQuizDao examQuizDao;
	private AttemptDao attemptDao;

	public StudentExamQuizService() {
		this.examQuizDao = new ExamQuizDao();
		this.attemptDao = new AttemptDao();
	}

	// rendering student exam page
	public void doLoadExamPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch loggedIn student from current session
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("loggedInUser");

		// fetch all available exams
		List<ExamQuiz> examQuiz = examQuizDao.findAllExams();

		// fetch all attempted exams by loggedIn student
		List<Attempt> attempts = attemptDao.findExamsAttemptedByStudent(student.getStudentId());

		// setting data on request scope
		request.setAttribute("exams", examQuiz);
		request.setAttribute("attempts", attempts);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_exam.jsp");
		dispatcher.forward(request, response);
	}

	// rendering student quiz page
	public void doLoadQuizPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch loggedIn student from current session
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("loggedInUser");

		// fetch all available quizes
		List<ExamQuiz> examQuiz = examQuizDao.findAllQuizes();

		// fetch all attempted quizes by loggedIn student
		List<Attempt> attempts = attemptDao.findQuizesAttemptedByStudent(student.getStudentId());

		// setting data on request scope
		request.setAttribute("quizes", examQuiz);
		request.setAttribute("attempts", attempts);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_quiz.jsp");
		dispatcher.forward(request, response);
	}

	// rendering exam attempt window
	public void doLoadAttemptExamPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch requested exam
		ExamQuiz exam = examQuizDao.findById(Integer.parseInt(request.getParameter("ExamId")));

		// extrating questions in exam
		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) HelperUtility.deserialize(exam.getQuestions(),
				QuizExamWrapper.class);

		// setting data on request scope
		request.setAttribute("examId", request.getParameter("ExamId"));
		request.setAttribute("quizExamWrapper", quizExamWrapper);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_exam_attempt.jsp");
		dispatcher.forward(request, response);
	}

	// rendering quiz attempt window
	public void doLoadAttemptQuizPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch requested quiz
		ExamQuiz quiz = examQuizDao.findById(Integer.parseInt(request.getParameter("QuizId")));

		// extrating questions in quiz
		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) HelperUtility.deserialize(quiz.getQuestions(),
				QuizExamWrapper.class);

		// setting data on request scope
		request.setAttribute("quizId", request.getParameter("QuizId"));
		request.setAttribute("quizExamWrapper", quizExamWrapper);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_quiz_attempt.jsp");
		dispatcher.forward(request, response);
	}

	// submitting the exam
	public void doSubmitExam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch loggedIn student from current session
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("loggedInUser");

		// fetch attempted quiz instance
		ExamQuiz exam = examQuizDao.findById(Integer.parseInt(request.getParameter("ExamId")));

		// extrating questions in exam
		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) HelperUtility.deserialize(exam.getQuestions(),
				QuizExamWrapper.class);

		// extract supplied answers via request instance
		Map<Integer, Integer> submittedAnswers = assembleSuppliedAnswers(request, quizExamWrapper);

		// assembling Attempt instance to be persisted
		Attempt attempt = new Attempt();
		attempt.setStudent(student);
		attempt.setExamQuiz(exam);
		attempt.setAttemptedOn(LocalDateTime.now());

		// evalueate quiz
		evaluateExamQuiz(submittedAnswers, quizExamWrapper, attempt);

		// persisting attempt record
		attemptDao.insert(attempt);

		// load exam home page
		doLoadExamPage(request, response);
	}

	// submitting the quiz
	public void doSubmitQuiz(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch loggedIn student from current session
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("loggedInUser");

		// fetch attempted quiz instance
		ExamQuiz quiz = examQuizDao.findById(Integer.parseInt(request.getParameter("QuizId")));

		// extrating questions in exam
		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) HelperUtility.deserialize(quiz.getQuestions(),
				QuizExamWrapper.class);

		// extract supplied answers via request instance
		Map<Integer, Integer> submittedAnswers = assembleSuppliedAnswers(request, quizExamWrapper);

		// assembling Attempt instance to be persisted
		Attempt attempt = new Attempt();
		attempt.setStudent(student);
		attempt.setExamQuiz(quiz);
		attempt.setAttemptedOn(LocalDateTime.now());

		// evalueate quiz
		evaluateExamQuiz(submittedAnswers, quizExamWrapper, attempt);

		// persisting attempt record
		attemptDao.insert(attempt);

		// load quiz home page
		doLoadQuizPage(request, response);
	}

	// assembling supplied answers for questions via request instance
	private Map<Integer, Integer> assembleSuppliedAnswers(HttpServletRequest request, QuizExamWrapper quizExamWrapper) {

		int counter = 1;
		Map<Integer, Integer> submittedAnswers = new HashMap<>();

		while (counter <= quizExamWrapper.getQuestions().size()) {
			submittedAnswers.put(counter, Integer.parseInt(request.getParameter(String.valueOf(counter))));
			counter++;
		}

		return submittedAnswers;
	}

	// evaluate exam/quiz
	private void evaluateExamQuiz(Map<Integer, Integer> submittedAnswers, QuizExamWrapper quizExamWrapper,
			Attempt attempt) {

		final double PASS_MARK = 50.00;
		AtomicInteger numberOfCorrectAnswers = new AtomicInteger(0);
		boolean isQuizPassed = false;

		submittedAnswers.forEach((question, suppliedAnswer) -> {
			if (suppliedAnswer.intValue() == quizExamWrapper.getQuestions().get(question - 1).getCorrectAnswer()
					.intValue()) {
				numberOfCorrectAnswers.getAndIncrement();
			}
		});

		double marksScored = (double) numberOfCorrectAnswers.get() / (double) quizExamWrapper.getQuestions().size()
				* 100;

		if (Double.compare(marksScored, PASS_MARK) == 0 || Double.compare(marksScored, PASS_MARK) > 0) {
			isQuizPassed = true;
		}

		// setting values for Attempt instance
		attempt.setMarks(marksScored);
		attempt.setPassFail(isQuizPassed);
	}

}
