package com.online.sorting.dao;


import java.util.List;

import org.hibernate.Session;

import com.online.sorting.pojo.JsonSorting;
import com.online.sorting.util.SortingException;

public interface SortingDao {

	public void saveUnsortedList(Session session, JsonSorting sorting) throws SortingException;

	public List<String> getAllUnsortedList(Session session, String guid) throws SortingException;
}
