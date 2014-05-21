package com.trvajjala.entities.product;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "CHANNEL")
public class ChannelEntity implements Serializable {

	private static final long serialVersionUID = 6170559607336202943L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer channelId;

	@Column(length = 30, nullable = true, unique = true)
	private String channelCode;

	@Column(length = 100, nullable = true)
	private String channelTitle;

	@Column(length = 255)
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "channelGroupId", nullable = true)
	@ForeignKey(name = "FK_Channel_ChannelGroup")
	private ChannelGroupEntity channelGroup;

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getChannelTitle() {
		return channelTitle;
	}

	public void setChannelTitle(String channelTitle) {
		this.channelTitle = channelTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ChannelGroupEntity getChannelGroup() {
		return channelGroup;
	}

	public void setChannelGroup(ChannelGroupEntity channelGroup) {
		this.channelGroup = channelGroup;
	}

}
