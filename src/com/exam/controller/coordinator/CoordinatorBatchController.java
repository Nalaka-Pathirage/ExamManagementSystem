package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorBatchService;

@WebServlet("/Coordinator/Batches")
public class CoordinatorBatchController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorBatchService coordinatorBatchService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorBatchService = new CoordinatorBatchService();
	}

	// retrive coordinator batches management page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorBatchService.doLoadBatchHomePage(request, response);
	}

}
