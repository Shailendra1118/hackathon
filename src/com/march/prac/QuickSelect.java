package com.march.prac;

import java.util.Arrays;

public class QuickSelect {

	public static void main(String[] args) {
		int arr[] = {12,45,67,6,1,55,68};
		//Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int largest = 3;
		int k = arr.length-largest;
		System.out.println("K is "+k);
		int res = selectIt(arr,0,arr.length-1,k);
		System.out.println("res: "+res);

	}

	private static int selectIt(int[] arr, int low, int hi, int k) {
		while(low < hi){
			int p = partition(arr, low, hi);
			if(p == k)
				return arr[p]; // or arr[k]
			else if(p < k){
				low = p+1;
			}else
				hi = p-1;
		}
		return arr[k];
	}

	private static int partition(int[] arr, int low, int hi) {
		int i = low;
		int j = hi+1;
		while(true){
			while(arr[++i] < arr[low]){
				if(i==hi)
					break;
			}
			while(arr[low] < arr[--j]){
				if(j==low)
					break;
			}
			
			if(i >= j)
				break;
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		
		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;
		System.out.println(Arrays.toString(arr));
		return j; //return j
	}

}
