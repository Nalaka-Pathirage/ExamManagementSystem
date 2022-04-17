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

	// insert login
	public void insert(Login login) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into login (user_name, password, admin_id, coodinator_id, student_id) values (?, ?, ?, ?, ?)");) {

			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassword());

			if (login.getAdmin() != null) {
				preparedStatement.setInt(3, login.getAdmin().getAdminId());
				preparedStatement.setString(4, null);
				preparedStatement.setString(5, null);
			} else if (login.getCoordinator() != null) {
				preparedStatement.setString(3, null);
				preparedStatement.setInt(4, login.getCoordinator().getCoordinatorId());
				preparedStatement.setString(5, null);
			} else {
				preparedStatement.setString(3, null);
				preparedStatement.setString(4, null);
				preparedStatement.setInt(5, login.getStudent().getStudentId());
			}

			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update login password
	public void update(Login login) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("update login set password = ? where user_name = ?;");) {

			preparedStatement.setString(1, login.getPassword());
			preparedStatement.setString(2, login.getUserName());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
