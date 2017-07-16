package com.amazon.asked;

import java.util.Arrays;

public class SameDigits {

	public static void main(String[] args) {
		int res = findCount(7, 68);
		System.out.println("Res "+res);
		int arr[] = {43, 2234234, 1234122, 1023423, 62342323, 34234, 454545, 32334424};
		findProduct(arr);

	}

	private static void findProduct(int[] arr) {
		double total = 1d;
		for (int i = 0; i < arr.length; i++) {
			double expo = 1d/arr.length;
			System.out.println("Expo: "+(double)expo);
			Double val = Math.pow(arr[i], expo);
			System.out.println("val "+val.doubleValue());
			total *= val;
		}		
		System.out.println("total: "+(double)total);
		findCeiling(arr, total);
		
	}

	private static void findCeiling(int[] arr, double total) {
		double jg = Double.MAX_VALUE;
		System.out.println("just greater: "+(double)jg);
		//double prev = arr[0];
		//double next = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > total && arr[i] < jg){
				jg = arr[i];
			}
		}
		//double res = dist;
		System.out.println((int)jg);
	}

	private static int findCount(int l, int r) {
		return findCount(r) - findCount(l-1);
	}

	private static int findCount(int i) {
		if( i < 10)
			return i;
		
		int tens = i/10;
		tens = tens + 9;
		//get first digit
		int temp = i;
		while(temp%10 != temp){ // temp >= 10
			temp = temp/10;
		}
		System.out.println("first "+temp);
		int last = i%10;
		System.out.println("last "+last);
		if(last < temp)
			tens--;
		return tens;
	}

}
