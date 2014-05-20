package com.lyris.proto.model;

import java.io.Serializable;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Organization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1209812790242728445L;

	private String orgId;
	private String orgName;
	private String contactPersonName;
	private String contactPersonEmailAddress;
	private String parentOrgId;
	private String orgDbName;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmailAddress() {
		return contactPersonEmailAddress;
	}

	public void setContactPersonEmailAddress(String contactPersonEmailAddress) {
		this.contactPersonEmailAddress = contactPersonEmailAddress;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getOrgDbName() {
		return orgDbName;
	}

	public void setOrgDbName(String orgDbName) {
		this.orgDbName = orgDbName;
	}

}