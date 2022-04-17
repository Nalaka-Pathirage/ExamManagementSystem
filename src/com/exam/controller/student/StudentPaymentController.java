package com.exam.controller.student;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.student.StudentPaymentService;

@WebServlet("/Student/Payment")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class StudentPaymentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentPaymentService studentPaymentService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.studentPaymentService = new StudentPaymentService();
	}

	// controller method for handling student payments, via file upload
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		studentPaymentService.doSubmitPayment(request, response);
	}

}
