package com.taskspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taskspringboot.model.ListModel;
import com.taskspringboot.service.ListService;

/*unit test for List service*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListServiceUintTest {

	@Autowired
	private ListService listService;
	
	@Test
	public void getAllTeamListsById() {
		List<ListModel> list = listService.getAllTeamListsById(3);
		assertThat(list).isNotNull().isNotEmpty();
	}
	
	@Test
	public void insertList() {
		ListModel listMD = new ListModel();
		listMD.setList_name("Insert List Name");
		listMD.setBoard_list_id(1);
		
		boolean newList = listService.addList(listMD);
		System.out.println(newList);
		if(newList) {
			assertThat(newList);
		}
	}
	
	@Test
	public void updateList() {
		ListModel listMD = new ListModel();
		listMD.setList_id(2);
		listMD.setList_name("CRM to ERP");
		listMD.setBoard_list_id(3);
		listService.updateList(listMD);
		assertThat(listService);
	}
	
	@Test
	public void deleteList() {
		listService.deleteList(8);
		assertThat(listService);
	}
}
