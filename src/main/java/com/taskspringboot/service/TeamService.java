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
	
	//get team data 
	public List<Team> getAllTeams(){
		return teamDAO.getAllTeams();
	}
	
	//insert new team 
	public synchronized boolean addTeam(Team team){
       if (teamDAO.teamExists(team.getTeam_name(), team.getTeam_description())) {
    	   return false;
       } else {
    	   teamDAO.addTeam(team);
    	   return true;
       }
	}
	
	//update team
	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}
	
	//delete team
	public void deleteTeam(int team_id) {
		teamDAO.deleteTeam(team_id);
	}
	
}

