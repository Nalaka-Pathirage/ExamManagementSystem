package com.exam.controller.landing;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.service.LandingService;

@WebServlet("/landing")
public class LandingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private LandingService landingService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.landingService = new LandingService();
	}

	// controller endpoint for retrieving landing page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		landingService.doLoadLandingPage(request, response);
	}

}
