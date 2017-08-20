package com.online.sorting.util;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.online.sorting.pojo.JsonSorting;

public class SortingUtil {

	public static void bubbleSort(JsonSorting sorting) {
		long[] unSortedArray = Arrays.stream(sorting.getUnSortedList().split(",")).map(String::trim)
				.mapToLong(Long::parseLong).toArray();
		int n = unSortedArray.length;
		long temp = 0;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (unSortedArray[j - 1] > unSortedArray[j]) {
					// swap elements
					temp = unSortedArray[j - 1];
					unSortedArray[j - 1] = unSortedArray[j];
					unSortedArray[j] = temp;
					sorting.exchange();
				}

			}
		}
		long endTime = System.currentTimeMillis();
		sorting.setExecutionTime(String.valueOf(endTime - startTime));
		sorting.setSortedList(LongStream.of(unSortedArray).mapToObj(Long::toString).collect(Collectors.joining(",")));
	}
}
