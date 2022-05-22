package com.exam.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.admin.AdminService;

@WebServlet("/Admin/Reports")
public class AdminReportController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AdminService adminService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.adminService = new AdminService();
	}

	// retrive admin home page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		adminService.doLoadReportPage(request, response);
	}

}
