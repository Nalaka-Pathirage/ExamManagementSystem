package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorBatchService;

@WebServlet("/Coordinator/BatchEdit")
public class CoordinatorBatchEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorBatchService coordinatorBatchService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorBatchService = new CoordinatorBatchService();
	}

	// retrive coordinator batch edit page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorBatchService.doLoadBatchEditPage(request, response);
	}

	// edit requested batch
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorBatchService.doEditBatch(request, response);
	}

}
