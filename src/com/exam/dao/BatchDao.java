package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Batch;
import com.exam.model.Course;
import com.exam.utility.DbUtility;

public class BatchDao {

	private DbUtility dbUtility;

	public BatchDao() {
		this.dbUtility = new DbUtility();
	}

	// find batch by id
	public Batch findById(int id) {

		Batch batch = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from batch b inner join course c on b.course_id = c.course_id where b.batch_id = ?;");) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				batch = new Batch(rs.getInt("batch_id"), rs.getString("batch_name"), rs.getString("batch_code"),
						new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
								rs.getDouble("duration"), LocalDate.parse(rs.getString("start").replace(' ', 'T')),
								rs.getString("description"), rs.getDouble("fee")));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return batch;
	}

	// get all batches
	public List<Batch> findAll() {

		List<Batch> batches = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from batch b inner join course c on b.course_id = c.course_id;");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Batch batch = new Batch(rs.getInt("batch_id"), rs.getString("batch_name"), rs.getString("batch_code"),
						new Course(rs.getInt("course_id"), rs.getString("code"), rs.getString("name"),
								rs.getDouble("duration"), LocalDate.parse(rs.getString("start").replace(' ', 'T')),
								rs.getString("description"), rs.getDouble("fee")));

				batches.add(batch);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return batches;
	}

	// insert batch
	public void insert(Batch batch) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into batch (batch_name, batch_code, course_id) values (?, ?, ?)");) {

			preparedStatement.setString(1, batch.getBatchName());
			preparedStatement.setString(2, batch.getBatchCode());
			preparedStatement.setInt(3, batch.getCourse().getCourseId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update batch
	public void update(Batch batch) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update batch set batch_name = ?, batch_code = ?, course_id = ? where batch_id = ?;");) {

			preparedStatement.setString(1, batch.getBatchName());
			preparedStatement.setString(2, batch.getBatchCode());
			preparedStatement.setInt(3, batch.getCourse().getCourseId());
			preparedStatement.setInt(4, batch.getBatchId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete batch
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from batch where batch_id = ?");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
