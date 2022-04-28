package com.exam.service.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.dao.StudentDao;
import com.exam.model.Student;

public class StudentHomeService {

	private StudentDao studentDao;

	public StudentHomeService() {
		this.studentDao = new StudentDao();
	}

	// for loading student home page
	public void doLoadHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch loggedIn student from current session
		HttpSession session = request.getSession();
		Student studentId = (Student) session.getAttribute("loggedInUser");

		// setting clear registration status
		request.setAttribute("allClear", true);

		// fetch logged in student details
		Student student = studentDao.getStudentById(studentId.getStudentId());

		// setting student in request instance
		request.setAttribute("student", student);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_home.jsp");
		dispatcher.forward(request, response);
	}
}
