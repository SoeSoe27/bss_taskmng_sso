package com.taskspringboot.jsonmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class listJson {

	@JsonProperty("_listId")
	private Integer list_id;

	@JsonProperty("_listName")
	private String list_name;

	@JsonProperty("_listBoardId")
	private Integer board_list_id;

	public Integer getList_id() {
		return list_id;
	}

	public void setList_id(Integer list_id) {
		this.list_id = list_id;
	}

	public String getList_name() {
		return list_name;
	}

	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	public Integer getBoard_list_id() {
		return board_list_id;
	}

	public void setBoard_list_id(Integer board_list_id) {
		this.board_list_id = board_list_id;
	}

}
