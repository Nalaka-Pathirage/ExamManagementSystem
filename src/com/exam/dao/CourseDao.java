package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Course;
import com.exam.utility.DbUtility;

public class CourseDao {

	private DbUtility dbUtility;

	public CourseDao() {
		this.dbUtility = new DbUtility();
	}

	// fetching all courses
	public List<Course> findAll() {

		List<Course> courses = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from course");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {
				courses.add(new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"), LocalDateTime.parse(rs.getString("start").replace(' ', 'T')),
						rs.getString("description"), rs.getDouble("fee")));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return courses;
	}
}
