package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorBatchService;

@WebServlet("/CoordinatorBatches")
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

		coordinatorBatchService.doLoadBatchPage(request, response);
	}

	// submit batch
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// to be implemented
	}

}
