package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ACTIVATION_QUESTIONNAIRE")
public class ActivationQuestionnaireEntity implements Serializable {

	private static final long serialVersionUID = -5164985606004511409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activationQuestionnaireId;

	@ManyToOne
	@JoinColumn(name = "activationId")
	@ForeignKey(name = "FK_ActivationQuestionnaire_Activation")
	private ActivationEntity activation;

	@ManyToOne
	@JoinColumn(name = "questionnaireId")
	@ForeignKey(name = "FK_ActivationQuestionnaire_Questionnaire")
	private QuestionnaireEntity questionnaire;

	@Lob
	private String response;

	public Integer getActivationQuestionnaireId() {
		return activationQuestionnaireId;
	}

	public void setActivationQuestionnaireId(Integer activationQuestionnaireId) {
		this.activationQuestionnaireId = activationQuestionnaireId;
	}

	public ActivationEntity getActivation() {
		return activation;
	}

	public void setActivation(ActivationEntity activation) {
		this.activation = activation;
	}

	public QuestionnaireEntity getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(QuestionnaireEntity questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
