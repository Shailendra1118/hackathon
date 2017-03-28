package com.march.prac.four;

import java.util.Arrays;

public class Inversion {

	static int counter = 0;
	public static void main(String[] args) {
		int arr[] = {5,4,3,10,6,15,12};//{5,8,1,10,9,15,18,4};
		int aux[] = Arrays.copyOf(arr, arr.length);
		countIt(arr, aux, 0, arr.length-1);
		System.out.println(Arrays.toString(arr)+" with counter: "+counter);
	}

	private static void countIt(int[] arr, int[] aux, int l, int h) {
		if(l >= h)
			return;
		int mid = l+(h-l)/2;
		
		countIt(arr, aux, l, mid);
		countIt(arr, aux, mid+1, h);
		merge(arr, aux, l, mid, h);
		
		
		
	}

	private static void merge(int[] arr, int[] aux, int l, int mid, int h) {
		for (int k = l; k <= h; k++) { 
			aux[k] = arr[k];
		}
		int i = l; // for first half
		int j = mid+1; // for second half after mid
		for (int k = l; k <= h; k++) {
			if(i > mid){				
				arr[k] = aux[j++]; //simply copying the remaining items
			}
			else if(j > h){
				System.out.println("j>>h");
				arr[k] = aux[i++];
			}
			else if(aux[j] < aux[i]){
				counter += mid-i+1;
				arr[k] = aux[j++];
			}
			else 
				arr[k] = aux[i++];
		}
		
		
	}

}
