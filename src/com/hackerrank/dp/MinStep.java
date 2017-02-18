package com.hackerrank.dp;

public class MinStep {

	static int memo[] = new int[11];
	public static void main(String[] args) {
		int n = 10;
		//top-bottom approach
		int res = findMin(n);
		System.out.println("Result: "+res);
		
		int resBu = findMinBu(n);
		System.out.println("Result: "+resBu);
	}

	private static int findMin(int n) {
		if(n == 1){
			//System.out.println("base case with n: "+n);
			return 0; //base case
		}
		if(memo[n] != 0){
			//System.out.println("saving n="+n+" in memo");
			return memo[n];
		}
		//System.out.println("n="+n+" calling -1 with n-1:"+(n-1));
		int res = 1 + findMin(n-1);
		//System.out.println("after -1 condition here res="+res);
		if(n%2 == 0) {
			//System.out.println("calling with n/2="+(n/2));
			res = Math.min(res, 1 + findMin(n/2));
			//System.out.println("result after n/2="+res);
		}
		if(n%3 == 0){
			//System.out.println("calling with n/3="+(n/3));
			res = Math.min(res, 1 + findMin(n/3));
			//System.out.println("result after n/3="+res);
		}
		memo[n] = res;
		//System.out.println("return res="+res+" here n was "+n);
		return res;
		
	}
	
	private static int findMinBu(int n){
		int arr[] = new int [n+2];
		arr[1] = 0;
		int i;
		for (i = 2; i<=n; i++) {
			arr[i] = 1+arr[i-1];
			if(i%2 == 0)
				arr[i] = Math.min(arr[i], 1+arr[i/2]);
			if(i%3 == 0)
				arr[i] = Math.min(arr[i], 1+arr[i/3]);
			System.out.println("i-"+i+" arr[i]:"+arr[i]);
		}
		return arr[n];
	}

}
