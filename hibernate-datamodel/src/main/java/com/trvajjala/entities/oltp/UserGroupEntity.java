package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name = "USERGROUP")
public class UserGroupEntity implements Serializable {

	private static final long serialVersionUID = 760951673564496306L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userGroupId;

	@Column(nullable = false, unique = true, length = 30)
	private String userGroupCode;

	@Column(nullable = false, length = 100)
	private String userGroupTitle;

	@Column(length = 255)
	private String description;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "roleId", nullable = true )
	private RoleEntity role;

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserGroupCode() {
		return userGroupCode;
	}

	public void setUserGroupCode(String userGroupCode) {
		this.userGroupCode = userGroupCode;
	}

	public String getUserGroupTitle() {
		return userGroupTitle;
	}

	public void setUserGroupTitle(String userGroupTitle) {
		this.userGroupTitle = userGroupTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
