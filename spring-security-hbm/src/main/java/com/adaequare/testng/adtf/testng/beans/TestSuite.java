package com.adaequare.testng.adtf.testng.beans;

import java.io.Serializable;

public class TestSuite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5547190233479646068L;
	private String module="";
	private String url="";
	private String[] testCases;

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getTestCases() {
		return testCases;
	}

	public void setTestCases(String[] testCases) {
		this.testCases = testCases;
	}
	
	@Override
	public String toString() {

		return  "[ "+module+ " , "+url+" ] ";
	}

}
