package com.online.sorting.service;

import java.util.List;

import com.online.sorting.pojo.JsonSorting;
import com.online.sorting.util.SortingException;

public interface SortingService {
	
	public List<JsonSorting> getAllSortedVales(String guidValue) throws SortingException;
	
	public void saveUnsortedList(JsonSorting sorting) throws SortingException;
}
