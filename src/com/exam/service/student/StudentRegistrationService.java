package com.exam.service.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.CourseDao;
import com.exam.dao.RegistrationDao;
import com.exam.model.Course;
import com.exam.model.Login;
import com.exam.model.Student;

public class StudentRegistrationService {

	private CourseDao courseDao;
	private RegistrationDao registrationDao;

	public StudentRegistrationService() {
		this.courseDao = new CourseDao();
		this.registrationDao = new RegistrationDao();
	}

	// for rendering sign-up page
	public void doRenderSignUpPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("registrationStatus", false);
		request.setAttribute("passwordDoesNotMatch", false);

		// fetch courses from database
		List<Course> courses = courseDao.findAll();

		// put in the request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_registration.jsp");
		dispatcher.forward(request, response);
	}

	// for student registration
	public void doRegisterStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = null;

		request.setAttribute("registrationStatus", false);
		request.setAttribute("passwordDoesNotMatch", false);

		// password doen't match
		if (!request.getParameter("password").equals(request.getParameter("re-password"))) {
			request.setAttribute("passwordDoesNotMatch", true);

			// normal registration flow
		} else {

			// assemble entities
			Student student = new Student(request.getParameter("fName"), request.getParameter("lName"),
					request.getParameter("nic"), request.getParameter("mobile"), request.getParameter("address"),
					new Course(Integer.parseInt(request.getParameter("course"))));
			Login login = new Login(request.getParameter("email"), request.getParameter("password"));

			// perform database opration
			registrationDao.registerStudent(student, login);

			// set model attributes
			request.setAttribute("registrationStatus", true);
		}

		dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_registration.jsp");
		dispatcher.forward(request, response);
	}

}
