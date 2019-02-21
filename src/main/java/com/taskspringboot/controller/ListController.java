package com.taskspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.taskspringboot.jsonmodel.listJson;
import com.taskspringboot.jsonmodel.teamJson;
import com.taskspringboot.model.ListModel;
import com.taskspringboot.model.Team;
import com.taskspringboot.service.ListService;

@RestController
public class ListController {
	@Autowired
	private ListService listService;
	
	/*Get List All Data for Team*/
	@GetMapping("getAllTeamLists/{id}")
	public ResponseEntity<List<ListModel>> getAllTeamLists(@PathVariable("id") Integer id) {
		List<ListModel> listData = listService.getAllTeamListsById(id);
		return new ResponseEntity<List<ListModel>>(listData, HttpStatus.OK);
	}
	
	/*insert list*/
	@PostMapping("insertList")
	public ResponseEntity<Void> insertList(@RequestBody listJson list, UriComponentsBuilder builder) {
		
		ListModel listData= new ListModel();
		listData.setList_name(list.getList_name());
		listData.setBoard_list_id(list.getBoard_list_id());
		
        boolean flag = listService.addList(listData);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/list/{id}").buildAndExpand(list.getList_id()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	/*update list*/
	@PutMapping("updateList")
	public ResponseEntity<ListModel> updateTeam(@RequestBody listJson listJ) {
		ListModel listData= new ListModel();
		
		listData.setList_id(listJ.getList_id());
		listData.setList_name(listJ.getList_name());
		listData.setBoard_list_id(listJ.getBoard_list_id());
		listService.updateList(listData);
		return new ResponseEntity<ListModel>(listData, HttpStatus.OK);
	}
	
	/*delete list*/
	@DeleteMapping("deleteList/{id}")
	public ResponseEntity<Void> deleteList(@PathVariable("id") Integer id) {
		listService.deleteList(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
