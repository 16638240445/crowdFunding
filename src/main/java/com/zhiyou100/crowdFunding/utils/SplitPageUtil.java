package com.zhiyou100.crowdFunding.utils;


import javax.servlet.http.HttpServletRequest;

public class SplitPageUtil {
	private String column ;
	private String keyWord ;
	private Integer currentPage ;
	private Integer lineSize = 5 ;
	/**
	 * ����һ��Ĭ�ϵķ�ҳ������
	 * @param column Ĭ�Ϸ�ҳ������
	 */
	public SplitPageUtil(HttpServletRequest request,String column) {
		this.column = column ;
		this.setCp(request.getParameter("cp"));
		this.setLs(request.getParameter("ls"));
		this.setCol(request.getParameter("col"));
		this.setKw(request.getParameter("kw"));
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public Integer getLineSize() {
		return lineSize; 
	}
	public String getKeyWord() {
		return keyWord;
	}
	public String getColumn() {
		return column;
	}
	/**
	 * ���ò�ѯ�ؼ��֣����û�йؼ�������������Ϊnull
	 * @param kw
	 */
	public void setKw(String kw) {
		if ("".equals(kw)) {
			this.keyWord = null ;
		} else if ("null".equalsIgnoreCase(kw)) {
			this.keyWord = null ;
		} else {
			this.keyWord = kw ;
		} 
	}
	/**
	 * ���÷�ҳ�����������col���������û�в�������ʹ��defaultColumn
	 * @param col
	 */
	public void setCol(String col) {
		if (!(col == null || "".equals(col) || "null".equalsIgnoreCase(col))) {
			this.column = col ;
		} 
	} 
	/**
	 * ���շ�ҳ������ݹ�����ls����������
	 * @param ls
	 */
	public void setLs(String ls) {
		try {
			this.lineSize = Integer.parseInt(ls) ;
		} catch (Exception e) {}
	}
	/**
	 * �˲�����Ҫ�Ǵ����ҳ������ݹ����������Ϣ
	 * @param cp
	 */
	public void setCp(String cp) {
		try {
			this.currentPage = Integer.parseInt(cp) ;
		} catch (Exception e) {
			this.currentPage = 1 ;	// ���û��cp�������ݣ���currentPage�����ݾ���1
		}
	}
	@Override
	public String toString() {
		return "SplitPageUtil [column=" + column + ", keyWord=" + keyWord + ", currentPage=" + currentPage
				+ ", lineSize=" + lineSize + "]";
	}
}
