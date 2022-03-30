package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

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

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from student s inner join registration r on s.student_id = r.student_id where s.student_id = ?");) {

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				String n = rs.getString("requested_date_time").replace(' ', 'T');
				System.out.println(n);

				registration = new Registration(rs.getInt("registration_id"),
						LocalDateTime.parse(rs.getString("requested_date_time").replace(' ', 'T')),
						rs.getBoolean("admin_approved"),
						LocalDateTime.parse(rs.getString("approved_date_time").replace(' ', 'T')),
						rs.getDouble("payment_amount"),
						LocalDateTime.parse(rs.getString("payment_date_time").replace(' ', 'T')),
						rs.getBoolean("payment_status"), rs.getBoolean("mail_sent"),
						rs.getBoolean("registration_status"));

				student = new Student(rs.getInt("student_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("nic"), rs.getString("mobile"), rs.getString("address"), null, registration, null);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return student;
	}
}
