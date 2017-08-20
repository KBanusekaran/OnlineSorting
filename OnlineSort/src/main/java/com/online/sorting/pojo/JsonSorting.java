package com.online.sorting.pojo;

public class JsonSorting {
	private String guid;
	private String unSortedList;
	private String SortedList;
	private String executionTime;
	private Integer noOfSteps=0;
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getUnSortedList() {
		return unSortedList;
	}

	public void setUnSortedList(String unSortedList) {
		this.unSortedList = unSortedList;
	}

	public String getSortedList() {
		return SortedList;
	}

	public void setSortedList(String sortedList) {
		SortedList = sortedList;
	}

	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}

	public Integer getNoOfSteps() {
		return noOfSteps;
	}

	public void exchange() {
		this.noOfSteps++;
	}
}
