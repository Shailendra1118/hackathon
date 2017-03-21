package com.march.prac.three;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr = {23, 5, 55, 21, 44, 6, 2, 55, 8, 11, 4, 22, 55, 11 };
		// TODO shuffle array for better ?
		quicksortIt(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quicksortIt(Integer[] arr, int low, int hi) {
		if(low >= hi)
			return;
		int p = partition(arr, low, hi);
		quicksortIt(arr, low, p-1);
		quicksortIt(arr, p+1, hi);
		
	}

	private static int partition(Integer[] arr, int low, int hi) {
		int i = low;
		int j = hi+1;
		while(true){
			// get to appropriate element to be exchanged, find item on left to be swapped
			while(less(arr[++i], arr[low])){
				if(i== hi)
					break;
			}
			
			while(less(arr[low], arr[--j])){
				if(j== low)
					break;
			}
			
			if(i >= j) // pointers cross
				break;
			
			exch(arr, i, j);			
		}
		exch(arr, low, j); // j points to the right most element in the left side (all elements less than pivot)
		System.out.println("---"+Arrays.toString(arr));
		return j;
	}
	
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] arr, int first, int second){ 
		Comparable temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}

}
