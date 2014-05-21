package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHANNELGROUP")
public class ChannelGroupEntity implements Serializable {

	private static final long serialVersionUID = -5508989590486389733L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer channelGroupId;

	@Column(length = 30, nullable = false, unique = true)
	private String channelGroupCode;

	@Column(length = 100, nullable = false)
	private String channelGroupTitle;

	@Column(length = 255)
	private String description;

	public Integer getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(Integer channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	public String getChannelGroupCode() {
		return channelGroupCode;
	}

	public void setChannelGroupCode(String channelGroupCode) {
		this.channelGroupCode = channelGroupCode;
	}

	public String getChannelGroupTitle() {
		return channelGroupTitle;
	}

	public void setChannelGroupTitle(String channelGroupTitle) {
		this.channelGroupTitle = channelGroupTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
