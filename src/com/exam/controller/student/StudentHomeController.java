package com.exam.controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.student.StudentHomeService;

@WebServlet("/StudentHome")
public class StudentHomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentHomeService studentHomeService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.studentHomeService = new StudentHomeService();
	}

	// for retrieving student home page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		studentHomeService.doLoadHomePage(request, response);
	}

}
