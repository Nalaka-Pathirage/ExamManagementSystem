package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Course;
import com.exam.model.Lecturer;
import com.exam.model.Subject;
import com.exam.utility.DbUtility;

public class SubjectDao {

	private DbUtility dbUtility;

	public SubjectDao() {
		this.dbUtility = new DbUtility();
	}

	public Subject findById(int id) {

		Subject subject = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from subject sub left outer join course cou on sub.course_id = cou.course_id"
								+ " left outer join lecturer lec on lec.subject_id = sub.subject_id where sub.subject_id = ?;");) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				Course course = new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"),
						rs.getString("start") != null ? LocalDateTime.parse(rs.getString("start").replace(' ', 'T'))
								: null,
						rs.getString("description"), rs.getDouble("fee"));

				Lecturer lecturer = new Lecturer(rs.getInt("lecturer_id"), rs.getString("lecturer_name"),
						rs.getString("subject_stream"), rs.getString("highest_qualification"), rs.getString("mobile"));

				subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), course, lecturer);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return subject;
	}

	// get all subjeccts
	public List<Subject> findAll() {

		List<Subject> subjects = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from subject sub left outer join course cou on sub.course_id = cou.course_id"
								+ " left outer join lecturer lec on lec.subject_id = sub.subject_id;");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Course course = new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"),
						rs.getString("start") != null ? LocalDateTime.parse(rs.getString("start").replace(' ', 'T'))
								: null,
						rs.getString("description"), rs.getDouble("fee"));

				Lecturer lecturer = new Lecturer(rs.getInt("lecturer_id"), rs.getString("lecturer_name"),
						rs.getString("subject_stream"), rs.getString("highest_qualification"), rs.getString("mobile"));

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), course, lecturer);

				subjects.add(subject);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return subjects;
	}

	// insert subject
	public void insert(Subject subject) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into subject (subject_name, subject_code) values (?, ?);");) {

			preparedStatement.setString(1, subject.getSubjectName());
			preparedStatement.setString(2, subject.getSubjectCode());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update subject
	public void update(Subject subject) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update subject set subject_name = ?, subject_code = ? where subject_id = ?;");) {

			preparedStatement.setString(1, subject.getSubjectName());
			preparedStatement.setString(2, subject.getSubjectCode());
			preparedStatement.setInt(3, subject.getSubjectId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete subject
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from subject where subject_id = ?");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
