package com.exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.AuthenticationService;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AuthenticationService authenticationService;

	@Override
	public void init() throws ServletException {
		super.init();
		authenticationService = new AuthenticationService();
	}

	// controller endpoint for user logout
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		authenticationService.doLogout(request, response);
	}
}
