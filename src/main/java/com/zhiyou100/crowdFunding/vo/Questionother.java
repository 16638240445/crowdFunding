package com.zhiyou100.crowdFunding.vo;

import java.util.Date;

/**
 * 问题子表
 */
public class Questionother {
	private int questionotherid;
	private int questionid;
	private String questionothername;
	private String questionanswer;
	private Date questiondate;
	private Questionall parentQuestion;

	public Questionother() {
		super();
	}

	public Questionall getParentQuestion() {
		return parentQuestion;
	}

	public void setParentQuestion(Questionall parentQuestion) {
		this.parentQuestion = parentQuestion;
	}

	public int getQuestionotherid() {
		return questionotherid;
	}

	public void setQuestionotherid(int questionotherid) {
		this.questionotherid = questionotherid;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getQuestionothername() {
		return questionothername;
	}

	public void setQuestionothername(String questionothername) {
		this.questionothername = questionothername;
	}

	public String getQuestionanswer() {
		return questionanswer;
	}

	public void setQuestionanswer(String questionanswer) {
		this.questionanswer = questionanswer;
	}

	public Date getQuestiondate() {
		return questiondate;
	}

	public void setQuestiondate(Date questiondate) {
		this.questiondate = questiondate;
	}

	@Override
	public String toString() {
		return "Questionother [questionotherid=" + questionotherid + ", questionid=" + questionid
				+ ", questionothername=" + questionothername + ", questionanswer=" + questionanswer + ", questiondate="
				+ questiondate + "]";
	}

}
