package com.exam.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Course;
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

	// updating the admin approval status
	public void updateAdminApprovalStatus(int studentId) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("update registration set admin_approved='1' where student_id=?");) {

			preparedStatement.setInt(1, studentId);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// find records with pending payment status
	public List<Student> getPendingPaymentRecords() {

		List<Student> students = new ArrayList<Student>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from registration reg \n"
						+ "inner join student st on reg.student_id = st.student_id\n"
						+ "inner join course co on co.course_id = st.course_id\n"
						+ "where reg.payment_status = '0' and reg.admin_approved = '1';");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {
				Student student = new Student(rs.getInt("student_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), rs.getString("address"),
						null,
						new Registration(rs.getInt("registration_id"),
								LocalDateTime.parse(rs.getString("approved_date_time").replace(' ', 'T')),
								rs.getDouble("payment_amount"), rs.getBoolean("mail_sent")),
						new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name")));
				students.add(student);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

	// insert file
	public void insertFile(int studentId, InputStream inputStream) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("update registration set payment_status = 1, registration_status = 1,"
								+ " payment_receipt = ? where student_id = ?;");) {

			preparedStatement.setBlob(1, inputStream);
			preparedStatement.setInt(2, studentId);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
