package com.booking.ques;

public class Fibonacci {

	static int[] lookup = new int[100];
	public static void main(String[] args) {
		System.out.println(fibo(9));
	}
	private static int fibo(int n) {
		/*if(n<=1)
			return n; //base case very important - verify with first two argument
		else{
			return fibo(n-1) + fibo(n-2);
		}*/
		
		if(n<=1)
			lookup[n] = n;
		else{
			lookup[n] = fibo(n-1) + fibo(n-2); 
		}
		
		return lookup[n];
	}

}
