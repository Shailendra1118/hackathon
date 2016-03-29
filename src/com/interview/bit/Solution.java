package com.interview.bit;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String args[]){
		System.out.println(primesum(16777214));
	}
    public static ArrayList<Integer> primesum(int A) {
       ArrayList<Integer> arr = new ArrayList<Integer>();
       for (int i = 2; i < A; i++) {
           if (isPrime(i) && isPrime(A - i)) {
               arr.add(i);
               arr.add(A - i);
               return arr;
           }
       }
       return arr;
   }

   public static boolean isPrime(int number) {
       for (int i = 2; i <= Math.sqrt(number); i++) {
           if (number % i == 0) {
               return false;
           }
       }
       return true;
   }
}

