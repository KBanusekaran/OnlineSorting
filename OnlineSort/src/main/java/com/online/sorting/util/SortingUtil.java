package com.online.sorting.util;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

import com.online.sorting.pojo.Sorting;

public class SortingUtil {
	

	public static String bubbleSort(long[] arr,Sorting sorting) {
		int n = arr.length;
		long temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					sorting.exchange();
				}

			}
		}
	  return LongStream.of(arr).mapToObj(Long::toString).collect(Collectors.joining(","));
	}
}
