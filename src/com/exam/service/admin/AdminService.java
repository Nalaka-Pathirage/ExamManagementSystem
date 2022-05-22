package com.exam.service.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.AdminDao;
import com.exam.dao.CoordinatorDao;
import com.exam.dao.LoginDao;
import com.exam.dao.RegistrationDao;
import com.exam.dao.StudentDao;
import com.exam.model.Coordinator;
import com.exam.model.Login;
import com.exam.model.Student;
import com.exam.utility.HelperUtility;
import com.exam.wrappers.RegistrationReportWrapper;

public class AdminService {

	private AdminDao adminDao;
	private RegistrationDao registrationDao;
	private StudentDao studentDao;
	private CoordinatorDao coordinatorDao;
	private LoginDao loginDao;

	public AdminService() {
		this.adminDao = new AdminDao();
		this.registrationDao = new RegistrationDao();
		this.studentDao = new StudentDao();
		this.coordinatorDao = new CoordinatorDao();
		this.loginDao = new LoginDao();
	}

	// for loading admin home page
	public void doLoadHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_home.jsp");
		dispatcher.forward(request, response);
	}

	// for loading admin home page
	public void doLoadAdminApprovalPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching pending approval, students
		List<Student> students = adminDao.getPendingAdminApprovals();

		// setting pending approval stduents inside request scope
		request.setAttribute("students", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_approvals.jsp");
		dispatcher.forward(request, response);
	}

	// approve or reject student registration
	public void approveOrRejectRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("decision") != null) {
			// accept registration
			if (request.getParameter("decision").equals("A")) {
				registrationDao.updateAdminApprovalStatus(Integer.parseInt(request.getParameter("studentId")));
				// reject registration
			} else {
				studentDao.delete(Integer.parseInt(request.getParameter("studentId")));
			}
		}

		// fetching pending approval, students
		List<Student> students = adminDao.getPendingAdminApprovals();

		// setting pending approval stduents inside request scope
		request.setAttribute("students", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_approvals.jsp");
		dispatcher.forward(request, response);

	}

	// loading coordinators page
	public void doLoadCoordinatorsPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch coordinators
		List<Coordinator> coordinators = coordinatorDao.findAll();

		// setting coordinators inside request scope
		request.setAttribute("coordinators", coordinators);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinators.jsp");
		dispatcher.forward(request, response);
	}

	// for loading payment page
	public void doLoadPaymentPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching pending payment, students
		List<Student> students = registrationDao.getPendingPaymentRecords();

		// setting pending approval stduents inside request scope
		request.setAttribute("students", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_payments.jsp");
		dispatcher.forward(request, response);
	}

	// load coordinator add page
	public void doLoadCoordinatorAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinator_add.jsp");
		dispatcher.forward(request, response);
	}

	// add coordinator
	public void doAddCoordinator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// :todo -> Transaction has not been handled properly!

		Coordinator coordinator = new Coordinator(request.getParameter("fName"), request.getParameter("lName"),
				request.getParameter("nic"), request.getParameter("mobile"));

		// insert coodinator
		Integer coordinatorId = coordinatorDao.insert(coordinator);

		Login login = new Login(request.getParameter("userName"), request.getParameter("password"), null,
				new Coordinator(coordinatorId), null);

		// insert credentials
		loginDao.insert(login);

		// fetch coordinators
		List<Coordinator> coordinators = coordinatorDao.findAll();

		// setting coordinators inside request scope
		request.setAttribute("coordinators", coordinators);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinators.jsp");
		dispatcher.forward(request, response);
	}

	// load coordinator edit page
	public void doLoadCoordinatorEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Coordinator coordinator = null;

		if (request.getParameter("coordinatorId") != null) {
			// fetch coodinator by id
			coordinator = coordinatorDao.getCoordinatorById(Integer.parseInt(request.getParameter("coordinatorId")));
		}

		// setting pending approval stduents inside request scope
		request.setAttribute("coordinator", coordinator);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinator_edit.jsp");
		dispatcher.forward(request, response);
	}

	// edit coordinator
	public void doEditCoordinator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// :todo -> Databe transaction has not been handle prperly here!

		Coordinator coordinator = new Coordinator(Integer.parseInt(request.getParameter("coordinatorId")),
				request.getParameter("fName"), request.getParameter("lName"), request.getParameter("nic"),
				request.getParameter("mobile"),
				request.getParameter("password") != null && request.getParameter("rePassword") != null
						? new Login(request.getParameter("userName"), request.getParameter("password"))
						: null);

		if (request.getParameter("password") != null && request.getParameter("rePassword") != null) {
			// update username/password
			loginDao.update(coordinator.getLogin());
		}

		// update coordinator info
		coordinatorDao.update(coordinator);

		// fetch coordinators
		List<Coordinator> coordinators = coordinatorDao.findAll();

		// setting coordinators inside request scope
		request.setAttribute("coordinators", coordinators);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinators.jsp");
		dispatcher.forward(request, response);
	}

	// delete coordinator
	public void doDeleteCoordinator(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("coordinatorId") != null) {
			// delete coordinator
			coordinatorDao.delete(Integer.parseInt(request.getParameter("coordinatorId")));
		}

		// fetch coordinators
		List<Coordinator> coordinators = coordinatorDao.findAll();

		// setting coordinators inside request scope
		request.setAttribute("coordinators", coordinators);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_coordinators.jsp");
		dispatcher.forward(request, response);
	}

	// render report page
	public void doLoadReportPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching data for visualizing
		RegistrationReportWrapper registrationReportWrapper = new RegistrationReportWrapper(
				registrationDao.getTotalRegistrations());

		// setting assembled data wrapper inside request scope
		request.setAttribute("registrationReportWrapper", registrationReportWrapper);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/admin_reports.jsp");
		dispatcher.forward(request, response);
	}

	// produce report data
	public void doDisplayReportData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching data for visualizing
		RegistrationReportWrapper registrationReportWrapper = new RegistrationReportWrapper(
				registrationDao.getTotalRegistrations());

		// serializing the model wrapper
		String payload = HelperUtility.serialize(registrationReportWrapper);

		response.getOutputStream().println(payload);

	}
}
