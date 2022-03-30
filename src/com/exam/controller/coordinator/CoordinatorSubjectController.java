package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorSubjectService;

@WebServlet("/CoordinatorSubjects")
public class CoordinatorSubjectController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorSubjectService coordinatorSubjectService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorSubjectService = new CoordinatorSubjectService();
	}

	// retrive coordinator subject management page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorSubjectService.doLoadSubjectPage(request, response);
	}

	// submit subjects
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// to be implemented
	}

}
