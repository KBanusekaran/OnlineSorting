package com.online.sorting.service;

import java.util.List;

import com.online.sorting.pojo.Sorting;
import com.online.sorting.util.SortingException;

public interface SortingService {
	
	public List<Sorting> getPreviousSortedVales(String guidValue) throws SortingException;
	
	public void saveUnsortedList(Sorting sorting) throws SortingException;
}
