package com.online.sorting.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.online.sorting.dao.SortingDao;
import com.online.sorting.entity.SortingResults;
import com.online.sorting.pojo.Sorting;
import com.online.sorting.util.SortingException;

@Repository
public class SortingDAOImpl implements SortingDao{


	
	public void saveUnsortedList(Session session,Sorting sorting) throws SortingException {
		SortingResults sortingResults=new SortingResults();
		sortingResults.setGuid(sorting.getGuid());
		sortingResults.setUnSortedList(sorting.getUnSortedList());
		try {
		session.save(sortingResults);
		}catch(Exception e) {
			throw new SortingException("Save failed");
		}
	}

	public List<String> getAllUnsortedList(Session session,String guid) throws SortingException {
		List<String> unSortedString = new ArrayList<String>();
		try {
		
			Query query = session.getNamedQuery("getUnsortedList");  
			query.setString("guid", guid);  
			List<SortingResults> unSortedList = query.list();
			unSortedList.forEach(unSortedItem->{
					unSortedString.add(((SortingResults)unSortedItem).getUnSortedList());
			});
			
		} catch (Exception e) {
			throw new SortingException("Load failed");
		}
		return unSortedString;
		
	}


}
