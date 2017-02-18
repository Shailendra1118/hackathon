package com.practice.april.core;

public class Testing {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = new String("hello");
		String s3 = "hello";
		String s4 = s2.intern();
		
		System.out.println(s4.equals(s2));
	}

}
