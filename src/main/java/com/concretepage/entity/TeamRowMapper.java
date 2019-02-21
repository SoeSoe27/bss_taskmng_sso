package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taskspringboot.model.Team;

public class TeamRowMapper implements RowMapper<Team> {
	public Team mapRow(ResultSet row, int rowNum) throws SQLException {
		Team team = new Team();
		team.setTeam_id(row.getInt("team_id"));
		team.setTeam_name(row.getString("team_name"));
		team.setTeam_description(row.getString("team_description"));
		return team;
	}
}
