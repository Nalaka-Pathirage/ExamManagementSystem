package com.exam.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.LoginDao;
import com.exam.dao.StudentDao;
import com.exam.model.Login;
import com.exam.model.Registration;
import com.exam.model.Student;

public class AuthenticationService {

	private LoginDao loginDao;
	private StudentDao studentDao;

	public AuthenticationService() {
		this.loginDao = new LoginDao();
		this.studentDao = new StudentDao();
	}

	/**
	 * Handling user login
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("isAuthnticated", true);
		request.setAttribute("isAdminApproved", true);
		request.setAttribute("isPaymentCompleted", true);
		request.setAttribute("allClear", false);

		RequestDispatcher dispatcher = null;
		Login login = null;

		login = loginDao.getLoginByUsernameAndPassword(request.getParameter("username"),
				request.getParameter("password"));

		// handling correct username and password
		if (login != null) {
			dispatcher = routingUserLogin(request, login);

			// handling invalid usernme or password
		} else {
			request.setAttribute("isAuthnticated", false);
			dispatcher = request.getRequestDispatcher("/login.jsp");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * Handling user logout
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doLogout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * loading proper landing page for relevant user
	 * 
	 * @param request
	 * @param login
	 * @param dispatcher
	 */
	private RequestDispatcher routingUserLogin(HttpServletRequest request, Login login) {

		RequestDispatcher dispatcher;

		// admin login
		if (login.getAdmin() != null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_home.jsp");

			// coordinator login
		} else if (login.getCoordinator() != null) {
			dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_home.jsp");

			// student login
		} else {
			dispatcher = routingStudentOnRegistrationStatus(request, login);
		}

		return dispatcher;
	}

	/**
	 * handle student routing based on the resitration status after a successful
	 * login
	 * 
	 * @param request
	 * @param login
	 * @param dispatcher
	 */
	private RequestDispatcher routingStudentOnRegistrationStatus(HttpServletRequest request, Login login) {

		Student student = studentDao.getStudentById(login.getStudent().getStudentId());
		Registration registration = student.getRegistration();

		// admin approval is pending
		if (!registration.getAdminApproved()) {
			request.setAttribute("isAdminApproved", false);

			// payment is pending
		} else if (registration.getAdminApproved() && !registration.getPaymentStatus()) {
			request.setAttribute("isPaymentCompleted", false);

			// registration is clear
		} else {
			request.setAttribute("allClear", true);

		}

		return request.getRequestDispatcher("/WEB-INF/view/student/student_home.jsp");
	}
}
