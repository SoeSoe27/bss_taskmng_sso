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

	public synchronized boolean addList(ListModel list){
	       if (listDAO.listExists(list.getList_name(), list.getBoard_list_id())) {
	    	   return false;
	       } else {
	    	   listDAO.addList(list);
	    	   return true;
	       }
		}
	
	public List<ListModel> getAllTeamListsById (int boardListId) {
		List<ListModel> obj = listDAO.getAllTeamListsById(boardListId);
		return obj;
	}	
	
	public void updateList(ListModel listMD) {
		listDAO.updateList(listMD);
	}
	
	public void deleteList(int listId) {
		listDAO.deleteList(listId);
	}

}
