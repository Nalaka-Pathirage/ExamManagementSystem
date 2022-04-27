package com.exam.wrappers;

import java.util.Map;

public class QuestionWrapper {

	private Integer questionNumber;
	private String question;
	private Map<Integer, String> answers;
	private Integer correctAnswer;

	public QuestionWrapper(Integer questionNumber, String question, Map<Integer, String> answers,
			Integer correctAnswer) {
		super();
		this.questionNumber = questionNumber;
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Map<Integer, String> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<Integer, String> answers) {
		this.answers = answers;
	}

	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "QuestionWrapper [questionNumber=" + questionNumber + ", question=" + question + ", answers=" + answers
				+ ", correctAnswer=" + correctAnswer + "]";
	}

}
