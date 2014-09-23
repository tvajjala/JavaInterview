package com.adaequare.testng.adtf.testng.beans;

import java.io.Serializable;

public class Reports implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4120387306668327804L;
	String suiteName;
	String iReport;
	String tNGReport;
	String logger;
	String mailReport;
	public String getMailReport() {
		return mailReport;
	}
	public void setMailReport(String mailReport) {
		this.mailReport = mailReport;
	}
	public String getSuiteName() {
		return suiteName;
	}
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}
	public String getiReport() {
		return iReport;
	}
	public void setiReport(String iReport) {
		this.iReport = iReport;
	}
	public String gettNGReport() {
		return tNGReport;
	}
	public void settNGReport(String tNGReport) {
		this.tNGReport = tNGReport;
	}
	public String getLogger() {
		return logger;
	}
	public void setLogger(String logger) {
		this.logger = logger;
	}

}
