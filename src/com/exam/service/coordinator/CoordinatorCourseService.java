package com.exam.service.coordinator;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.CourseDao;
import com.exam.model.Course;

public class CoordinatorCourseService {

	private CourseDao courseDao;

	public CoordinatorCourseService() {
		this.courseDao = new CourseDao();
	}

	// loading coordinator course management page
	public void doLoadCoursePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// retrieve all available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course.jsp");
		dispatcher.forward(request, response);
	}

	// loading courses add page
	public void doLoadCourseAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course_add.jsp");
		dispatcher.forward(request, response);
	}

	// adding course
	public void doAddCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assemble course instance to be edited
		Course course = new Course(request.getParameter("courseCode"), request.getParameter("courseName"),
				Double.parseDouble(request.getParameter("courseDuration")),
				LocalDate.parse(request.getParameter("courseStart")), request.getParameter("courseDescription"),
				Double.parseDouble(request.getParameter("courseFee")));

		// persist course instance
		courseDao.insert(course);

		// retrieve all available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course.jsp");
		dispatcher.forward(request, response);
	}

	// loading course edit page
	public void doLoadCourseEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// find requested course
		Course course = courseDao.findById(Integer.parseInt(request.getParameter("courseId")));

		// setting courses inside request scope
		request.setAttribute("course", course);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course_edit.jsp");
		dispatcher.forward(request, response);
	}

	// editing course
	public void doEditCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assemble course instance to be edited
		Course course = new Course(Integer.parseInt(request.getParameter("courseId")),
				request.getParameter("courseCode"), request.getParameter("courseName"),
				Double.parseDouble(request.getParameter("courseDuration")),
				LocalDate.parse(request.getParameter("courseStart")), request.getParameter("courseDescription"),
				Double.parseDouble(request.getParameter("courseFee")));

		// update exisitng course instance
		courseDao.update(course);

		// retrieve all available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course.jsp");
		dispatcher.forward(request, response);
	}

	// deleting course
	public void doDeleteCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// delete course
		courseDao.delete(Integer.parseInt(request.getParameter("courseId")));

		// retrieve all available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_course.jsp");
		dispatcher.forward(request, response);
	}
}
