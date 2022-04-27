package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Coordinator;
import com.exam.model.ExamQuiz;
import com.exam.model.Subject;
import com.exam.utility.DbUtility;

public class ExamQuizDao {

	private DbUtility dbUtility;

	public ExamQuizDao() {
		this.dbUtility = new DbUtility();
	}

	// find exam/quiz by id
	public ExamQuiz findById(int id) {

		ExamQuiz examQuiz = null;

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from exam_quiz eq inner join subject s on s.subject_id = eq.subject_id"
								+ " inner join coodinator c on c.coordinator_id = eq.added_by where exam_quiz_id = ?;");) {

			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next() != false) {

				Coordinator coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), null);

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"), rs.getString("type"),
						LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')), coordinator,
						rs.getString("questions"), subject);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return examQuiz;
	}

	// get all exams/quizes
	public List<ExamQuiz> findAll() {

		List<ExamQuiz> examQuizes = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from exam_quiz eq inner join subject s on s.subject_id = eq.subject_id "
								+ "inner join coordinator c on c.coordinator_id = eq.added_by");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Coordinator coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), null);

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				ExamQuiz examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"),
						rs.getString("type"), LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')),
						coordinator, rs.getString("questions"), subject);

				examQuizes.add(examQuiz);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return examQuizes;
	}

	// get all exams
	public List<ExamQuiz> findAllExams() {

		List<ExamQuiz> examQuizes = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from exam_quiz eq inner join subject s on s.subject_id = eq.subject_id "
								+ "inner join coodinator c on c.coordinator_id = eq.added_by where eq.type = 'E'");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Coordinator coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), null);

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				ExamQuiz examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"),
						rs.getString("type"), LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')),
						coordinator, rs.getString("questions"), subject);

				examQuizes.add(examQuiz);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return examQuizes;
	}

	// get all quizes
	public List<ExamQuiz> findAllQuizes() {

		List<ExamQuiz> examQuizes = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from exam_quiz eq inner join subject s on s.subject_id = eq.subject_id "
								+ "inner join coodinator c on c.coordinator_id = eq.added_by where eq.type = 'Q'");) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Coordinator coordinator = new Coordinator(rs.getInt("coordinator_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getString("nic"), rs.getString("mobile"), null);

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				ExamQuiz examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"),
						rs.getString("type"), LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')),
						coordinator, rs.getString("questions"), subject);

				examQuizes.add(examQuiz);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return examQuizes;
	}

	// insert exam/quizes
	public void insert(ExamQuiz examQuiz) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into exam_quiz (exam_quiz_name,"
								+ " type, added_on, added_by, questions, subject_id) values (?, ?, ?, ?, ?, ?);");) {

			preparedStatement.setString(1, examQuiz.getExamQuizName());
			preparedStatement.setString(2, examQuiz.getType());
			preparedStatement.setString(3, examQuiz.getAddedOn().toString());
			preparedStatement.setInt(4, examQuiz.getAddedBy().getCoordinatorId());
			preparedStatement.setString(5, examQuiz.getQuestions());
			preparedStatement.setInt(6, examQuiz.getSubject().getSubjectId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// update exam/quiz
	public void update(ExamQuiz examQuiz) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"update exam_quiz set exam_quiz_name = ?, type = ?, added_on = ?, added_by = ?,"
								+ " questions = ?, subject_id = ? where exam_quiz_id = ?;");) {

			preparedStatement.setString(1, examQuiz.getExamQuizName());
			preparedStatement.setString(2, examQuiz.getType());
			preparedStatement.setString(3, examQuiz.getAddedOn().toString());
			preparedStatement.setInt(4, examQuiz.getAddedBy().getCoordinatorId());
			preparedStatement.setString(5, examQuiz.getQuestions());
			preparedStatement.setInt(6, examQuiz.getSubject().getSubjectId());
			preparedStatement.setInt(7, examQuiz.getExamQuizId());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete exam/quiz
	public void delete(int id) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from exam_quiz where exam_quiz_id = ?;");) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
