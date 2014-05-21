package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "EMAILTEMPLATEBLOCK")
public class EmailTemplateBlockEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emailTemplateBlockId;

	@Column(length = 30, unique = true, nullable = false)
	private String emailTemplateBlockCode;

	@Column(length = 100)
	private String emailTemplateBlockTitle;

	@Lob
	private String emailTemplateBlockContent;

	public Integer getEmailTemplateBlockId() {
		return emailTemplateBlockId;
	}

	public void setEmailTemplateBlockId(Integer emailTemplateBlockId) {
		this.emailTemplateBlockId = emailTemplateBlockId;
	}

	public String getEmailTemplateBlockCode() {
		return emailTemplateBlockCode;
	}

	public void setEmailTemplateBlockCode(String emailTemplateBlockCode) {
		this.emailTemplateBlockCode = emailTemplateBlockCode;
	}

	public String getEmailTemplateBlockTitle() {
		return emailTemplateBlockTitle;
	}

	public void setEmailTemplateBlockTitle(String emailTemplateBlockTitle) {
		this.emailTemplateBlockTitle = emailTemplateBlockTitle;
	}

	public String getEmailTemplateBlockContent() {
		return emailTemplateBlockContent;
	}

	public void setEmailTemplateBlockContent(String emailTemplateBlockContent) {
		this.emailTemplateBlockContent = emailTemplateBlockContent;
	}

}
