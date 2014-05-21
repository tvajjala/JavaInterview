package com.trvajjala.entities.oltp;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "BODYLOCATION")
public class BodyLocationEntity implements Serializable{

	private static final long serialVersionUID = -5164985606004511409L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bodyLocationId;


	private String description;


	public Integer getBodyLocationId() {
		return bodyLocationId;
	}


	public void setBodyLocationId(Integer bodyLocationId) {
		this.bodyLocationId = bodyLocationId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
