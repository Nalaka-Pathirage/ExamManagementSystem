package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.model.Coordinator;
import com.exam.utility.DbUtility;

public class CoordinatorDao {

	private DbUtility dbUtility;

	public CoordinatorDao() {
		this.dbUtility = new DbUtility();
	}

	// fetch coordinator from database by id
	public Coordinator getCoordinatorById(int id) {

		Coordinator coordinator = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from coordinator where coordinator_id = ?");) {

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {
				coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return coordinator;
	}
}
