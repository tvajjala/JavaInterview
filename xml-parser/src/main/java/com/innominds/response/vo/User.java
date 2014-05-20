package com.innominds.response.vo;

import java.io.Serializable;

import com.innominds.response.vo.inner.ID;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class User implements Serializable {

	private static final long serialVersionUID = 4782876392588425998L;

	private ID id;

	private String uid;

	private String name;
	private String login;

	private String email;

	private String firstName;

	private String lastName;

	@XStreamAsAttribute
	private String href;

	@XStreamAlias("isCompany")
	private Boolean company;

	@XStreamAlias("isStaff")
	private Boolean staff;

	@XStreamAlias("isSystemStaff")
	private Boolean systemStaff;

	@XStreamAlias("isSystemAdmin")
	private Boolean systemAdmin;

	private Organization parentOrganization;

	private Organization organizationAccount;

	private WorkGroup workgroup;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getCompany() {
		return company;
	}

	public void setCompany(Boolean company) {
		this.company = company;
	}

	public Boolean getStaff() {
		return staff;
	}

	public void setStaff(Boolean staff) {
		this.staff = staff;
	}

	public Boolean getSystemStaff() {
		return systemStaff;
	}

	public void setSystemStaff(Boolean systemStaff) {
		this.systemStaff = systemStaff;
	}

	public Boolean getSystemAdmin() {
		return systemAdmin;
	}

	public void setSystemAdmin(Boolean systemAdmin) {
		this.systemAdmin = systemAdmin;
	}

	public Organization getParentOrganization() {
		return parentOrganization;
	}

	public void setParentOrganization(Organization parentOrganization) {
		this.parentOrganization = parentOrganization;
	}

	public Organization getOrganizationAccount() {
		return organizationAccount;
	}

	public void setOrganizationAccount(Organization organizationAccount) {
		this.organizationAccount = organizationAccount;
	}

	public WorkGroup getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(WorkGroup workgroup) {
		this.workgroup = workgroup;
	}

}
