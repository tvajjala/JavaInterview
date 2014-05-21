package com.trvajjala.entities.oltp;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.trvajjala.entities.constants.Country;

@Entity
@Table(name = "SESSIONINFO")
public class SessionInfoEntity implements Serializable {

	private static final long serialVersionUID = 8225701862845166685L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sessionInfoId;

	@Column(length = 50)
	private String sessionId;

	@Column(length = 50, nullable = false)
	private String ipAddress;

	@Column(length = 150, nullable = false)
	private String userAgent;

	@Column(length = 150)
	private String cookieTrackingId;

	@Lob
	private String httpRequestInfo;

	@Enumerated(EnumType.STRING)
	@Column(length = 4, nullable = false)
	private Country country;

	@Lob
	private String httpHeaders;

	private Date requestTime;

	@PrePersist
	public void onCreate() {

		requestTime = new Date();
	}

	public Integer getSessionInfoId() {
		return sessionInfoId;
	}

	public void setSessionInfoId(Integer sessionInfoId) {
		this.sessionInfoId = sessionInfoId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCookieTrackingId() {
		return cookieTrackingId;
	}

	public void setCookieTrackingId(String cookieTrackingId) {
		this.cookieTrackingId = cookieTrackingId;
	}

	public String getHttpRequestInfo() {
		return httpRequestInfo;
	}

	public void setHttpRequestInfo(String httpRequestInfo) {
		this.httpRequestInfo = httpRequestInfo;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(String httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

}
