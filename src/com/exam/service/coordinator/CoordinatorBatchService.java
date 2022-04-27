package com.exam.service.coordinator;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exam.dao.BatchDao;
import com.exam.dao.CourseDao;
import com.exam.model.Batch;
import com.exam.model.Course;

public class CoordinatorBatchService {

	private BatchDao batchDao;
	private CourseDao courseDao;

	public CoordinatorBatchService() {
		this.batchDao = new BatchDao();
		this.courseDao = new CourseDao();
	}

	// for loading coordinator batch management page
	public void doLoadBatchHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available batches
		List<Batch> batches = batchDao.findAll();

		// setting batches inside request scope
		request.setAttribute("batches", batches);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch.jsp");
		dispatcher.forward(request, response);
	}

	// load batch add page
	public void doLoadBatchAddPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch all available courses
		List<Course> courses = courseDao.findAll();

		// setting courses inside request scope
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch_add.jsp");
		dispatcher.forward(request, response);
	}

	// insert new batch
	public void doSubmitBatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assembling batch instance persisted
		Batch batch = new Batch(request.getParameter("batchName"), request.getParameter("batchCode"),
				new Course(Integer.parseInt(request.getParameter("course"))));

		// persisting batch instance
		batchDao.insert(batch);

		// fetch all available batches
		List<Batch> batches = batchDao.findAll();

		// setting batches inside request scope
		request.setAttribute("batches", batches);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch.jsp");
		dispatcher.forward(request, response);
	}

	// load batch edit page
	public void doLoadBatchEditPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetch batch to be edited
		Batch batch = batchDao.findById(Integer.parseInt(request.getParameter("batchId")));

		// fetch all available courses
		List<Course> courses = courseDao.findAll();

		// setting required, request scope params
		request.setAttribute("batch", batch);
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch_edit.jsp");
		dispatcher.forward(request, response);
	}

	// edit batch
	public void doEditBatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// assembling batch instance to edit
		Batch batch = new Batch(Integer.parseInt(request.getParameter("batchId")), request.getParameter("batchName"),
				request.getParameter("batchCode"), new Course(Integer.parseInt(request.getParameter("course"))));

		// edit lecturer
		batchDao.update(batch);

		// fetch all available lecturers
		List<Batch> batches = batchDao.findAll();

		// setting batches inside request scope
		request.setAttribute("batches", batches);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch.jsp");
		dispatcher.forward(request, response);
	}

	// delete batch
	public void doDeleteBatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// delete lecturer
		batchDao.delete(Integer.parseInt(request.getParameter("batchId")));

		// fetch all available lecturers
		List<Batch> batches = batchDao.findAll();

		// setting lecturers inside request scope
		request.setAttribute("batches", batches);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/coordinator/coordinator_batch.jsp");
		dispatcher.forward(request, response);
	}
}
