package com.hackerearth.zuaba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DPProblem {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerearth\\zuaba\\GInput.txt"));
		int n = scan.nextInt();
		long arr[] = new long[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextLong();			
		}
		k = scan.nextInt();
		int subset[][] = new int[k+1][n+1];
		
		for (int i = 0; i <= n; i++) {
			subset[0][i] = 1;
		}
		
		for (int i = 0; i <= k; i++) {
			subset[i][0] = 0;
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if(i >= arr[j-1])
				subset[i][j] = subset[i-1][j]+ subset[i-1][(int) (j-arr[i])];
			}
		}

		System.out.println(subset[k][n]);
		scan.close();
	}

}
