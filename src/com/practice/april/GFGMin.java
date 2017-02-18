package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class GFGMin
{
	public static void main (String[] args) throws FileNotFoundException
	 {
	    //Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("D:/Keppler/Hackerrank/src/com/practice/april/LLinput.txt"));
		int size = scanner.nextInt();
	    Integer [] arr = null;
	    for(int i=0; i<size; i++){
	        int len = scanner.nextInt();
	        arr = new Integer[len];
	        int j = 0;
	        while(len>0){
	            arr[j] = Integer.valueOf(scanner.next());
	            j++;
	            len--;
	        }
	        
	        findMin(arr);
	        
	    }
	    scanner.close();
	 }
	 
	 public static void findMin(Integer arr[]){
	     mergeSort(arr);
	     int min = 999;
	     for(int i=0; i<arr.length && (i+1 < arr.length); i++){
	         int diff = arr[i+1] - arr[i];
	         if(diff < min)
	            min = diff;
	     }
	     
	     System.out.println(min);
	 }
	 
	 private static Comparable<Integer>[] mergeSort(Integer[] list) {
		
		if(list.length == 1)
			return list;
		
		Integer[] first = new Integer[list.length/2];
		Integer[] second = new Integer[list.length - first.length];
		
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		mergeSort(first);
		mergeSort(second);
		
		merge(first, second, list);
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