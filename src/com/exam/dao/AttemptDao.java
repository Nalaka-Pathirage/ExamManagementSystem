package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.exam.model.Attempt;
import com.exam.model.ExamQuiz;
import com.exam.model.Student;
import com.exam.model.Subject;
import com.exam.utility.DbUtility;

public class AttemptDao {

	private DbUtility dbUtility;

	public AttemptDao() {
		this.dbUtility = new DbUtility();
	}

	// insert attempt record
	public void insert(Attempt attempt) {

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into attempt (student_id, exam_id, attempted_on, marks, pass_fail) values (?, ?, ?, ?, ?);");) {

			preparedStatement.setInt(1, attempt.getStudent().getStudentId());
			preparedStatement.setInt(2, attempt.getExamQuiz().getExamQuizId());
			preparedStatement.setString(3, attempt.getAttemptedOn().toString());
			preparedStatement.setDouble(4, attempt.getMarks());
			preparedStatement.setBoolean(5, attempt.getPassFail());
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// delete attempt record
	public void delete() {
		// to be implemented
	}

	// find exams attempted by student
	public List<Attempt> findExamsAttemptedByStudent(int studentId) {

		List<Attempt> attempts = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from attempt a inner join exam_quiz eq on a.exam_id = eq.exam_quiz_id\n"
								+ "inner join student s on s.student_id = a.student_id\n"
								+ "inner join subject sb on sb.subject_id = eq.subject_id\n"
								+ "where s.student_id = ? and eq.type='E';");) {

			preparedStatement.setInt(1, studentId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				ExamQuiz examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"),
						rs.getString("type"), LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')), null,
						rs.getString("questions"), subject);

				Attempt attempt = new Attempt(new Student(studentId), examQuiz,
						LocalDateTime.parse(rs.getString("attempted_on").replace(' ', 'T')), rs.getDouble("marks"),
						rs.getBoolean("pass_fail"));

				attempts.add(attempt);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return attempts;
	}

	// find quizes attempted by student
	public List<Attempt> findQuizesAttemptedByStudent(int studentId) {

		List<Attempt> attempts = new ArrayList<>();

		try (Connection connection = dbUtility.doGetDbConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"select * from attempt a inner join exam_quiz eq on a.exam_id = eq.exam_quiz_id\n"
								+ "inner join student s on s.student_id = a.student_id\n"
								+ "inner join subject sb on sb.subject_id = eq.subject_id\n"
								+ "where s.student_id = ? and eq.type='Q';");) {

			preparedStatement.setInt(1, studentId);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next() != false) {

				Subject subject = new Subject(rs.getInt("subject_id"), rs.getString("subject_name"),
						rs.getString("subject_code"), null, null);

				ExamQuiz examQuiz = new ExamQuiz(rs.getInt("exam_quiz_id"), rs.getString("exam_quiz_name"),
						rs.getString("type"), LocalDateTime.parse(rs.getString("added_on").replace(' ', 'T')), null,
						rs.getString("questions"), subject);

				Attempt attempt = new Attempt(new Student(studentId), examQuiz,
						LocalDateTime.parse(rs.getString("attempted_on").replace(' ', 'T')), rs.getDouble("marks"),
						rs.getBoolean("pass_fail"));

				attempts.add(attempt);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return attempts;
	}
}
