package com.exam.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.AuthenticationService;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AuthenticationService authenticationService;

	@Override
	public void init() throws ServletException {
		super.init();
		authenticationService = new AuthenticationService();
	}

	// controller endpoint for retrieving login page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// authenticationService.doLogin(request, response);
	}

	// controller endpoint for user authentication
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// proceed user authentication
		authenticationService.doLogin(request, response);
	}

}
