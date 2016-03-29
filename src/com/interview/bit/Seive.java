package com.interview.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Seive {
	//Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

	static int parr[] = new int[100];
	static ArrayList<Integer> list = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();
	static Set<Integer> setSieve = new HashSet<>();
	//static int[] sieve = new int [100];
	public static void main(String[] args) {
		int input = 16777214; //16777214;//36; 16777214 - 31 16777183 
		generatePrime(input);
		set.addAll(list);		
		//System.out.println(set);
		
		Integer[] sieve = new Integer [input];
		//set all as prime sieve[i]=1 so i is prime - reverse
		for(int i=0; i<sieve.length; i++){
			sieve[i] = 1;
		}
		
		sieve[0] = 0;
		sieve[1] = 0;
		
		for (int i = 2; i < Math.sqrt(input); i++) {
			if(sieve[i] == 1){
				for (int j = 2; i*j < input; j++) {  // sieve.length = input
					sieve[i*j] = 0;
				}
			}
		}
		
		//print prime
		for (int i = 2; i < sieve.length; i++) {
			if(sieve[i] == 1){
				//System.out.println(i);
				setSieve.add(i);
			}
		}
	  
		
		
			//List<Integer> resultList = Arrays.asList(sieve);
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()){
				int a = iter.next();
				if(set.contains(input-a)){
					System.out.println("a "+a+" b "+(input-a));
					break;
				}
			}
		

	}
	private static void generatePrime(int number) {
		list.add(2);
		
		for(int i=2; i<number; i++){
			if(isPrime(i)){
				list.add(i);
			}
		}
		
	}
	private static boolean isPrime(int num) {
		for(int i =2; i<=Math.sqrt(num); i++){
			if(num%i ==0){
				return false;
			}
		}
		return true;
	}

}
