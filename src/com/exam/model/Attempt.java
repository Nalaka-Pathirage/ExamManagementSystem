package com.exam.model;

import java.time.LocalDateTime;

public class Attempt {

	private Student student;
	private ExamQuiz examQuiz;
	private LocalDateTime attemptedOn;
	private Double marks;
	private Boolean passFail;

	@Override
	public String toString() {
		return "Attempt [student=" + student.toString() + ", examQuiz=" + examQuiz.toString() + ", attemptedOn="
				+ attemptedOn + ", marks=" + marks + ", passFail=" + passFail + "]";
	}

}
