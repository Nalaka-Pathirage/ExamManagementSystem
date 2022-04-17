package com.exam.service.student;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.exam.dao.RegistrationDao;
import com.exam.model.Student;

public class StudentPaymentService {

	private RegistrationDao registrationDao;

	public StudentPaymentService() {
		this.registrationDao = new RegistrationDao();
	}

	// proceed payment receipt submission
	public void doSubmitPayment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// obtaining http session
		HttpSession session = request.getSession();
		// obtaining logged in student
		Student student = (Student) session.getAttribute("loggedInUser");

		InputStream inputStream = null;

		// obtaining uploaded file part of multipart request
		Part filePart = request.getPart("paymentReceipt");

		if (filePart != null) {
			// extracting input stream
			inputStream = filePart.getInputStream();
			// persiting in database
			registrationDao.insertFile(student.getStudentId(), inputStream);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student_home.jsp");
		dispatcher.forward(request, response);
	}
}
