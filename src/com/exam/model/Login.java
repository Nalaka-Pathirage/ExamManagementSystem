package com.exam.model;

public class Login {

	private String userName;
	private String password;
	private Admin admin;
	private Coordinator coordinator;
	private Student student;

	public Login() {
		super();
	}

	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public Login(String userName, String password, Admin admin, Coordinator coordinator, Student student) {
		super();
		this.userName = userName;
		this.password = password;
		this.admin = admin;
		this.coordinator = coordinator;
		this.student = student;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Coordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(Coordinator coordinator) {
		this.coordinator = coordinator;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", admin=" + admin != null ? admin.toString()
				: null + ", coordinator=" + coordinator != null ? coordinator.toString()
						: null + ", student=" + student != null ? student.toString() : null + "]";
	}

}
