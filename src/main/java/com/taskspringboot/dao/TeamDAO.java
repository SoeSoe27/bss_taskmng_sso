package com.taskspringboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.TeamRowMapper;
import com.taskspringboot.model.Team;

@Repository
public class TeamDAO implements TeamDAOInterface{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*Get Data for Team*/
	public List<Team> getAllTeams() {
		String sql = "SELECT * FROM TABLE_TEAM";
		RowMapper<Team> rowMapper = new TeamRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}	
	
	/*insert Team*/
	@Override
	public void addTeam(Team team) {
		//Add team
		String sql = "INSERT INTO table_team (team_name, team_description) values (?, ?)";
		jdbcTemplate.update(sql, team.getTeam_name(), team.getTeam_description());
		
		//Fetch team id
		sql = "SELECT team_id FROM table_team WHERE team_name = ? and team_description=?";
		int teamId = jdbcTemplate.queryForObject(sql, Integer.class, team.getTeam_name(), team.getTeam_description());
		
		//Set team id 
		team.setTeam_id(teamId);
	}
	
	/*when insert data is exist then return false*/
	@Override
	public boolean teamExists(String name, String description) {
		String sql = "SELECT count(*) FROM table_team WHERE team_name = ? and team_description=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, name, description);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	
	/*update team*/
	@Override
	public void updateTeam(Team team) {
		String sql = "UPDATE table_team SET team_name = ?, team_description =? WHERE team_id=?";
		jdbcTemplate.update(sql, team.getTeam_name(), team.getTeam_description(), team.getTeam_id());
	}
	
	/*delete team*/
	@Override
	public void deleteTeam(int teamId) {
		String sql = "DELETE FROM table_team WHERE team_id=?";
		jdbcTemplate.update(sql, teamId);
	}
	
}
