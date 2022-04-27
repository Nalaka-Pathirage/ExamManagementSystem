package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorExamQuizService;

@WebServlet("/Coordinator/AddExam")
public class CoordinatorExamAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorExamQuizService coordinatorExamQuizService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorExamQuizService = new CoordinatorExamQuizService();
	}

	// retrive coordinator exam management page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorExamQuizService.doLoadExamAddPage(request, response);
	}

	// submit exam
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// to be implemented
	}

}
