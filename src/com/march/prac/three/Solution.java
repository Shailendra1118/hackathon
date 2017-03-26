package com.march.prac.three;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	
	public static void main(String[] args) {
		int[] A = {40,40,100,80,20};
		int[] B = {3,3,2,2,3};
		int X = 5;
		int Y = 200;
		int M = 3;
		int res = solution(A, B, M, X, Y);
		System.out.println("res: "+res);
	}

	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		int totalStops = 0;
		for (int cur = 0; cur < A.length;) {
			int totalW = 0;
			int totalCap = 0;
			Set<Integer> floors = new TreeSet<>();
			while(totalW < Y && totalCap < X && cur < A.length){
				totalW = totalW + A[cur];
				if(totalW > Y)
					break;
				floors.add(B[cur]);
				totalCap = totalCap + 1;
				cur++;
			}
			//start();
			Iterator<Integer> iter = floors.iterator();
			while(iter.hasNext()){
				iter.next();
				totalStops++;
			}
			totalStops++;
		}
		
		
		return totalStops;
    }
}
