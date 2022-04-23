package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Course;
import com.exam.utility.DbUtility;

public class CourseDao {

	private DbUtility dbUtility;

	public CourseDao() {
		this.dbUtility = new DbUtility();
	}

	// fetch all courses
	public List<Course> findAll() {

		List<Course> courses = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from course");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {
				courses.add(new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"), LocalDate.parse(rs.getString("start").replace(' ', 'T')),
						rs.getString("description"), rs.getDouble("fee")));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return courses;
	}

	// find course by id
	public Course findById(int id) {

		Course course = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from course where course_id = ?;");) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {
				course = new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"), LocalDate.parse(rs.getString("start").replace(' ', 'T')),
						rs.getString("description"), rs.getDouble("fee"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return course;
	}

	// insert course
	public void insert(Course course) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into course (code, name, duration, start, description, fee) values (?, ?, ?, ?, ?, ?);");) {

			preparedStatement.setString(1, course.getCode());
			preparedStatement.setString(2, course.getName());
			preparedStatement.setDouble(3, course.getDuration());
			preparedStatement.setString(4, course.getStart().toString());
			preparedStatement.setString(5, course.getDescription());
			preparedStatement.setDouble(6, course.getFee());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update course
	public void update(Course course) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update course set code = ?, name = ?, duration = ?, start = ?, description = ?, fee = ? where course_id = ?;");) {

			preparedStatement.setString(1, course.getCode());
			preparedStatement.setString(2, course.getName());
			preparedStatement.setDouble(3, course.getDuration());
			preparedStatement.setString(4, course.getStart().toString());
			preparedStatement.setString(5, course.getDescription());
			preparedStatement.setDouble(6, course.getFee());
			preparedStatement.setInt(7, course.getCourseId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete course
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from course where course_id = ?");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
