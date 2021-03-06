package com.exam.controller.coordinator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.coordinator.CoordinatorCourseService;

@WebServlet("/Coordinator/Courses")
public class CoordinatorCourseController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CoordinatorCourseService coordinatorCourseService;

	@Override
	public void init() throws ServletException {
		super.init();
		coordinatorCourseService = new CoordinatorCourseService();
	}

	// controller endpoint to retrive coordinator course management page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		coordinatorCourseService.doLoadCoursePage(request, response);
	}

}
