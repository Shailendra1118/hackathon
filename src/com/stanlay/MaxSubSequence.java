package com.stanlay;


public class MaxSubSequence {

	public static void main(String[] args) {
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
		//youtube
		int max_curr = arr[0], max_global = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max_curr = Math.max(arr[i], max_curr + arr[i]);
			if(max_curr > max_global)
				max_global = max_curr;
		}
		System.out.println("max_global:"+max_global);
		maxProduct(arr);
		
	}

	private static void maxProduct(int[] arr) {
		int max_end = 1;
		int min_end = 1, max_sofar = 1;
		
		for (int i = 0; i < arr.length; i++) {
			//positive
			if(arr[i] > 0){
				max_end = max_end * arr[i];
				min_end = Math.min(min_end * arr[i], 1);
			}
			//negative
			if(arr[i] < 0){ 
				int temp = max_end;
				max_end = Math.max(min_end * arr[i], 1);
				min_end = temp * arr[i];
			}
			/* If this element is 0, then the maximum product cannot
	            end here, make both max_ending_here and min_ending
	           _here 0 Assumption: Output is always greater than or equal to 1. */
	         else if (arr[i] == 0)
	         {
	             max_end = 1;
	             min_end = 1;
	         }
			System.out.println("min:"+min_end+", max:"+max_end);
			//update max_sofar
			if(max_sofar < max_end){
				max_sofar = max_end;
			}
		}
		
		System.out.println("maxProduct:"+max_sofar);
	}

}
