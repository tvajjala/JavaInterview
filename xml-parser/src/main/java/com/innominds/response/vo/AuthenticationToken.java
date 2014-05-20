package com.innominds.response.vo;

import java.io.Serializable;

import com.innominds.response.vo.inner.CanHasGui;
import com.innominds.response.vo.inner.ID;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * 
 * @author tvajjala
 *
 */
public class AuthenticationToken implements Serializable {

	private static final long serialVersionUID = -8138447236759133414L;

	private ID id;

	private String expiration;

	private String uid;

	private String created;

	private String updated;

	@XStreamAsAttribute
	private String href;

	private CanHasGui canHasGui;

	private Organization defaultOrganization;

	private User user;

	private Agent agent;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public CanHasGui getCanHasGui() {
		return canHasGui;
	}

	public void setCanHasGui(CanHasGui canHasGui) {
		this.canHasGui = canHasGui;
	}

	public Organization getDefaultOrganization() {
		return defaultOrganization;
	}

	public void setDefaultOrganization(Organization defaultOrganization) {
		this.defaultOrganization = defaultOrganization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

}
