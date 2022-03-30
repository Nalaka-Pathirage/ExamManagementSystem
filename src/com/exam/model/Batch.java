package com.exam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

	private Integer batchId;
	private String batchName;
	private String batchCode;
	private Course course;

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", batchCode=" + batchCode + ", course="
				+ course != null ? course.toString() : null + "]";
	}

}
