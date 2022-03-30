package com.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

	private Integer subjectId;
	private String subjectName;
	private String subjectCode;
	private Course course;
	private Lecturer lecturer;

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", course=" + course != null ? course.toString()
						: null + ", lecturer=" + lecturer != null ? lecturer.toString() : null + "]";
	}

}
