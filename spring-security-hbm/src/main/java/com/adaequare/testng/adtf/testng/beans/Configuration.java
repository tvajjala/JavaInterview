package com.adaequare.testng.adtf.testng.beans;

import java.io.Serializable;

public class Configuration implements Serializable {

	private String browserType;
	private String browserVersion;
	private String host;

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {

		return "[" + browserType + " Version:<" + browserVersion + ">, "  + host + "]";
	}

}
