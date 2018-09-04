package com.zhiyou100.crowdFunding.vo;

/**
 * »’÷æ±Ì
 */
public class Logs {
	private int logId;
	private int logUsId;
	private String logContent;

	public Logs() {
		super();
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getLogUsId() {
		return logUsId;
	}

	public void setLogUsId(int logUsId) {
		this.logUsId = logUsId;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	@Override
	public String toString() {
		return "Logs [logId=" + logId + ", logUsId=" + logUsId + ", logContent=" + logContent + "]";
	}

}
