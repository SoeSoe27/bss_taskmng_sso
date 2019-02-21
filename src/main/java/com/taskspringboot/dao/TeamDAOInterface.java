package com.taskspringboot.dao;

import java.util.List;

import com.taskspringboot.model.Team;

public interface TeamDAOInterface {
	  List<Team> getAllTeams();
	  boolean teamExists(String name, String description);
	  void addTeam(Team team);
	  void updateTeam(Team team);
	  void deleteTeam(int team_id);
}
