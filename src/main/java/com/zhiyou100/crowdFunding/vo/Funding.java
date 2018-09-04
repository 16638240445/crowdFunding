package com.zhiyou100.crowdFunding.vo;

import java.util.Date;

/**
 * 参与者表
 */
public class Funding {
	private int fdId;
	private int fdUsId;
	private int fdPsId;
	private double fdMoney;
	private Date fdTime;

	public Funding() {
		super();
	}

	public int getFdId() {
		return fdId;
	}

	public void setFdId(int fdId) {
		this.fdId = fdId;
	}

	public int getFdUsId() {
		return fdUsId;
	}

	public void setFdUsId(int fdUsId) {
		this.fdUsId = fdUsId;
	}

	public int getFdPsId() {
		return fdPsId;
	}

	public void setFdPsId(int fdPsId) {
		this.fdPsId = fdPsId;
	}

	public double getFdMoney() {
		return fdMoney;
	}

	public void setFdMoney(double fdMoney) {
		this.fdMoney = fdMoney;
	}

	public Date getFdTime() {
		return fdTime;
	}

	public void setFdTime(Date fdTime) {
		this.fdTime = fdTime;
	}

	@Override
	public String toString() {
		return "Funding [fdId=" + fdId + ", fdUsId=" + fdUsId + ", fdPsId=" + fdPsId + ", fdMoney=" + fdMoney
				+ ", fdTime=" + fdTime + "]";
	}

}
