package com.online.sorting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "getUnsortedList",  
	        query = "from SortingResults s where s.guid = :guid"  
	        )  
	    }  
	) 
public class SortingResults {
	@Id
	@GeneratedValue
	@Column (name="sortId")
	private Long sortId;
	
	@Column (name="guid", nullable=false)
	private String guid;
	
	@Column (name="unSortedList", nullable=false)
	private String unSortedList;

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

}
