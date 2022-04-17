package com.exam.service.coordinator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.SubjectDao;
import com.exam.model.Subject;

public class CoordinatorExamQuizService {

	private SubjectDao subjectDao;

	public CoordinatorExamQuizService() {
		this.subjectDao = new SubjectDao();
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_quiz.jsp");
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
	public void doSubmitQuiz() {

		// to be implemented
	}
}
