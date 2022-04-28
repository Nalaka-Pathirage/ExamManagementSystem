package com.exam.model;

import java.time.LocalDateTime;

public class Attempt {

	private Student student;
	private ExamQuiz examQuiz;
	private LocalDateTime attemptedOn;
	private Double marks;
	private Boolean passFail;

	public Attempt() {
		super();
	}

	public Attempt(Student student, ExamQuiz examQuiz, LocalDateTime attemptedOn, Double marks, Boolean passFail) {
		super();
		this.student = student;
		this.examQuiz = examQuiz;
		this.attemptedOn = attemptedOn;
		this.marks = marks;
		this.passFail = passFail;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public ExamQuiz getExamQuiz() {
		return examQuiz;
	}

	public void setExamQuiz(ExamQuiz examQuiz) {
		this.examQuiz = examQuiz;
	}

	public LocalDateTime getAttemptedOn() {
		return attemptedOn;
	}

	public void setAttemptedOn(LocalDateTime attemptedOn) {
		this.attemptedOn = attemptedOn;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	public Boolean getPassFail() {
		return passFail;
	}

	public void setPassFail(Boolean passFail) {
		this.passFail = passFail;
	}

	@Override
	public String toString() {
		return "Attempt [student=" + student.toString() + ", examQuiz=" + examQuiz.toString() + ", attemptedOn="
				+ attemptedOn + ", marks=" + marks + ", passFail=" + passFail + "]";
	}

}
