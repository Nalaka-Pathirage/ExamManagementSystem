package com.exam.service.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentExamQuizService {

	// for rendering student exam page
	public void doRenderExamPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_exam.jsp");
		dispatcher.forward(request, response);
	}

	// for rendering student quiz page
	public void doRenderQuizPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_quiz.jsp");
		dispatcher.forward(request, response);
	}

	// for submitting the exam
	public void doSubmitExam() {
		// to be implemented
	}

	// for submitting the quiz
	public void doSubmitQuiz() {
		// to be implemented
	}

}
