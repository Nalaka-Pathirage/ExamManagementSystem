package com.exam.model;

public class Lecturer {

	private Integer lecturerId;
	private String lecturerName;
	private String subjectStream;
	private String highestQualification;
	private String mobile;
	private Subject subject;

	public Lecturer() {
		super();
	}

	public Lecturer(Integer lecturerId, String lecturerName, String subjectStream, String highestQualification,
			String mobile) {
		super();
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.subjectStream = subjectStream;
		this.highestQualification = highestQualification;
		this.mobile = mobile;
	}

	public Lecturer(String lecturerName, String subjectStream, String highestQualification, String mobile,
			Subject subject) {
		super();
		this.lecturerName = lecturerName;
		this.subjectStream = subjectStream;
		this.highestQualification = highestQualification;
		this.mobile = mobile;
		this.subject = subject;
	}

	public Lecturer(Integer lecturerId, String lecturerName, String subjectStream, String highestQualification,
			String mobile, Subject subject) {
		super();
		this.lecturerId = lecturerId;
		this.lecturerName = lecturerName;
		this.subjectStream = subjectStream;
		this.highestQualification = highestQualification;
		this.mobile = mobile;
		this.subject = subject;
	}

	public Integer getLecturerId() {
		return lecturerId;
	}

	public void setLecturerId(Integer lecturerId) {
		this.lecturerId = lecturerId;
	}

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getSubjectStream() {
		return subjectStream;
	}

	public void setSubjectStream(String subjectStream) {
		this.subjectStream = subjectStream;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Lecturer [lecturerId=" + lecturerId + ", lecturerName=" + lecturerName + ", subjectStream="
				+ subjectStream + ", highestQualification=" + highestQualification + ", mobile=" + mobile + "]";
	}

}
