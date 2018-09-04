package com.zhiyou100.crowdFunding.vo;

import java.util.List;

/**
 * 问题主表
 */
public class Questionall {
	private int questionid;
	private String questionname;
	private List<Questionother> other;

	public Questionall() {
		super();
	}

	public List<Questionother> getOther() {
		return other;
	}

	public void setOther(List<Questionother> other) {
		this.other = other;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	@Override
	public String toString() {
		return "【Questionall】 questionid=" + questionid + ", questionname=" + questionname + "\n";
	}

}
