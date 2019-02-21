package com.concretepage.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.taskspringboot.model.ListModel;

public class ListRowMapper implements RowMapper<ListModel> {
	public ListModel mapRow(ResultSet row, int rowNum) throws SQLException {
		ListModel lists = new ListModel();
		lists.setList_id(row.getInt("list_id"));
		lists.setList_name(row.getString("list_name"));
		lists.setBoard_list_id(row.getInt("board_list_id"));
		return lists;
	}
}
