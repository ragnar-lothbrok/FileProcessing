package com.home.cron;

import java.io.Serializable;

public class CronJob implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer cronId;
	private Integer serverId;
	private String cronExpression;
	private String completeCron;
	private String cronCommand;
	private String cronStatus;
	private String cronComment;

	public String getCronComment() {
		return cronComment;
	}

	public void setCronComment(String cronComment) {
		this.cronComment = cronComment;
	}

	public Integer getCronId() {
		return cronId;
	}

	public void setCronId(Integer cronId) {
		this.cronId = cronId;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getCompleteCron() {
		return completeCron;
	}

	public void setCompleteCron(String completeCron) {
		this.completeCron = completeCron;
	}

	public String getCronCommand() {
		return cronCommand;
	}

	public void setCronCommand(String cronCommand) {
		this.cronCommand = cronCommand;
	}

	public String getCronStatus() {
		return cronStatus;
	}

	public void setCronStatus(String cronStatus) {
		this.cronStatus = cronStatus;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	@Override
	public String toString() {
		return "CronJob [cronId=" + cronId + ", serverId=" + serverId
				+ ", cronExpression=" + cronExpression + ", completeCron="
				+ completeCron + ", cronCommand=" + cronCommand
				+ ", cronStatus=" + cronStatus + ", cronComment=" + cronComment
				+ "]\n";
	}

}
