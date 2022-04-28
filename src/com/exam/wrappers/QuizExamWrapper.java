package com.exam.wrappers;

import java.util.List;

public class QuizExamWrapper {

	private List<QuestionWrapper> questions;

	public QuizExamWrapper() {
		super();
	}

	public QuizExamWrapper(List<QuestionWrapper> questions) {
		super();
		this.questions = questions;
	}

	public List<QuestionWrapper> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionWrapper> questions) {
		this.questions = questions;
	}

}
