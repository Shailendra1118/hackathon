package com.ib.hrank;

import java.util.Arrays;

public class TrappedWater {

	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int water = findWater(arr);
		System.out.println("Water: "+water);
	}

	private static int findWater(int[] arr) {
		int water = 0;
		int left[] = new int[arr.length];
		int[] right = new int[arr.length];
		
		left[0] = arr[0];
		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(left[i-1], arr[i]);			
		}
		System.out.println("Left: "+Arrays.toString(left));
		
		right[arr.length-1] = arr[arr.length-1];
		for (int i = arr.length-2; i >=0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);			
		}
		System.out.println("Right: "+Arrays.toString(right));
		
		for (int i = 0; i < arr.length; i++) {
			water = water + Math.min(left[i], right[i]) - arr[i];
		}
		
		return water;
	}

}
