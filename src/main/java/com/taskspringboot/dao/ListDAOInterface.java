package com.taskspringboot.dao;

import java.util.List;

import com.taskspringboot.model.ListModel;
import com.taskspringboot.model.Team;

public interface ListDAOInterface {
	 void addList(ListModel list);
	 boolean listExists(String listName, Integer listBoardId);
	 List<ListModel> getAllTeamListsById(int boardListId);
	 void updateList(ListModel list);
	 void deleteList(int listBoardId);
}
