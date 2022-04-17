package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Lecturer;
import com.exam.model.Subject;
import com.exam.utility.DbUtility;

public class LecturerDao {

	private DbUtility dbUtility;

	public LecturerDao() {
		this.dbUtility = new DbUtility();
	}

	//find lecturer by id
	public Lecturer findById(int id) {

		Lecturer lecturer = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from lecturer lec inner join subject su on lec.subject_id = su.subject_id where lec.lecturer_id = ?;");) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {
				
				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"));
				
				lecturer = new Lecturer(rs.getInt("lecturer_id"), rs.getString("lecturer_name"),
						rs.getString("subject_stream"), rs.getString("highest_qualification"), rs.getString("mobile"),
						subject);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lecturer;
	}

	// get all lecturers
	public List<Lecturer> findAll() {

		List<Lecturer> lecturers = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from lecturer lec inner join subject su on lec.subject_id = su.subject_id;");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"));

				Lecturer lecturer = new Lecturer(rs.getInt("lecturer_id"), rs.getString("lecturer_name"),
						rs.getString("subject_stream"), rs.getString("highest_qualification"), rs.getString("mobile"),
						subject);

				lecturers.add(lecturer);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lecturers;
	}

	// insert lecturer
	public void insert(Lecturer lecturer) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into lecturer (lecturer_name, subject_stream, highest_qualification, mobile, subject_id) values (?, ?, ?, ?, ?)");) {

			preparedStatement.setString(1, lecturer.getLecturerName());
			preparedStatement.setString(2, lecturer.getSubjectStream());
			preparedStatement.setString(3, lecturer.getHighestQualification());
			preparedStatement.setString(4, lecturer.getMobile());
			preparedStatement.setInt(5, lecturer.getSubject().getSubjectId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update lecturer
	public void update(Lecturer lecturer) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update lecturer set lecturer_name = ?, subject_stream = ?, highest_qualification = ?, mobile = ?,"
								+ " subject_id = ? where lecturer_id = ?;");) {

			preparedStatement.setString(1, lecturer.getLecturerName());
			preparedStatement.setString(2, lecturer.getSubjectStream());
			preparedStatement.setString(3, lecturer.getHighestQualification());
			preparedStatement.setString(4, lecturer.getMobile());
			preparedStatement.setInt(5, lecturer.getSubject().getSubjectId());
			preparedStatement.setInt(6, lecturer.getLecturerId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete lecturer
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from lecturer where lecturer_id = ?");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
