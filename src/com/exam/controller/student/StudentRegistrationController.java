package com.exam.controller.student;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.student.StudentRegistrationService;

@WebServlet("/StudentRegistration")
public class StudentRegistrationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private StudentRegistrationService registrationService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		registrationService = new StudentRegistrationService();
	}

	//controller method for sign-up page rendering
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		registrationService.doRenderSignUpPage(req, resp);
	}

	//controller method for student registration
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		registrationService.doRegisterStudent(request, response);
	}

}
