package com.exam.model;

public class Subject {

	private Integer subjectId;
	private String subjectName;
	private String subjectCode;
	private Course course;
	private Lecturer lecturer;

	public Subject() {
		super();
	}

	public Subject(Integer subjectId) {
		super();
		this.subjectId = subjectId;
	}

	public Subject(String subjectName, String subjectCode) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public Subject(Integer subjectId, String subjectName, String subjectCode) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public Subject(String subjectName, String subjectCode, Course course) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.course = course;
	}

	public Subject(Integer subjectId, String subjectName, String subjectCode, Course course) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.course = course;
	}

	public Subject(Integer subjectId, String subjectName, String subjectCode, Course course, Lecturer lecturer) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.course = course;
		this.lecturer = lecturer;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

}
