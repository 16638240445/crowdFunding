package com.zhiyou100.crowdFunding.vo;

/**
 * 公益类型表
 */
import java.util.Date;

public class Projectstype {
	private int pstId;
	private String pstName;
	private String pstDesc;
	private Date pstStardate;
	private int pstType;

	public Projectstype() {
		super();
	}

	public int getPstId() {
		return pstId;
	}

	public void setPstId(int pstId) {
		this.pstId = pstId;
	}

	public String getPstName() {
		return pstName;
	}

	public void setPstName(String pstName) {
		this.pstName = pstName;
	}

	public String getPstDesc() {
		return pstDesc;
	}

	public void setPstDesc(String pstDesc) {
		this.pstDesc = pstDesc;
	}

	public Date getPstStardate() {
		return pstStardate;
	}

	public void setPstStardate(Date pstStardate) {
		this.pstStardate = pstStardate;
	}

	public int getPstType() {
		return pstType;
	}

	public void setPstType(int pstType) {
		this.pstType = pstType;
	}

	@Override
	public String toString() {
		return "Projectstype [pstId=" + pstId + ", pstName=" + pstName + ", pstDesc=" + pstDesc + ", pstStardate="
				+ pstStardate + ", pstType=" + pstType + "]";
	}

}
