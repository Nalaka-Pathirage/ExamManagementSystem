package com.exam.wrappers;

import java.util.ArrayList;
import java.util.List;

public class QuizExamWrapper {

	private List<QuestionWrapper> questions = new ArrayList<>();

	public QuizExamWrapper() {
		super();
	}

	public QuizExamWrapper(QuestionWrapper questions) {
		super();
		this.questions.add(questions);
	}

	public List<QuestionWrapper> getQuestions() {
		return questions;
	}

	public void setQuestions(QuestionWrapper questions) {
		this.questions.add(questions);
	}

	@Override
	public String toString() {
		return "QuizExamWrapper [questions=" + questions + "]";
	}

}
