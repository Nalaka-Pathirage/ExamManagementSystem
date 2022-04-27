package com.exam.service.coordinator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.StudentDao;
import com.exam.model.Student;

public class CoordinatorHomeService {

	private StudentDao studentDao;

	public CoordinatorHomeService() {
		this.studentDao = new StudentDao();
	}

	// for loading coordinator home page
	public void doLoadHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all registration completed students
		List<Student> students = studentDao.findByRegistrationSuccessStatus();

		// setting students in request scope
		request.setAttribute("students", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_home.jsp");
		dispatcher.forward(request, response);
	}
}
