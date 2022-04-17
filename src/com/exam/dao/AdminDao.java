package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Admin;
import com.exam.model.Course;
import com.exam.model.Registration;
import com.exam.model.Student;
import com.exam.utility.DbUtility;

public class AdminDao {

	private DbUtility dbUtility;

	public AdminDao() {
		this.dbUtility = new DbUtility();
	}

	// fetching admin by id
	public Admin getAdminById(int id) {

		Admin admin = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from admin where admin_id = ?");) {

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {
				admin = new Admin(rs.getInt("admin_id"), rs.getString("admin_name"), rs.getString("admin_nic"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return admin;
	}

	// fetching pending approval students list
	public List<Student> getPendingAdminApprovals() {

		List<Student> students = new ArrayList<Student>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from registration reg \n"
						+ "inner join student st on reg.student_id = st.student_id\n"
						+ "inner join course co on co.course_id = st.course_id\n"
						+ "where reg.admin_approved = '0';");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {
				Student student = new Student(rs.getInt("student_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), rs.getString("address"),
						null,
						new Registration(rs.getInt("registration_id"),
								LocalDateTime.parse(rs.getString("requested_date_time").replace(' ', 'T'))),
						new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name")));
				students.add(student);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return students;
	}

}
