package com.zhiyou100.crowdFunding.vo;

import java.util.Date;

/**
 * ÆÀÂÛ±í
 */
public class Comments {
	private int cmId;
	private int cmUsId;
	private int cmPsId;
	private String cmContent;
	private Date cmTime;

	public Comments() {
		super();
	}

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public int getCmUsId() {
		return cmUsId;
	}

	public void setCmUsId(int cmUsId) {
		this.cmUsId = cmUsId;
	}

	public int getCmPsId() {
		return cmPsId;
	}

	public void setCmPsId(int cmPsId) {
		this.cmPsId = cmPsId;
	}

	public String getCmContent() {
		return cmContent;
	}

	public void setCmContent(String cmContent) {
		this.cmContent = cmContent;
	}

	public Date getCmTime() {
		return cmTime;
	}

	public void setCmTime(Date cmTime) {
		this.cmTime = cmTime;
	}

	@Override
	public String toString() {
		return "Comments [cmId=" + cmId + ", cmUsId=" + cmUsId + ", cmPsId=" + cmPsId + ", cmContent=" + cmContent
				+ ", cmTime=" + cmTime + "]";
	}

}
