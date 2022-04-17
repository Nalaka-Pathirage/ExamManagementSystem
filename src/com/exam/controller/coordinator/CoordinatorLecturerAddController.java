package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorLecturerService;

@WebServlet("/Coordinator/LecturerAdd")
public class CoordinatorLecturerAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorLecturerService coordinatorLecturerService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorLecturerService = new CoordinatorLecturerService();
	}

	// retrive lecturer add page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coordinatorLecturerService.doLoadLecturerAddPage(request, response);
	}

	// lecturer submit endpoint
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coordinatorLecturerService.doSubmitLecturer(request, response);
	}
}
