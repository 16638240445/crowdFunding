package com.zhiyou100.crowdFunding.vo;

import java.util.Date;
import java.util.List;

/**
 * ÏîÄ¿±í
 */
public class Projects {
	private int psId;
	private int psUsId;
	private String psCustName;
	private String psCustPhone;
	private String psCustAddress;
	private int psPstId;
	private String psFile;
	private String psName;
	private String psGoal;
	private String psAddress;
	private double psMoney;
	private int psDays;
	private String psVideo;
	private String psStory;
	private String psSupport;
	private String psRepay;
	private String psAboutme;
	private int psType;
	private Date psStarttime;
	private Date psEndtime;
	private double psGetmoney;
	private int psGetpeople;
	private int psAuditor;
	private Projectstype pst;
	private User us;
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Projectstype getPst() {
		return pst;
	}

	public void setPst(Projectstype pst) {
		this.pst = pst;
	}

	public User getUs() {
		return us;
	}

	public void setUs(User us) {
		this.us = us;
	}

	public Projects() {
		super();
	}

	public int getPsId() {
		return psId;
	}

	public void setPsId(int psId) {
		this.psId = psId;
	}

	public int getPsUsId() {
		return psUsId;
	}

	public void setPsUsId(int psUsId) {
		this.psUsId = psUsId;
	}

	public String getPsCustName() {
		return psCustName;
	}

	public void setPsCustName(String psCustName) {
		this.psCustName = psCustName;
	}

	public String getPsCustPhone() {
		return psCustPhone;
	}

	public void setPsCustPhone(String psCustPhone) {
		this.psCustPhone = psCustPhone;
	}

	public String getPsCustAddress() {
		return psCustAddress;
	}

	public void setPsCustAddress(String psCustAddress) {
		this.psCustAddress = psCustAddress;
	}

	public int getPsPstId() {
		return psPstId;
	}

	public void setPsPstId(int psPstId) {
		this.psPstId = psPstId;
	}

	public String getPsFile() {
		return psFile;
	}

	public void setPsFile(String psFile) {
		this.psFile = psFile;
	}

	public String getPsName() {
		return psName;
	}

	public void setPsName(String psName) {
		this.psName = psName;
	}

	public String getPsGoal() {
		return psGoal;
	}

	public void setPsGoal(String psGoal) {
		this.psGoal = psGoal;
	}

	public String getPsAddress() {
		return psAddress;
	}

	public void setPsAddress(String psAddress) {
		this.psAddress = psAddress;
	}

	public double getPsMoney() {
		return psMoney;
	}

	public void setPsMoney(double psMoney) {
		this.psMoney = psMoney;
	}

	public int getPsDays() {
		return psDays;
	}

	public void setPsDays(int psDays) {
		this.psDays = psDays;
	}

	public String getPsVideo() {
		return psVideo;
	}

	public void setPsVideo(String psVideo) {
		this.psVideo = psVideo;
	}

	public String getPsStory() {
		return psStory;
	}

	public void setPsStory(String psStory) {
		this.psStory = psStory;
	}

	public String getPsSupport() {
		return psSupport;
	}

	public void setPsSupport(String psSupport) {
		this.psSupport = psSupport;
	}

	public String getPsRepay() {
		return psRepay;
	}

	public void setPsRepay(String psRepay) {
		this.psRepay = psRepay;
	}

	public String getPsAboutme() {
		return psAboutme;
	}

	public void setPsAboutme(String psAboutme) {
		this.psAboutme = psAboutme;
	}

	public int getPsType() {
		return psType;
	}

	public void setPsType(int psType) {
		this.psType = psType;
	}

	public Date getPsStarttime() {
		return psStarttime;
	}

	public void setPsStarttime(Date psStarttime) {
		this.psStarttime = psStarttime;
	}

	public Date getPsEndtime() {
		return psEndtime;
	}

	public void setPsEndtime(Date psEndtime) {
		this.psEndtime = psEndtime;
	}

	public double getPsGetmoney() {
		return psGetmoney;
	}

	public void setPsGetmoney(double psGetmoney) {
		this.psGetmoney = psGetmoney;
	}

	public int getPsGetpeople() {
		return psGetpeople;
	}

	public void setPsGetpeople(int psGetpeople) {
		this.psGetpeople = psGetpeople;
	}

	public int getPsAuditor() {
		return psAuditor;
	}

	public void setPsAuditor(int psAuditor) {
		this.psAuditor = psAuditor;
	}

	@Override
	public String toString() {
		return "Projects [psId=" + psId + ", psUsId=" + psUsId + ", psCustName=" + psCustName + ", psCustPhone="
				+ psCustPhone + ", psCustAddress=" + psCustAddress + ", psPstId=" + psPstId + ", psFile=" + psFile
				+ ", psName=" + psName + ", psGoal=" + psGoal + ", psAddress=" + psAddress + ", psMoney=" + psMoney
				+ ", psDays=" + psDays + ", psVideo=" + psVideo + ", psStory=" + psStory + ", psSupport=" + psSupport
				+ ", psRepay=" + psRepay + ", psAboutme=" + psAboutme + ", psType=" + psType + ", psStarttime="
				+ psStarttime + ", psEndtime=" + psEndtime + ", psGetmoney=" + psGetmoney + ", psGetpeople="
				+ psGetpeople + ", psAuditor=" + psAuditor + "]";
	}

}
