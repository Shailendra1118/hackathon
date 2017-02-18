package com.amazon.asked;

import java.util.Arrays;

public class BitCombo {

	static int arr[] = {1,2,3};
	public static void main(String[] args) {
		printBits(arr.length);
	}
	
	private static void printBits(int n) {
		if(n<1)
			System.out.println(Arrays.toString(arr));
		else{
			arr[n-1] = 0;
			printBits(n-1);
			arr[n-1] = 1;
			printBits(n-1);
		}
	}

}
