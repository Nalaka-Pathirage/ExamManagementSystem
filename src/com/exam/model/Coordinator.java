package com.exam.model;

public class Coordinator {

	private Integer coordinatorId;
	private String firstName;
	private String lastName;
	private String nic;
	private String mobile;
	private Login login;

	public Coordinator() {
		super();
	}

	public Coordinator(Integer coordinatorId) {
		super();
		this.coordinatorId = coordinatorId;
	}
	
	public Coordinator(String firstName, String lastName, String nic, String mobile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.mobile = mobile;
	}

	public Coordinator(Integer coordinatorId, String firstName, String lastName, String nic, String mobile) {
		super();
		this.coordinatorId = coordinatorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.mobile = mobile;
	}

	public Coordinator(Integer coordinatorId, String firstName, String lastName, String nic, String mobile,
			Login login) {
		super();
		this.coordinatorId = coordinatorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nic = nic;
		this.mobile = mobile;
		this.login = login;
	}

	public Integer getCoordinatorId() {
		return coordinatorId;
	}

	public void setCoordinatorId(Integer coordinatorId) {
		this.coordinatorId = coordinatorId;
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

	@Override
	public String toString() {
		return "Coordinator [coordinatorId=" + coordinatorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nic=" + nic + ", mobile=" + mobile + ", login=" + login != null ? login.toString() : null + "]";
	}

}
