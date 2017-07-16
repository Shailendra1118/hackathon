package com.hackerrank.dp;

public class Fibbo {

	public static void main(String[] args) {
		
		int res = findWays(5);
		System.out.println("Res: "+res);

	}

	private static int findWays(int n) {
		
		if(n <=1){
			return 1;
		}
		return findWays(n-1) + findWays(n-2);
		
	}

}
