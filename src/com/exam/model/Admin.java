package com.exam.model;

public class Admin {

	private Integer adminId;
	private String adminName;
	private String adminNic;
	private Login login;

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public Admin(Integer adminId, String adminName, String adminNic) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminNic = adminNic;
	}

	public Admin(Integer adminId, String adminName, String adminNic, Login login) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminNic = adminNic;
		this.login = login;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminNic() {
		return adminNic;
	}

	public void setAdminNic(String adminNic) {
		this.adminNic = adminNic;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminNic=" + adminNic + ", login="
				+ login != null ? login.toString() : null + "]";
	}

}
