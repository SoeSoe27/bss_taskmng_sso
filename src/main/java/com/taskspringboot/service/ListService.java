package com.taskspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taskspringboot.dao.ListDAOInterface;
import com.taskspringboot.model.ListModel;
import com.taskspringboot.model.Team;

@Repository
public class ListService {
	
	@Autowired
	private ListDAOInterface listDAO;

	//insert new List
	public synchronized boolean addList(ListModel list){
	       if (listDAO.listExists(list.getList_name(), list.getBoard_list_id())) {
	    	   return false;
	       } else {
	    	   listDAO.addList(list);
	    	   return true;
	       }
		}
	
	//get list by Id
	public List<ListModel> getAllTeamListsById (int boardListId) {
		List<ListModel> obj = listDAO.getAllTeamListsById(boardListId);
		return obj;
	}	
	
	//update List
	public void updateList(ListModel listMD) {
		listDAO.updateList(listMD);
	}
	
	//delete list
	public void deleteList(int listId) {
		listDAO.deleteList(listId);
	}

}
