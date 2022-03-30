package com.exam.service.coordinator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoordinatorLecturerService {

	// for loading coordinator lecturer page
	public void doLoadLecturerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer.jsp");
		dispatcher.forward(request, response);
	}
}
