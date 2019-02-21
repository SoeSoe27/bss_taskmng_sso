package com.taskspringboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.concretepage.entity.ListRowMapper;
import com.taskspringboot.model.ListModel;
import com.taskspringboot.model.Team;

@Repository
public class ListDAO implements ListDAOInterface{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/*insert List*/
	@Override
	public void addList(ListModel list) {
		
		//Add List
		String sql = "INSERT INTO table_list (list_name, board_list_id) values (?, ?)";
		jdbcTemplate.update(sql, list.getList_name(), list.getBoard_list_id());
		
		//Fetch List id
		sql = "SELECT list_id FROM table_list WHERE list_name = ? and board_list_id=?";
		int listId = jdbcTemplate.queryForObject(sql, Integer.class, list.getList_name(), list.getBoard_list_id());
		
		//Set List id 
		list.setList_id(listId);
	}
	
	/*when insert list data is exist then return false*/
	@Override
	public boolean listExists(String listName, Integer listBoardId) {
		String sql = "SELECT count(*) FROM table_list WHERE list_name = ? and board_list_id=?";
		int count = jdbcTemplate.queryForObject(sql, Integer.class, listName, listBoardId);
		if(count == 0) {
    		return false;
		} else {
			return true;
		}
	}
	
	/*Get Data for list by Team Id*/
	public List<ListModel> getAllTeamListsById(int boardListId) {
		List<ListModel> listDataArray = new ArrayList<ListModel>();
		String sql = "SELECT TLIST.*, TTEAM.TEAM_NAME FROM TABLE_LIST AS TLIST LEFT JOIN TABLE_TEAM AS TTEAM ON TTEAM.TEAM_ID = TLIST.BOARD_LIST_ID WHERE BOARD_LIST_ID=?";
		List<Map<String, Object>> selectList = jdbcTemplate.queryForList(sql,boardListId); 
			for(Map<String, Object> row:selectList) {
				ListModel listAllData = new ListModel();
				listAllData.setList_id((Integer) row.get("list_id"));
				listAllData.setList_name((String) row.get("list_name"));
				listAllData.setBoard_list_id((Integer)row.get("board_list_id"));
				listDataArray.add(listAllData);
			}
		return listDataArray;
	}
	
	/*update list*/
	@Override
	public void updateList(ListModel listMD) {
		String sql = "UPDATE table_list SET list_name = ? WHERE list_id=?";
		jdbcTemplate.update(sql, listMD.getList_name(), listMD.getList_id());
	}
	
	/*delete list*/
	@Override
	public void deleteList(int listId) {
		String sql = "DELETE FROM table_list WHERE list_id=?";
		jdbcTemplate.update(sql, listId);
	}

}
