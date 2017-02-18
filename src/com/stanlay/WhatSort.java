package com.stanlay;

import java.util.Arrays;


public class WhatSort {
	
	static int arr[] = {2,4,1,6,8,5,3,7};
	public static void main(String[] args) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		mergeSort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	private static int[] mergeSort(int[] input) {
		int l = 0;
		int r = input.length;
		int mid = l+(r-l)/2;
		
		if(input.length == 1)
			return input;
		else{
			//partition
			int left[] = partition(input, 0, mid);
			int right[] = partition(input, mid, r );
			
			mergeSort(left);
			mergeSort(right);
			
			merge(left, right, input);
			System.out.println("first "+Arrays.toString(left)+" second "+Arrays.toString(right)+" list "+
					Arrays.toString(input));
			return input;
		}
		
	}

	private static void merge(int[] first, int[] second, int[] result) {
		int fctr = 0;
		int sctr = 0;
		int mctr = 0;
		
		while(fctr < first.length && sctr < second.length){
			if(first[fctr] < second[sctr]){
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

	private static int[] partition(int[] input, int l, int r) {
		int arr[] = new int[r-l];
		System.arraycopy(input, l, arr, 0, arr.length);
		return arr;
	}

}
