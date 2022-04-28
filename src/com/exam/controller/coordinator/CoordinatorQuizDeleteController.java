package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorExamQuizService;

@WebServlet("/Coordinator/DeleteQuiz")
public class CoordinatorQuizDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorExamQuizService coordinatorExamQuizService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorExamQuizService = new CoordinatorExamQuizService();
	}

	// controller endpoint for deleting the quiz
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorExamQuizService.doDeleteQuiz(request, response);
	}

}
