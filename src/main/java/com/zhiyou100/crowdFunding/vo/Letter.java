package com.zhiyou100.crowdFunding.vo;

import java.util.Date;
/**
 *к╫пе╠М
 */
public class Letter {
	private int leId;
	private int leUsAddresserid;
	private int leUsRecipientsid;
	private String leContent;
	private Date leCreateTime;

	public Letter() {
		super();
	}

	public int getLeId() {
		return leId;
	}

	public void setLeId(int leId) {
		this.leId = leId;
	}

	public int getLeUsAddresserid() {
		return leUsAddresserid;
	}

	public void setLeUsAddresserid(int leUsAddresserid) {
		this.leUsAddresserid = leUsAddresserid;
	}

	public int getLeUsRecipientsid() {
		return leUsRecipientsid;
	}

	public void setLeUsRecipientsid(int leUsRecipientsid) {
		this.leUsRecipientsid = leUsRecipientsid;
	}

	public String getLeContent() {
		return leContent;
	}

	public void setLeContent(String leContent) {
		this.leContent = leContent;
	}

	public Date getLeCreateTime() {
		return leCreateTime;
	}

	public void setLeCreateTime(Date leCreateTime) {
		this.leCreateTime = leCreateTime;
	}

	@Override
	public String toString() {
		return "Letter [leId=" + leId + ", leUsAddresserid=" + leUsAddresserid + ", leUsRecipientsid="
				+ leUsRecipientsid + ", leContent=" + leContent + ", leCreateTime=" + leCreateTime + "]";
	}

}
