package com.march.prac.three;

import java.util.Arrays;

public class MergeSort {
	static int CUTOFF = 0;
	static int counter = 0;
	
	public static void main(String[] args) {
		Integer[] arr = {1,20,6,4,5}; //{23, 4, 45, 7, 100, 31, 14, 71, 1, 44}; // {5, 7, 11, 18, 20, 23, 64, 70, 77};
		System.out.println(Arrays.toString(arr));
		mergeSortIt(arr);
		System.out.println(Arrays.toString(arr)+" counter: "+counter);
	}

	public static void mergeSortIt(Integer[] arr) {
		Integer aux[] = Arrays.copyOf(arr, arr.length);
		sortIt(arr, aux, 0, arr.length-1);
	}

	private static void sortIt(Integer[] arr, Integer[] aux, int lo, int hi) {
		if(lo >= hi)
			return;
		if(hi <= CUTOFF + lo - 1){
			System.out.println("Applying insertion sort...");
			insertionSortIt(arr);
			return;
		}
		int mid = (hi-lo)/2+lo;
		sortIt(arr, aux, lo, mid);
		sortIt(arr, aux, mid+1, hi);
		// if already sorted 
		//if(less(arr[mid], arr[mid+1])){ TODO un-comment
		//	System.out.println("Already sorted, returning..");
		//	return;
		//}
		mergeIt(arr, aux, lo, mid, hi);
	}

	// abstract in-place merge
	private static void mergeIt(Integer[] arr, Integer[] aux, int lo, int mid,
			int hi) {
		System.out.println("low:"+lo+" mid:"+mid+" high:"+hi);
		System.out.println("arr: "+Arrays.toString(arr));
		System.out.println("aux: "+Arrays.toString(aux));
		
		// assertion to assert the pre-condition for this method
		assert isSorted(arr, lo, mid);
		assert isSorted(arr, mid+1, hi);
		
		for (int k = lo; k <= hi; k++) {  //=
			aux[k] = arr[k];
		}
		// two pointer to compare in aux array
		int i = lo; // for first half
		int j = mid+1; // for second half after mid
		for (int k = lo; k <= hi; k++) {
			if(i > mid)
				arr[k] = aux[j++];
			else if(j > hi)
				arr[k] = aux[i++];
			else if(less(aux[j], aux[i])){
				arr[k] = aux[j++];
				System.out.println("Mid: "+mid);
				counter = counter + mid -i + 1;
			}
			else
				arr[k] = aux[i++];
		}
		
		assert isSorted(arr, lo, hi);
		
	}
	
	private static boolean less(Comparable<Integer> a, Comparable<Integer> b){
		return a.compareTo((Integer)b) < 0;
	}

	private static boolean isSorted(Integer[] arr, int lo, int hi) {
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1])
				return false;
		}
		return true;
	}
	
	private static void insertionSortIt(Comparable<Integer>[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(less(arr[j], arr[j-1])){
					exch(arr, j, j-1);
				}
			}
		}
	}
	
	private static void exch(Comparable<Integer>[] arr, int i, int j){ 
		Comparable<Integer> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

}
