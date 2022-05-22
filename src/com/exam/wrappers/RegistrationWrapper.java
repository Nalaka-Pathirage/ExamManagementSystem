package com.exam.wrappers;

public class RegistrationWrapper {

	private String courseName;
	private String courseCode;
	private String yearOfStart;
	private Integer totalRegistrations;

	public RegistrationWrapper() {
		super();
	}

	public RegistrationWrapper(String courseName, String courseCode, String yearOfStart, Integer totalRegistrations) {
		super();
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.yearOfStart = yearOfStart;
		this.totalRegistrations = totalRegistrations;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getYearOfStart() {
		return yearOfStart;
	}

	public void setYearOfStart(String yearOfStart) {
		this.yearOfStart = yearOfStart;
	}

	public Integer getTotalRegistrations() {
		return totalRegistrations;
	}

	public void setTotalRegistrations(Integer totalRegistrations) {
		this.totalRegistrations = totalRegistrations;
	}

	@Override
	public String toString() {
		return "RegistrationWrapper [courseName=" + courseName + ", courseCode=" + courseCode + ", yearOfStart="
				+ yearOfStart + ", totalRegistrations=" + totalRegistrations + "]";
	}

}
