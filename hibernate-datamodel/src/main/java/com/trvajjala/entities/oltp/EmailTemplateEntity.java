package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMAILTEMPLATE")
public class EmailTemplateEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emailTemplateId;

	@Column(length = 30, unique = true, nullable = false)
	private String emailTemplateCode;

	@Column(length = 100)
	private String emailTemplateTitle;

	@Column(length = 1024)
	private String emailTemplateSubject;

	@Lob
	private String velocityTemplate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMAILTEMPLATE_BLOCKS", joinColumns = { @JoinColumn(name = "emailTemplateId") }, inverseJoinColumns = { @JoinColumn(name = "emailTemplateBlockId") })
	private Set<EmailTemplateBlockEntity> templateBlocks = new HashSet<EmailTemplateBlockEntity>();

	public Set<EmailTemplateBlockEntity> getTemplateBlocks() {
		return templateBlocks;
	}

	public void setTemplateBlocks(Set<EmailTemplateBlockEntity> templateBlocks) {
		this.templateBlocks = templateBlocks;
	}

	public Integer getEmailTemplateId() {
		return emailTemplateId;
	}

	public void setEmailTemplateId(Integer emailTemplateId) {
		this.emailTemplateId = emailTemplateId;
	}

	public String getEmailTemplateCode() {
		return emailTemplateCode;
	}

	public void setEmailTemplateCode(String emailTemplateCode) {
		this.emailTemplateCode = emailTemplateCode;
	}

	public String getEmailTemplateTitle() {
		return emailTemplateTitle;
	}

	public void setEmailTemplateTitle(String emailTemplateTitle) {
		this.emailTemplateTitle = emailTemplateTitle;
	}

	public String getEmailTemplateSubject() {
		return emailTemplateSubject;
	}

	public void setEmailTemplateSubject(String emailTemplateSubject) {
		this.emailTemplateSubject = emailTemplateSubject;
	}

	public String getVelocityTemplate() {
		return velocityTemplate;
	}

	public void setVelocityTemplate(String velocityTemplate) {
		this.velocityTemplate = velocityTemplate;
	}

}
