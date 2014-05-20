package com.innominds.response.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Agent implements Serializable {

	private static final long serialVersionUID = 5881010309591830949L;

	@XStreamAsAttribute
	private String login;

	@XStreamAsAttribute
	private String uid;

	@XStreamAsAttribute
	private String href;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
