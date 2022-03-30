package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.model.Admin;
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
}
