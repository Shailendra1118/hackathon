package com.random.bits;

public class Unique {

	public static void main(String[] args) {
		String arr[] = {"one","two","three","four"};
		String arr2[] = {"Hello", "There","one","two","six"};
		
		for(int i=0; i<arr2.length; i++){
			//arr[i] = arr[i]^arr2[i];
			byte[] a = arr[i].getBytes();
			byte[] b = arr2[i].getBytes();
			
		}
	}

}
