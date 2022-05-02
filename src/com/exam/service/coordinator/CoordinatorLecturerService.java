package com.exam.service.coordinator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.LecturerDao;
import com.exam.dao.SubjectDao;
import com.exam.model.Lecturer;
import com.exam.model.Subject;

public class CoordinatorLecturerService {

	private LecturerDao lecturerDao;
	private SubjectDao subjectDao;

	public CoordinatorLecturerService() {
		this.lecturerDao = new LecturerDao();
		this.subjectDao = new SubjectDao();
	}

	// load coordinator lecturer page
	public void doLoadLecturerPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available lecturers
		List<Lecturer> lecturers = lecturerDao.findAll();

		// setting lecturers inside request scope
		request.setAttribute("lecturers", lecturers);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer.jsp");
		dispatcher.forward(request, response);
	}

	// load lecturer add page
	public void doLoadLecturerAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available courses
		List<Subject> subjects = subjectDao.findAll();

		// setting subjects inside request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer_add.jsp");
		dispatcher.forward(request, response);
	}

	// insert new lecturer
	public void doSubmitLecturer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Lecturer lecturer = new Lecturer(request.getParameter("fullName"), request.getParameter("stream"),
				request.getParameter("qualification"), request.getParameter("mobile"),
				new Subject(Integer.parseInt(request.getParameter("course"))));

		// persisting lecturer instance
		lecturerDao.insert(lecturer);

		// fetch all available lecturers
		List<Lecturer> lecturers = lecturerDao.findAll();

		// setting lecturers inside request scope
		request.setAttribute("lecturers", lecturers);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer.jsp");
		dispatcher.forward(request, response);
	}

	// load lecturer edit page
	public void doLoadLecturerEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch lecturer to be edited
		Lecturer lecturer = lecturerDao.findById(Integer.parseInt(request.getParameter("lecturerId")));
		// fetch all available subjects
		List<Subject> subjects = subjectDao.findAll();

		// setting required, request scope params
		request.setAttribute("lecturer", lecturer);
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer_edit.jsp");
		dispatcher.forward(request, response);
	}

	// edit lecturer
	public void doEditLecturer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Lecturer lecturer = new Lecturer(Integer.parseInt(request.getParameter("lecturerId")), request.getParameter("fullName"), request.getParameter("stream"),
				request.getParameter("qualification"), request.getParameter("mobile"),
				new Subject(Integer.parseInt(request.getParameter("course"))));

		// edit lecturer
		lecturerDao.update(lecturer);

		// fetch all available lecturers
		List<Lecturer> lecturers = lecturerDao.findAll();

		// setting lecturers inside request scope
		request.setAttribute("lecturers", lecturers);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer.jsp");
		dispatcher.forward(request, response);
	}

	// delete lecturer
	public void doDeleteLecturer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// delete lecturer
		lecturerDao.delete(Integer.parseInt(request.getParameter("lecturerId")));

		// fetch all available lecturers
		List<Lecturer> lecturers = lecturerDao.findAll();

		// setting lecturers inside request scope
		request.setAttribute("lecturers", lecturers);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_lecturer.jsp");
		dispatcher.forward(request, response);
	}
}
