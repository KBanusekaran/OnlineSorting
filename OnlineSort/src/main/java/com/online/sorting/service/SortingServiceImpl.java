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
import com.online.sorting.pojo.Sorting;
import com.online.sorting.util.SortingException;
import com.online.sorting.util.SortingUtil;

@Service
public class SortingServiceImpl implements SortingService {

	@Autowired
	private JpaSessionFactory jpaSessionFactory;

	@Autowired
	private SortingDao sortingDao;

	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Sorting> getPreviousSortedVales(String guidValue) throws SortingException {
		List<Sorting> sorting = new ArrayList<>();
		Session session = jpaSessionFactory.getSortingSessionFactory().getCurrentSession();
		sortingDao.getAllUnsortedList(session,guidValue).forEach(unSortedString->{
			Sorting result = new Sorting();
			result.setGuid(guidValue);
			result.setUnSortedList(unSortedString);
			long[] unSortedArray=Arrays.stream(unSortedString.split(",")).map(String::trim).mapToLong(Long::parseLong).toArray();		
			long startTime=System.currentTimeMillis();
			result.setSortedList(SortingUtil.bubbleSort(unSortedArray,result));
			long endTime=System.currentTimeMillis();
			result.setExecutionTime(String.valueOf(endTime-startTime));
			sorting.add(result);
		});
		return sorting;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { SortingException.class })
	public void saveUnsortedList(Sorting sorting) throws SortingException {
		Session session = jpaSessionFactory.getSortingSessionFactory().getCurrentSession();
		sortingDao.saveUnsortedList(session, sorting);
	}

}
