package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Coordinator;
import com.exam.model.Login;
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
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from coodinator co inner join login lo on co.coordinator_id = lo.coodinator_id where coordinator_id = ?");) {

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {
				coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"),
						new Login(rs.getString("user_name"), null));
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return coordinator;
	}

	// fetching all coordinators
	public List<Coordinator> findAll() {

		List<Coordinator> coordinators = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from coodinator co inner join login "
								+ "lo on co.coordinator_id = lo.coodinator_id;");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {
				Coordinator coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"),
						new Login(rs.getString("user_name"), null));
				coordinators.add(coordinator);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return coordinators;
	}

	// insert coordinator
	public int insert(Coordinator coordinator) {

		int coordinatorId = 0;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into coodinator (first_name, last_name, nic, mobile) values (?, ?, ?, ?);",
						Statement.RETURN_GENERATED_KEYS);) {

			preparedStatement.setString(1, coordinator.getFirstName());
			preparedStatement.setString(2, coordinator.getLastName());
			preparedStatement.setString(3, coordinator.getNic());
			preparedStatement.setString(4, coordinator.getMobile());
			preparedStatement.executeUpdate();

			ResultSet results = preparedStatement.getGeneratedKeys();
			if (results.next()) {
				coordinatorId = results.getInt(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return coordinatorId;
	}

	// update coordinator
	public void update(Coordinator coordinator) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update coodinator set first_name = ?, last_name = ?, nic = ?, mobile = ? where coordinator_id = ?;");) {

			preparedStatement.setString(1, coordinator.getFirstName());
			preparedStatement.setString(2, coordinator.getLastName());
			preparedStatement.setString(3, coordinator.getNic());
			preparedStatement.setString(4, coordinator.getMobile());
			preparedStatement.setInt(5, coordinator.getCoordinatorId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete coordinator
	public void delete(int coordinatorId) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from coodinator where coordinator_id = ?;");) {

			preparedStatement.setInt(1, coordinatorId);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
