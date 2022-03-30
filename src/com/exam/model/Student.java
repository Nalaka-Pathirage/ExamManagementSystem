package com.exam.model;

public class Student {

	private Integer studentId;
	private String firstName;
	private String lastName;
	private String nic;
	private String mobile;
	private String address;
	private Login login;
	private Registration registration;
	private Course course;

	public Student() {
		super();
	}

	public Student(Integer studentId) {
		super();
		this.studentId = studentId;
	}

	public Student(String firstName, String lastName, String nic, String mobile, String address, Course course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.mobile = mobile;
		this.address = address;
		this.course = course;
	}

	public Student(Integer studentId, String firstName, String lastName, String nic, String mobile, String address,
			Login login, Registration registration, Course course) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.mobile = mobile;
		this.address = address;
		this.login = login;
		this.registration = registration;
		this.course = course;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", nic="
				+ nic + ", mobile=" + mobile + ", login=" + login != null ? login.toString()
						: null + ", registration=" + registration != null ? registration.toString()
								: null + ", course=" + course != null ? course.toString() : null + "]";
	}

}
