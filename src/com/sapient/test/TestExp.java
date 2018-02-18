package com.sapient.test;

import java.io.IOException;
import java.util.Arrays;

public class TestExp {

	public static void main(String[] args) throws Exception {
		TestExp t = new TestExp();
		int res = t.test();
		System.out.println(res);
		
		//t.print(null); ambiguous
		//int []arr, b;
		int []arr, b; //this declare b as int array as well along with arr
		int arr1[], c;
		c = 10;
		t.print(new int[20]);
		
	}

	
	
	int test() throws Exception{
		try{
			System.out.println("In try");
			throw new IOException();
			//return 1;
		}catch(Exception e){
			System.out.println("IN catch");
			return 2;
		}finally{
			System.out.println("finally");
			//System.exit(0);
			return 3;
		}
	}
	
	public void print(int arr[]){
		System.out.println(Arrays.toString(arr));
	}
	
	public void print(String obj){
		System.out.println(obj);
	}
}
