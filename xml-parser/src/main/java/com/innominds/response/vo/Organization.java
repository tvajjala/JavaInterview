package com.innominds.response.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 * @author tvajjala
 *
 */
public class Organization implements Serializable {

	
	private static final long serialVersionUID = 8137874892862047156L;

	@XStreamAlias("isAdmin")
	@XStreamAsAttribute
	Boolean admin;

	OrganizationRef organizationRef;

	public Boolean isAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public OrganizationRef getOrganizationRef() {
		return organizationRef;
	}

	public void setOrganizationRef(OrganizationRef organizationRef) {
		this.organizationRef = organizationRef;
	}

}
