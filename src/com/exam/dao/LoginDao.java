package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.model.Admin;
import com.exam.model.Coordinator;
import com.exam.model.Login;
import com.exam.model.Student;
import com.exam.utility.DbUtility;

public class LoginDao {

	private DbUtility dbUtility;

	public LoginDao() {
		this.dbUtility = new DbUtility();
	}

	// fetch user from database using username & password
	public Login getLoginByUsernameAndPassword(String username, String password) {

		Login login = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from login where user_name = ? and password = ? ");) {

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				login = new Login(rs.getString("user_name"), rs.getString("password"),
						rs.getInt("admin_id") != 0 ? new Admin(rs.getInt("admin_id")) : null,
						rs.getInt("coodinator_id") != 0 ? new Coordinator(rs.getInt("coodinator_id")) : null,
						rs.getInt("student_id") != 0 ? new Student(rs.getInt("student_id")) : null);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return login;
	}

}
