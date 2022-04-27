package com.exam.model;

import java.time.LocalDateTime;

public class ExamQuiz {

	private Integer examQuizId;
	private String examQuizName;
	private String type;
	private LocalDateTime addedOn;
	private Coordinator addedBy;
	private String questions;
	private Subject subject;

	public ExamQuiz(String examQuizName, String type, LocalDateTime addedOn, Coordinator addedBy, Subject subject) {
		super();
		this.examQuizName = examQuizName;
		this.type = type;
		this.addedOn = addedOn;
		this.addedBy = addedBy;
		this.subject = subject;
	}

	public ExamQuiz(Integer examQuizId, String examQuizName, String type, LocalDateTime addedOn, Coordinator addedBy,
			String questions, Subject subject) {
		super();
		this.examQuizId = examQuizId;
		this.examQuizName = examQuizName;
		this.type = type;
		this.addedOn = addedOn;
		this.addedBy = addedBy;
		this.questions = questions;
		this.subject = subject;
	}

	public Integer getExamQuizId() {
		return examQuizId;
	}

	public void setExamQuizId(Integer examQuizId) {
		this.examQuizId = examQuizId;
	}

	public String getExamQuizName() {
		return examQuizName;
	}

	public void setExamQuizName(String examQuizName) {
		this.examQuizName = examQuizName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	public Coordinator getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Coordinator addedBy) {
		this.addedBy = addedBy;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "ExamQuiz [examQuizId=" + examQuizId + ", examQuizName=" + examQuizName + ", type=" + type + ", addedOn="
				+ addedOn + ", addedBy=" + addedBy != null ? addedBy.toString()
						: null + ", questions=" + questions != null ? questions.toString()
								: null + ", subject=" + subject != null ? subject.toString() : null + "]";
	}

}
