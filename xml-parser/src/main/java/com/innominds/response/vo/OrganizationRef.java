package com.innominds.response.vo;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class OrganizationRef {

	
	@XStreamAsAttribute
	private String uid;

	@XStreamAsAttribute
	private String href;

	@XStreamAsAttribute
	private String cn;

	@XStreamAsAttribute
	private String handle;

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

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	
	
	
}
