package com.exam.model;

public class Batch {

	private Integer batchId;
	private String batchName;
	private String batchCode;
	private Course course;

	public Batch(String batchName, String batchCode) {
		super();
		this.batchName = batchName;
		this.batchCode = batchCode;
	}

	public Batch(Integer batchId, String batchName, String batchCode) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchCode = batchCode;
	}

	public Batch(String batchName, String batchCode, Course course) {
		super();
		this.batchName = batchName;
		this.batchCode = batchCode;
		this.course = course;
	}

	public Batch(Integer batchId, String batchName, String batchCode, Course course) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.batchCode = batchCode;
		this.course = course;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchCode() {
		return batchCode;
	}

	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", batchCode=" + batchCode + ", course="
				+ course != null ? course.toString() : null + "]";
	}

}
