package com.innominds.response.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WorkGroup implements Serializable {

	private static final long serialVersionUID = 9068025240868770404L;

	private String id;

	private String uid;

	private String name;

	private String description;

	@XStreamAlias("organization-ref")
	private OrganizationRef organizationRef;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrganizationRef getOrganizationRef() {
		return organizationRef;
	}

	public void setOrganizationRef(OrganizationRef organizationRef) {
		this.organizationRef = organizationRef;
	}

}
