package com.exam.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamQuiz {

	private Integer examQuizId;
	private String examQuizName;
	private String type;
	private LocalDateTime addedOn;
	private Coordinator addedBy;
	private String questions;
	private Subject subject;

	@Override
	public String toString() {
		return "ExamQuiz [examQuizId=" + examQuizId + ", examQuizName=" + examQuizName + ", type=" + type + ", addedOn="
				+ addedOn + ", addedBy=" + addedBy != null ? addedBy.toString()
						: null + ", questions=" + questions != null ? questions.toString()
								: null + ", subject=" + subject != null ? subject.toString() : null + "]";
	}

}
