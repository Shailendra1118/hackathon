package com.applied;

public class NonDuplicate {

	public static void main(String[] args) {
		int arr[] = {2,1,2,4,1,4,3,5,5,1,1};
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			temp = temp ^ arr[i];
		}
		System.out.println(temp);

	}

}
