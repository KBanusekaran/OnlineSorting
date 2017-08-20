package com.online.sorting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.online.sorting.pojo.JsonSortings;
import com.online.sorting.pojo.JsonSorting;
import com.online.sorting.service.SortingService;
import com.online.sorting.util.SortingException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/json")
public class SortingController {

	@Autowired
	private SortingService sortingService;

	@RequestMapping(value = "/sorting", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> saveAndSortUnSortedList(@RequestBody JsonSorting sorting) {
		List<JsonSorting> sortList = new ArrayList<>();
		JsonSortings jsonSort = new JsonSortings();
		try {
			if (sorting.getGuid() == null || sorting.getGuid().isEmpty()) {
				jsonSort.setGuid(UUID.randomUUID().toString());
				sorting.setGuid(jsonSort.getGuid());
			} else {
				jsonSort.setGuid(sorting.getGuid());
			}
			sortingService.saveUnsortedList(sorting);
			sortList = sortingService.getAllSortedVales(sorting.getGuid());
			jsonSort.setSorting(sortList);
		} catch (SortingException e) {
			return new ResponseEntity<Object>(jsonSort, HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<Object>(jsonSort, HttpStatus.OK);
	}

	@RequestMapping(value = "/sorting/{guid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> getAllSortedList(@PathVariable String guid) {
		JsonSortings jsonSort = new JsonSortings();
		try {
			jsonSort.setSorting(sortingService.getAllSortedVales(guid));
		} catch (SortingException e) {
			return new ResponseEntity<Object>(jsonSort, HttpStatus.EXPECTATION_FAILED);
		}
		jsonSort.setGuid(guid);
		return new ResponseEntity<Object>(jsonSort, HttpStatus.OK);
	}

}