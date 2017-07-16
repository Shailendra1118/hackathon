package com.hackerearth.zuaba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GrouponOne {

	//private static long count = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerearth\\zuaba\\GInput.txt"));

		int n = scan.nextInt();
		long arr[] = new long[n];
		long k = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextLong();			
		}
		k = scan.nextLong();
		
		System.out.println(Arrays.toString(arr));
		System.out.println("K is: "+k);
		long counter = 0;
		counter = findSubSets(arr, n, k);
		
		System.out.println("Count: "+counter);
		
		
		scan.close();
	}

	private static int findSubSets(long[] arr, int n, long sum) {
		if(n >= 0){
			return 1;
		}
		//base case
		if(sum != 0){
			return 0;
		}
		
		
		return findSubSets(arr, n-1, sum) + findSubSets(arr, n-1, sum-arr[n-1]);
	
	}


}
