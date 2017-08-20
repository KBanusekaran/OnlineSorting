package com.online.sorting.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.online.sorting.dao.JpaSessionFactory;
import com.online.sorting.dao.SortingDao;
import com.online.sorting.pojo.JsonSorting;
import com.online.sorting.util.SortingException;
import com.online.sorting.util.SortingUtil;

@Service
public class SortingServiceImpl implements SortingService {

	@Autowired
	private JpaSessionFactory jpaSessionFactory;

	@Autowired
	private SortingDao sortingDao;

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<JsonSorting> getAllSortedVales(String guidValue) throws SortingException {
		List<JsonSorting> sorting = new ArrayList<>();
		Session session = jpaSessionFactory.getSortingSessionFactory().getCurrentSession();
		sortingDao.getAllUnsortedList(session,guidValue).forEach(unSortedString->{
			JsonSorting result = new JsonSorting();
			result.setGuid(guidValue);
			result.setUnSortedList(unSortedString);					
			SortingUtil.bubbleSort(result);
			sorting.add(result);
		});
		return sorting;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SortingException.class })
	public void saveUnsortedList(JsonSorting sorting) throws SortingException {
		Session session = jpaSessionFactory.getSortingSessionFactory().getCurrentSession();
		sortingDao.saveUnsortedList(session, sorting);
	}

}
