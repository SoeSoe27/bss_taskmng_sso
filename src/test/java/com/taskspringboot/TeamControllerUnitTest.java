package com.taskspringboot;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.taskspringboot.controller.TeamController;
import com.taskspringboot.jsonmodel.teamJson;
import com.taskspringboot.model.Team;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)

/*Unit Testing for Team Controller */

public class TeamControllerUnitTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private TeamController teamController;

	@Before
	public void setup() throws Exception {
		this.mvc = MockMvcBuilders.standaloneSetup(this.teamController).build();// Standalone context
	}

	//unitTest for Get All Team List
	@Test
	public void getTeamTest() throws Exception {

		List<Team> teamList = new ArrayList<Team>();
		Team teams = new Team();
		teams.setTeam_id(2);
		teams.setTeam_name("CRM");
		teams.setTeam_description("Adroid");
		teamList.add(teams);
		ResponseEntity<List<Team>> reTeam = new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);

		BDDMockito.given(teamController.getAllTeams()).willReturn(reTeam);
		mvc.perform(MockMvcRequestBuilders.get("/getAllTeams")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].team_name", is("CRM")));
	}

	//unitTest for insert Team
	@Test
	public void insertTeamTest() throws Exception {

		Team team = new Team();
		team.setTeam_name("Admin");
		team.setTeam_description("Des Admin");

		teamJson tJ = new teamJson();
		tJ.setTeam_name(team.getTeam_name());
		tJ.setTeam_description(team.getTeam_description());

		Gson gson = new Gson();
		String json = gson.toJson(team);

		ResponseEntity<Void> reTeam = new ResponseEntity<Void>(HttpStatus.CREATED);

		BDDMockito.given(teamController.insertTeam(Matchers.any(teamJson.class))).willReturn(reTeam);
		mvc.perform(MockMvcRequestBuilders.post("/insertTeam")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isCreated());
	}

	//unitTest for Update Team
	@Test
	public void updateTeamTest() throws Exception {

		Team team = new Team();
		team.setTeam_name("Admin");
		team.setTeam_description("Des Admin");
		team.setTeam_id(6);

		teamJson tJ = new teamJson();
		tJ.setTeam_id(team.getTeam_id());
		tJ.setTeam_name(team.getTeam_name());
		tJ.setTeam_description(team.getTeam_description());

		ResponseEntity<Team> reTeam = new ResponseEntity<Team>(team, HttpStatus.OK);

		Gson gson = new Gson();
		String json = gson.toJson(team);

		BDDMockito.given(teamController.updateTeam(Matchers.any(teamJson.class))).willReturn(reTeam);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.put("/updateTeam")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json).characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(json))
				.andReturn();

		String res = result.getResponse().getContentAsString();
		System.out.println("Result is " + res);
	}

	//unitTest for Delete Team
	@Test
	public void deleteTeam() throws Exception {

		ResponseEntity<Void> reTeam = new ResponseEntity<Void>(HttpStatus.OK);

		BDDMockito.given(teamController.deleteTeam(Matchers.any(Integer.class))).willReturn(reTeam);
		mvc.perform(MockMvcRequestBuilders.delete("/team/1")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

}
