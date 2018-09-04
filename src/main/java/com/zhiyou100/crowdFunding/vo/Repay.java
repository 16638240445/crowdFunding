package com.zhiyou100.crowdFunding.vo;


/**
 * »Ø±¨±í
 */
public class Repay {
	private int ryId;
	private int ryUsId;
	private int ryType;
	private double ryPaymoney;
	private int ryRule;
	private String ryContent;
	private int ryNumber;
	private int ryTime;
	private int ryPsId;
	private String ryCode;
	private String ryPicUrl;

	public Repay() {
		super();
	}

	public int getRyId() {
		return ryId;
	}

	public void setRyId(int ryId) {
		this.ryId = ryId;
	}

	public int getRyUsId() {
		return ryUsId;
	}

	public void setRyUsId(int ryUsId) {
		this.ryUsId = ryUsId;
	}

	public int getRyType() {
		return ryType;
	}

	public void setRyType(int ryType) {
		this.ryType = ryType;
	}

	public double getRyPaymoney() {
		return ryPaymoney;
	}

	public void setRyPaymoney(double ryPaymoney) {
		this.ryPaymoney = ryPaymoney;
	}

	public int getRyRule() {
		return ryRule;
	}

	public void setRyRule(int ryRule) {
		this.ryRule = ryRule;
	}

	public String getRyContent() {
		return ryContent;
	}

	public void setRyContent(String ryContent) {
		this.ryContent = ryContent;
	}

	public int getRyNumber() {
		return ryNumber;
	}

	public void setRyNumber(int ryNumber) {
		this.ryNumber = ryNumber;
	}

	public int getRyTime() {
		return ryTime;
	}

	public void setRyTime(int ryTime) {
		this.ryTime = ryTime;
	}

	public int getRyPsId() {
		return ryPsId;
	}

	public void setRyPsId(int ryPsId) {
		this.ryPsId = ryPsId;
	}

	public String getRyCode() {
		return ryCode;
	}

	public void setRyCode(String ryCode) {
		this.ryCode = ryCode;
	}

	public String getRyPicUrl() {
		return ryPicUrl;
	}

	public void setRyPicUrl(String ryPicUrl) {
		this.ryPicUrl = ryPicUrl;
	}

	@Override
	public String toString() {
		return "Repay [ryId=" + ryId + ", ryUsId=" + ryUsId + ", ryType=" + ryType + ", ryPaymoney=" + ryPaymoney
				+ ", ryRule=" + ryRule + ", ryContent=" + ryContent + ", ryNumber=" + ryNumber + ", ryTime=" + ryTime
				+ ", ryPsId=" + ryPsId + ", ryCode=" + ryCode + ", ryPicUrl=" + ryPicUrl + "]";
	}

}
