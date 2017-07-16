package com.hackerrank.dp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrazyTree {

	public static void main(String[] args) throws FileNotFoundException {

		 Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\dp\\treeInput.txt"));
		 int level = scan.nextInt();
		 long queries = scan.nextLong();
		 for (int i = 0; i < queries; i++) {
			 //S(N,X,Y) % M, where M = 1299709
			 long lvl = scan.nextLong();
			 long start = scan.nextLong();
			 long end = scan.nextLong();
			 long arr[] = buildTree(level);
			 process(lvl, start, end, arr);
			 
		}
         
         
         
         
         scan.close();
	}

	private static long[] buildTree(int level) {
		// total node for level: 2^n - 1
		// leaves node: 2^(n-1)
		int nodes = (int) (Math.pow(2, level)-1);
		//System.out.println("total nodes: "+nodes+" for level: "+level);
		int leaves = (int) (Math.pow(2, level-1));
		//System.out.println("leaves nodes: "+leaves);
		long arr[] = new long[nodes+1];
		int i = 1;
		for (; i <= leaves; i++) {
			arr[i] = i;
		}
		
		for (int j = 1; j < arr.length && (j+1) < arr.length-1; j=j+2) {
			arr[i] = arr[j]*arr[j+1]; 
			i++;
		}
		//System.out.println(Arrays.toString(arr));		
		
		
		return arr;
	}

	private static void process(long lvl, long start, long end, long[] arr) {
		//reach at that level
		long rootIdx = arr.length-1;
		int idx = 0, i = 1;
		while(lvl >= 1){
			rootIdx = rootIdx - idx;
			idx = (int) Math.pow(2, i);
			i++;
			lvl--;
		}
		//System.out.println("start idx: "+rootIdx);
		long sum = 0l;
		for (long j = start; j <= end; j++) {
			sum = sum + arr[(int) (rootIdx+(j-1))];
		}
		
		System.out.println(sum%1299709);
		
	}

}
