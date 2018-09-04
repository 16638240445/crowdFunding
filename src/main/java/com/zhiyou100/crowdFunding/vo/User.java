package com.zhiyou100.crowdFunding.vo;
/**
 * ÓÃ»§±í
 */
import java.util.Date;

public class User {
	private int usId;
	private String usEmail;
	private String usName;
	private String usPassword;
	private double usMoney;
	private String usIdcard;
	private String usPhone;
	private String usAddress;
	private int usRole;
	private String usSex;
	private String usCode;
	private Date usCreateTime;
	private Date usUpdateTime;

	public User() {
		super();
	}

	public int getUsId() {
		return usId;
	}

	public void setUsId(int usId) {
		this.usId = usId;
	}

	public String getUsEmail() {
		return usEmail;
	}

	public void setUsEmail(String usEmail) {
		this.usEmail = usEmail;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
	}

	public String getUsPassword() {
		return usPassword;
	}

	public void setUsPassword(String usPassword) {
		this.usPassword = usPassword;
	}

	public double getUsMoney() {
		return usMoney;
	}

	public void setUsMoney(double usMoney) {
		this.usMoney = usMoney;
	}

	public String getUsIdcard() {
		return usIdcard;
	}

	public void setUsIdcard(String usIdcard) {
		this.usIdcard = usIdcard;
	}

	public String getUsPhone() {
		return usPhone;
	}

	public void setUsPhone(String usPhone) {
		this.usPhone = usPhone;
	}

	public String getUsAddress() {
		return usAddress;
	}

	public void setUsAddress(String usAddress) {
		this.usAddress = usAddress;
	}

	public int getUsRole() {
		return usRole;
	}

	public void setUsRole(int usRole) {
		this.usRole = usRole;
	}

	public String getUsSex() {
		return usSex;
	}

	public void setUsSex(String usSex) {
		this.usSex = usSex;
	}

	public String getUsCode() {
		return usCode;
	}

	public void setUsCode(String usCode) {
		this.usCode = usCode;
	}

	public Date getUsCreateTime() {
		return usCreateTime;
	}

	public void setUsCreateTime(Date usCreateTime) {
		this.usCreateTime = usCreateTime;
	}

	public Date getUsUpdateTime() {
		return usUpdateTime;
	}

	public void setUsUpdateTime(Date usUpdateTime) {
		this.usUpdateTime = usUpdateTime;
	}

	@Override
	public String toString() {
		return "¡¾User¡¿ usId=" + usId + ", usEmail=" + usEmail + ", usName=" + usName + ", usPassword=" + usPassword
				+ ", usMoney=" + usMoney + ", usIdcard=" + usIdcard + ", usPhone=" + usPhone + ", usAddress="
				+ usAddress + ", usRole=" + usRole + ", usSex=" + usSex + ", usCode=" + usCode + ", usCreateTime="
				+ usCreateTime + ", usUpdateTime=" + usUpdateTime + "\n";
	}

}
