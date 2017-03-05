package com.march.prac;

import java.util.Arrays;

public class QuickFind {

	static int arr[] = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		
		union(4,3);
		union(3,8);
		union(6,5);
		union(9,4);
		union(2,1);
		union(5,0);
		union(7,2);
		union(6,1);
		System.out.println(Arrays.toString(arr));
		System.out.println(isConnected(0, 1));

	}
	
	private static boolean isConnected(int a, int b){
		return arr[a] == arr[b];
		
	}
	
	private static void union(int a, int b){
		if(arr[a] == arr[b]){
			System.out.println("already connected.");
			return;
		}			
		int temp = arr[a];		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == temp)
				arr[i] = arr[b];
		}
	}
	
}
