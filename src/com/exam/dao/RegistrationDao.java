package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.exam.model.Login;
import com.exam.model.Registration;
import com.exam.model.Student;
import com.exam.utility.DbUtility;

public class RegistrationDao {

	private DbUtility dbUtility;

	public RegistrationDao() {
		this.dbUtility = new DbUtility();
	}

	// for handling database operations for student registration
	public void registerStudent(Student student, Login login) {

		Connection connection = null;
		PreparedStatement studentPreparedStatement = null, loginPreparedStatement = null,
				registrationPreparedStatement = null;

		try {

			connection = dbUtility.doGetDbConnection();

			connection.setAutoCommit(false);

			// student
			studentPreparedStatement = connection.prepareStatement(
					"insert into student (first_name, last_name, nic, mobile, course_id, address) values (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			studentPreparedStatement.setString(1, student.getFirstName());
			studentPreparedStatement.setString(2, student.getLastName());
			studentPreparedStatement.setString(3, student.getNic());
			studentPreparedStatement.setString(4, student.getMobile());
			studentPreparedStatement.setInt(5, student.getCourse().getCourseId());
			studentPreparedStatement.setString(6, student.getAddress());
			studentPreparedStatement.executeUpdate();

			int studentId = 0;
			ResultSet results = studentPreparedStatement.getGeneratedKeys();
			if (results.next()) {
				studentId = results.getInt(1);
			}

			// login
			loginPreparedStatement = connection.prepareStatement(
					"insert into login (user_name, password, admin_id, coodinator_id, student_id) values (?, ?, null, null, ?)");
			loginPreparedStatement.setString(1, login.getUserName());
			loginPreparedStatement.setString(2, login.getPassword());
			loginPreparedStatement.setInt(3, studentId);
			loginPreparedStatement.executeUpdate();

			registrationPreparedStatement = connection.prepareStatement(
					"insert into registration (requested_date_time, admin_approved, approved_date_time, payment_amount, payment_date_time,"
							+ " payment_status, mail_sent, registration_status, student_id) values (?, false, null, ?, null, false, false, false, ?)");
			registrationPreparedStatement.setString(1, LocalDateTime.now().toString());
			registrationPreparedStatement.setDouble(2, 12000.00);
			registrationPreparedStatement.setInt(3, studentId);
			registrationPreparedStatement.executeUpdate();

			connection.commit();

		} catch (Exception exc) {
			exc.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (studentPreparedStatement != null) {
				try {
					studentPreparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (loginPreparedStatement != null) {
				try {
					loginPreparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (registrationPreparedStatement != null) {
				try {
					registrationPreparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
