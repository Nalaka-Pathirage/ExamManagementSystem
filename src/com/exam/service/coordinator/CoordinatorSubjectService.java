package com.exam.service.coordinator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.CourseDao;
import com.exam.dao.SubjectDao;
import com.exam.model.Course;
import com.exam.model.Subject;

public class CoordinatorSubjectService {

	private SubjectDao subjectDao;
	private CourseDao courseDao;

	public CoordinatorSubjectService() {
		this.subjectDao = new SubjectDao();
		this.courseDao = new CourseDao();
	}

	// load coordinator subject home page
	public void doLoadSubjectPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available subjects
		List<Subject> subjects = subjectDao.findAll();

		// setting subjects inside request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject.jsp");
		dispatcher.forward(request, response);
	}

	// load subject adding page
	public void doLoadSujectAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject_add.jsp");
		dispatcher.forward(request, response);
	}

	// insert subject
	public void doAddSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assemblling subject instance
		Subject subject = new Subject(request.getParameter("subjectName"), request.getParameter("subjectCode"),
				request.getParameter("course") != null && !request.getParameter("course").equals("Select Course")
						? new Course(Integer.parseInt(request.getParameter("course")))
						: null);

		// persisting subject in database
		subjectDao.insert(subject);

		// fetch all available subjects
		List<Subject> subjects = subjectDao.findAll();

		// setting subjects inside request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject.jsp");
		dispatcher.forward(request, response);
	}

	// load subject edit page
	public void doLoadSubjectEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch subject to be edited
		Subject subject = subjectDao.findById(Integer.parseInt(request.getParameter("subjectId")));

		// fetch available courses
		List<Course> courses = courseDao.findAll();

		// setting subject inside request scope
		request.setAttribute("subject", subject);

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject_edit.jsp");
		dispatcher.forward(request, response);
	}

	// edit subject
	public void doEditSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assemblling subject instance to edit
		Subject subject = new Subject(Integer.parseInt(request.getParameter("subjectId")),
				request.getParameter("subjectName"), request.getParameter("subjectCode"),
				request.getParameter("course") != null ? new Course(Integer.parseInt(request.getParameter("course")))
						: null);

		// edit subject instance
		subjectDao.update(subject);

		// fetch all available subjects
		List<Subject> subjects = subjectDao.findAll();

		// setting subjects inside request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject.jsp");
		dispatcher.forward(request, response);
	}

	// delete subject
	public void doDeleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// delete requested subject
		subjectDao.delete(Integer.parseInt(request.getParameter("subjectId")));

		// fetch all available subjects
		List<Subject> subjects = subjectDao.findAll();

		// setting subjects inside request scope
		request.setAttribute("subjects", subjects);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_subject.jsp");
		dispatcher.forward(request, response);
	}
}
