package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Course;
import com.exam.model.Registration;
import com.exam.model.Student;
import com.exam.utility.DbUtility;

public class StudentDao {

	private DbUtility dbUtility;

	public StudentDao() {
		this.dbUtility = new DbUtility();
	}

	// fetch user from database by student id
	public Student getStudentById(int id) {

		Student student = null;
		Registration registration = null;
		Course course = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from student s inner join registration r on s.student_id = r.student_id "
								+ "inner join course c on c.course_id = s.course_id where s.student_id = ?");) {

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				registration = new Registration(rs.getInt("registration_id"),
						LocalDateTime.parse(rs.getString("requested_date_time").replace(' ', 'T')),
						rs.getBoolean("admin_approved"),
						rs.getString("approved_date_time") != null
								? LocalDateTime.parse(rs.getString("approved_date_time").replace(' ', 'T'))
								: null,
						rs.getDouble("payment_amount"),
						rs.getString("payment_date_time") != null
								? LocalDateTime.parse(rs.getString("payment_date_time").replace(' ', 'T'))
								: null,
						rs.getBoolean("payment_status"), rs.getBoolean("mail_sent"),
						rs.getBoolean("registration_status"));

				course = new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
						rs.getDouble("duration"), LocalDate.parse(rs.getString("start").replace(' ', 'T')),
						rs.getString("description"), rs.getDouble("fee"));

				student = new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("nic"), rs.getString("mobile"), rs.getString("address"), null, registration,
						course);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	// deleting student
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from student where student_id = ?");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// find all students with success registration status
	public List<Student> findByRegistrationSuccessStatus() {

		List<Student> students = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from student s inner join registration r on r.student_id = s.student_id\n"
								+ "inner join course c on c.course_id = s.course_id where r.registration_status = '1';");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Course course = new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"));

				Registration registration = new Registration(rs.getInt("registration_id"),
						LocalDateTime.parse(rs.getString("requested_date_time").replace(' ', 'T')),
						rs.getBoolean("admin_approved"),
						rs.getString("approved_date_time") != null
								? LocalDateTime.parse(rs.getString("approved_date_time").replace(' ', 'T'))
								: null,
						rs.getDouble("payment_amount"),
						rs.getString("payment_date_time") != null
								? LocalDateTime.parse(rs.getString("payment_date_time").replace(' ', 'T'))
								: null,
						rs.getBoolean("payment_status"), rs.getBoolean("mail_sent"),
						rs.getBoolean("registration_status"));

				Student student = new Student(rs.getInt("student_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), rs.getString("address"),
						null, registration, course);

				students.add(student);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
}
