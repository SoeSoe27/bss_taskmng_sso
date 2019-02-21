package com.taskspringboot.jsonmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class teamJson {
	@JsonProperty("_teamId")
	private Integer team_id;
	
	@JsonProperty("_teamName")
	private String team_name;
	
	@JsonProperty("_teamDescription")
	private String team_description;

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getTeam_description() {
		return team_description;
	}

	public void setTeam_description(String team_description) {
		this.team_description = team_description;
	}
	
	
}
