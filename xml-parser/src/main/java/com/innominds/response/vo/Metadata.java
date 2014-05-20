package com.innominds.response.vo;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Metadata implements Serializable {

	private static final long serialVersionUID = 1192368288385578118L;

	@XStreamAlias("x-oasis-status")
	private String status;

	@XStreamAlias("x-oasis-render-duration-millis")
	private long renderDuration;

	@XStreamAlias("x-oasis-render-datetime")
	private String renderDate;

	@XStreamAlias("x-oasis-render-start-time-millis")
	private String startTime;

	@XStreamAlias("x-oasis-render-end-time-milis")
	private String endTime;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getRenderDuration() {
		return renderDuration;
	}

	public void setRenderDuration(long renderDuration) {
		this.renderDuration = renderDuration;
	}

	public String getRenderDate() {
		return renderDate;
	}

	public void setRenderDate(String renderDate) {
		this.renderDate = renderDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
