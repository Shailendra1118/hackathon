package com.march.prac.four;

import java.util.Arrays;

public class Inversion {

	static int counter = 0;
	public static void main(String[] args) {
		int arr[] = {1, 20, 6, 4, 5};//{5,4,3,10,6,15,12};//{5,8,1,10,9,15,18,4};
		int aux[] = Arrays.copyOf(arr, arr.length);
		counter = countIt(arr, aux, 0, arr.length-1);
		System.out.println(Arrays.toString(arr)+" with counter: "+counter);
	}

	private static int countIt(int[] arr, int[] aux, int l, int h) {
		int count = 0;
		if(l >= h)
			return count;
		int mid = l+(h-l)/2;
		
		count = countIt(arr, aux, l, mid);
		count += countIt(arr, aux, mid+1, h);
		count += merge(arr, aux, l, mid+1, h);
		return count;
	}

	private static int merge(int[] arr, int[] aux, int l, int mid, int h) {
		int count = 0;
		int i = l;
		int j = mid;
		int k = l; // index in resultant merged sub-array
		while(i <= mid-1 && j <= h){
			if(arr[i] < arr[j]){
				aux[k++] = arr[i++];
			}else{
				aux[k++] = arr[j++];
				count += mid-i;
			}
		}
		while(i <= mid-1){
			aux[k++] = arr[i++];
		}
		while(j <= h){
			aux[k++] = arr[j++];
		}
		
		for (int x = l; x <= h; x++) {
			arr[x] = aux[x];
		}
		return count;
	}

}
