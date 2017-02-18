package com.practice.april.core;

public class ParentC {
	static String name = "Bean";
	static{
		System.out.println("Parent Static block");
	}
	{
		System.out.println("Parent simple block");
	}
}
