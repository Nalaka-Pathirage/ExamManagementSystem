package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorApprovalService;

@WebServlet("/CoordinatorApprovals")
public class CoordinatorApprovalController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorApprovalService coordinatorApprovalService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorApprovalService = new CoordinatorApprovalService();
	}

	// retrive admin approval page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorApprovalService.doLoadApprovalPage(request, response);
	}

	// submit admin approval
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// to be implemented
	}

}
