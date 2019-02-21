package com.taskspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.taskspringboot.jsonmodel.teamJson;
import com.taskspringboot.model.Team;
import com.taskspringboot.service.TeamService;

@RestController
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	/*get all team*/
	@RequestMapping("/getAllTeams")
	public ResponseEntity<List<Team>> getAllTeams() {
		List<Team> list = teamService.getAllTeams();
		return new ResponseEntity<List<Team>>(list, HttpStatus.OK);
	}
	
	/*insert team*/
	@PostMapping("insertTeam")
	public ResponseEntity<Void> insertTeam(@RequestBody teamJson team) {
		
		Team teamData= new Team();
		teamData.setTeam_name(team.getTeam_name());
		teamData.setTeam_description(team.getTeam_description());
		
        boolean flag = teamService.addTeam(teamData);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	/*update team*/
	@PutMapping("updateTeam")
	public ResponseEntity<Team> updateTeam(@RequestBody teamJson team) {
		Team teamData= new Team();
		
		teamData.setTeam_id(team.getTeam_id());
		teamData.setTeam_name(team.getTeam_name());
		teamData.setTeam_description(team.getTeam_description());
		
		teamService.updateTeam(teamData);
		return new ResponseEntity<Team>(teamData, HttpStatus.OK);
	}
	
	/*delete team*/
	@DeleteMapping("team/{id}")
	public ResponseEntity<Void> deleteTeam(@PathVariable("id") Integer id) {
		teamService.deleteTeam(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
