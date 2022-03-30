package com.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {

	private Integer lecturerId;
	private String lecturerName;
	private String subjectStream;
	private String highestQualification;
	private String mobile;

	@Override
	public String toString() {
		return "Lecturer [lecturerId=" + lecturerId + ", lecturerName=" + lecturerName + ", subjectStream="
				+ subjectStream + ", highestQualification=" + highestQualification + ", mobile=" + mobile + "]";
	}

}
