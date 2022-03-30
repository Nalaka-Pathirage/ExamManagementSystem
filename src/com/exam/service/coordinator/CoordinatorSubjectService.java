package com.exam.service.coordinator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CoordinatorSubjectService {

	// for loading coordinator subject management page
	public void doLoadSubjectPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject.jsp");
		dispatcher.forward(request, response);
	}
}
