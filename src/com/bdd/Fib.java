package com.bdd;

import java.io.Serializable;

public class Fib implements Serializable{

	public static void main(String[] args) {
		boolean res;
		int valueToCheck = 11;//Integer.parseInt(10);
		res = isFibo(valueToCheck, 0, 1);
		System.out.println((res) ? 1 : 0);

	}

	static boolean isFibo(int valueToCheck, int previousValue, int currentValue) {
	        return currentValue > valueToCheck ? false 
	        		: valueToCheck > currentValue ? true 
	        				: isFibo(valueToCheck, previousValue + currentValue, currentValue );
	    }
}
