package com.zhiyou100.crowdFunding.vo;

/**
 * π‹¿Ì‘±
 */

public class Admin {
	private int adminId;
	private String adminName;
	private String adminPassword;
	private String gender;
	private String adminAccountName;

	public Admin() {
		super();
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdminAccountName() {
		return adminAccountName;
	}

	public void setAdminAccountName(String adminAccountName) {
		this.adminAccountName = adminAccountName;
	}

	@Override
	public String toString() {
		return "°æAdmin°ø adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", gender=" + gender + ", adminAccountName=" + adminAccountName + "\n";
	}

}
