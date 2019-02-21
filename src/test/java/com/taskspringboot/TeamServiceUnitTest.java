package com.taskspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskspringboot.model.Team;
import com.taskspringboot.service.TeamService;

/*unit test for Team*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceUnitTest {
	@Autowired
	private TeamService teamService;
	
	@Test
	public void getTeamAll() {
		List<Team> list = teamService.getAllTeams();
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@Test
	public void insertTeam() {
		Team team = new Team();
		team.setTeam_name("Insert Test Team");
		team.setTeam_description("Insert Description");
		
		boolean newTeam = teamService.addTeam(team);
		System.out.println(newTeam);
		if(newTeam) {
			assertThat(newTeam);
		}
	}
	
	@Test
	public void updateTeam() {
		Team team = new Team();
		team.setTeam_name("Odoo");
		team.setTeam_description("Team 7 Description");
		team.setTeam_id(7);
		
		teamService.updateTeam(team);
		
		assertThat(teamService);
	}
	
	@Test
	public void deleteTeam() {
		teamService.deleteTeam(8);
		assertThat(teamService);
	}
}
