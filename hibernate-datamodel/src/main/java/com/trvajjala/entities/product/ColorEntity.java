package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COLORS")
public class ColorEntity implements Serializable {

	private static final long serialVersionUID = -2078694241706530544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colorId;

	@Column(length = 20,unique=true,nullable=true)
	private String colorCode;

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}


}
