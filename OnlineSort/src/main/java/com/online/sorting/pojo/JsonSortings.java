package com.online.sorting.pojo;

import java.util.List;

public class JsonSortings {
	private String guid;
	private List<JsonSorting> sorting;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public List<JsonSorting> getSorting() {
		return sorting;
	}

	public void setSorting(List<JsonSorting> sorting) {
		this.sorting = sorting;
	}

}
