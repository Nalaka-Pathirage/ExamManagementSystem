package com.exam.service.coordinator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.ExamQuizDao;
import com.exam.dao.SubjectDao;
import com.exam.model.Coordinator;
import com.exam.model.ExamQuiz;
import com.exam.model.Subject;
import com.exam.utility.HelperUtility;
import com.exam.wrappers.QuestionWrapper;
import com.exam.wrappers.QuizExamWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoordinatorExamQuizService {

	private SubjectDao subjectDao;
	private ExamQuizDao examQuizDao;

	public CoordinatorExamQuizService() {
		this.subjectDao = new SubjectDao();
		this.examQuizDao = new ExamQuizDao();
	}

	// for rendering exam page
	public void doLoadExamPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_exam.jsp");
		dispatcher.forward(request, response);
	}

	// for rendering quiz page
	public void doLoadQuizPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available quizes
		List<ExamQuiz> quizes = examQuizDao.findAllQuizes();

		// put in the request scope
		request.setAttribute("quizes", quizes);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_quiz.jsp");
		dispatcher.forward(request, response);
	}

	// for rendering exam add page
	public void doLoadExamAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch subjects
		List<Subject> subjects = subjectDao.findAll();

		// put in the request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_exam_add.jsp");
		dispatcher.forward(request, response);
	}

	// for rendering quiz add page
	public void doLoadQuizAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch subjects
		List<Subject> subjects = subjectDao.findAll();

		// put in the request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_quiz_add.jsp");
		dispatcher.forward(request, response);
	}

	// for submitting exams
	public void doSubmitExam() {

		// to be implemented
	}

	// for submitting quizes
	public void doSubmitQuiz(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtaining http session
		HttpSession session = request.getSession();
		// retrieving loggedIn user
		Coordinator coordinator = (Coordinator) session.getAttribute("loggedInUser");
		// retrieving generated quiz
		ExamQuiz examQuiz = (ExamQuiz) session.getAttribute("generatedExamQuiz");
		// retrieving added questions
		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) session.getAttribute("quizExamWrapper");

		switch (request.getParameter("flag")) {

		// generate quiz
		case "G":
			if (examQuiz == null) {
				// assemble exam/quiz instance
				examQuiz = new ExamQuiz(request.getParameter("qName"), "Q", LocalDateTime.now(), coordinator,
						new Subject(Integer.parseInt(request.getParameter("subject"))));
				// store within user session
				session.setAttribute("generatedExamQuiz", examQuiz);
			}
			// loading quiz add page
			doLoadQuizAddPage(request, response);
			break;
		// add questions
		case "A":
			if (quizExamWrapper == null) {
				quizExamWrapper = new QuizExamWrapper();
				// store within user session
				session.setAttribute("quizExamWrapper", quizExamWrapper);
			}
			QuestionWrapper questionWrapper = new QuestionWrapper(Integer.parseInt(request.getParameter("qNumber")),
					request.getParameter("question"),
					assembleAvailableAnswers(request.getParameter("availableAnswers").split(",")),
					Integer.parseInt(request.getParameter("correctAnswer")));
			quizExamWrapper.setQuestions(questionWrapper);
			// loading quiz add page
			doLoadQuizAddPage(request, response);
			break;
		// submit quiz
		case "S":
			if (examQuiz != null && quizExamWrapper != null) {
				examQuiz.setQuestions(HelperUtility.serialize(quizExamWrapper));
				examQuizDao.insert(examQuiz);
				// cleaning the session
				session.removeAttribute("generatedExamQuiz");
				session.removeAttribute("quizExamWrapper");
			}
			// load quiz home page
			doLoadQuizPage(request, response);
			break;
		}
	}

	// rendering quiz show page
	public void doLoadShowQuiz(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available quizes
		ExamQuiz quiz = examQuizDao.findById(Integer.parseInt(request.getParameter("QuizId")));

//		 ObjectMapper objectMapper = new ObjectMapper();
//		 QuizExamWrapper quizExamWrapper = objectMapper.readValue(quiz.getQuestions(), QuizExamWrapper.class);
		
		// extrating questions in quiz
//		QuizExamWrapper quizExamWrapper = (QuizExamWrapper) HelperUtility.deserialize(quiz.getQuestions(),
//				QuizExamWrapper.class);

		// put in the request scope
//		request.setAttribute("quizExamWrapper", quizExamWrapper);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_quiz_show.jsp");
		dispatcher.forward(request, response);
	}

	// assemble available answers list
	private Map<Integer, String> assembleAvailableAnswers(String[] answersArr) {
		int counter = 0;
		Map<Integer, String> answers = new HashMap<>();
		for (String answer : answersArr) {
			counter++;
			answers.put(counter, answer);
		}
		return answers;
	}

}
