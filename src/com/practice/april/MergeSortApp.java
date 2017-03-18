package com.practice.april;

import java.util.Arrays;

public class MergeSortApp {

	public static void main(String[] args) {
		Integer[] arr = {2,6,3,5,1};		
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static Comparable<Integer>[] mergeSort(Integer[] list) {
		
		if(list.length == 1)
			return list;
		
		// performance bug here ??
		Integer[] first = new Integer[list.length/2];
		Integer[] second = new Integer[list.length - first.length];
		
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		mergeSort(first);
		mergeSort(second);
		
		merge(first, second, list);
		System.out.println("first "+Arrays.toString(first)+" second "+Arrays.toString(second)+" list "+
				Arrays.toString(list));
		return list;
		
	}

	private static void merge(Integer[] first, Integer[] second, Integer[] result) {
		int fctr = 0;
		int sctr = 0;
		int mctr = 0;
		
		while(fctr < first.length && sctr < second.length){
			if(first[fctr].compareTo(second[sctr]) < 0){
				result[mctr] = first[fctr];
				mctr++;
				fctr++;
			}else{
				result[mctr] = second[sctr];
				mctr++;
				sctr++;
			}	
		}
		
		System.arraycopy(first, fctr, result, mctr, first.length - fctr);
		System.arraycopy(second, sctr, result, mctr, second.length - sctr);
		
	}

}
