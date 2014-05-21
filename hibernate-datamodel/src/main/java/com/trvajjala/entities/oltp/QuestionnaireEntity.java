package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONNAIRE")
public class QuestionnaireEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer questionnaireId;

	@Column(length = 100)
	private String questionnaireTitle;

	@Column(length = 30)
	private String questionnaireCode;

	@Column(length = 255)
	private String description;

	@Column(name="isSuitable")
	private Boolean suitable;

	@Column(length = 100)
	private String actualPartOrColor;

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionnaireTitle() {
		return questionnaireTitle;
	}

	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle = questionnaireTitle;
	}

	public String getQuestionnaireCode() {
		return questionnaireCode;
	}

	public void setQuestionnaireCode(String questionnaireCode) {
		this.questionnaireCode = questionnaireCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean isSuitable() {
		return suitable;
	}

	public void setSuitable(Boolean suitable) {
		this.suitable = suitable;
	}

	public String getActualPartOrColor() {
		return actualPartOrColor;
	}

	public void setActualPartOrColor(String actualPartOrColor) {
		this.actualPartOrColor = actualPartOrColor;
	}

}
