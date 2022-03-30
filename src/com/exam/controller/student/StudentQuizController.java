package com.exam.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.student.StudentExamQuizService;

@WebServlet("/StudentQuiz")
public class StudentQuizController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private StudentExamQuizService studentExamQuizService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.studentExamQuizService = new StudentExamQuizService();
	}

	//for retrieving student quiz page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		studentExamQuizService.doRenderQuizPage(request, response);
	}

	//for submitting the quiz
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//to be implemented
	}

}
