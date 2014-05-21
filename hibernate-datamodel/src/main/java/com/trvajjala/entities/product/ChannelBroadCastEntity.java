package com.trvajjala.entities.product;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import com.trvajjala.entities.constants.Country;
import com.trvajjala.entities.constants.Region;

@Entity
@Table(name = "CHANNELBROADCASTS")
public class ChannelBroadCastEntity implements Serializable {

	private static final long serialVersionUID = -2374203281327238591L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer channelBroadcastsId;

	@Column(length = 30, nullable = true, unique = true)
	private String channelBroadcastsCode;

	@Column(length = 100, nullable = true)
	private String channelBroadcastsTitle;

	@Column(length = 255)
	private String description;

	@ManyToOne
	@JoinColumn(name = "channelId", nullable = false)
	@ForeignKey(name = "FK_channelBroadcasts_Channel")
	private ChannelEntity channel;

	private Date timeZone;

	private Date airingDate;

	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	private Region region;

	private Date endDateTime;

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private Country country;

	private Boolean approved;

	public Integer getChannelBroadcastsId() {
		return channelBroadcastsId;
	}

	public void setChannelBroadcastsId(Integer channelBroadcastsId) {
		this.channelBroadcastsId = channelBroadcastsId;
	}

	public String getChannelBroadcastsCode() {
		return channelBroadcastsCode;
	}

	public void setChannelBroadcastsCode(String channelBroadcastsCode) {
		this.channelBroadcastsCode = channelBroadcastsCode;
	}

	public String getChannelBroadcastsTitle() {
		return channelBroadcastsTitle;
	}

	public void setChannelBroadcastsTitle(String channelBroadcastsTitle) {
		this.channelBroadcastsTitle = channelBroadcastsTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ChannelEntity getChannel() {
		return channel;
	}

	public void setChannel(ChannelEntity channel) {
		this.channel = channel;
	}

	public Date getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Date timeZone) {
		this.timeZone = timeZone;
	}

	public Date getAiringDate() {
		return airingDate;
	}

	public void setAiringDate(Date airingDate) {
		this.airingDate = airingDate;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Boolean isApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

}
