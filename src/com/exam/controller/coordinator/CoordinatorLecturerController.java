package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorLecturerService;

@WebServlet("/CoordinatorLecturers")
public class CoordinatorLecturerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorLecturerService coordinatorLecturerService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorLecturerService = new CoordinatorLecturerService();
	}

	// retrive coordinator lecturer management page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coordinatorLecturerService.doLoadLecturerPage(request, response);
	}

}
