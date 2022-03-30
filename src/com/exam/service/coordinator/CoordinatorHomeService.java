package com.exam.service.coordinator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoordinatorHomeService {

	// for loading coordinator home page
	public void doLoadHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_home.jsp");
		dispatcher.forward(request, response);
	}
}
