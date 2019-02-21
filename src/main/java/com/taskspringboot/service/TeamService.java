package com.taskspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskspringboot.dao.TeamDAOInterface;
import com.taskspringboot.model.Team;
@Repository
public class TeamService {
	
	@Autowired
	private TeamDAOInterface teamDAO;
	
	public List<Team> getAllTeams(){
		return teamDAO.getAllTeams();
	}
	
	public synchronized boolean addTeam(Team team){
       if (teamDAO.teamExists(team.getTeam_name(), team.getTeam_description())) {
    	   return false;
       } else {
    	   teamDAO.addTeam(team);
    	   return true;
       }
	}
	
	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}
	
	public void deleteTeam(int team_id) {
		teamDAO.deleteTeam(team_id);
	}
	
}

