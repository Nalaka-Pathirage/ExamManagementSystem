package com.exam.controller.coordinator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorHomeService;

@WebServlet("/CoordinatorHome")
public class CoordinatorHomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorHomeService coordinatorHomeService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.coordinatorHomeService = new CoordinatorHomeService();
	}

	// retrieving coordinator home page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		coordinatorHomeService.doLoadHomePage(request, response);
	}

}
