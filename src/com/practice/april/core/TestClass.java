package com.practice.april.core;


public class TestClass{

	public static void main(String args[]){
		//ChildC c = new ChildC();
		System.out.println(ParentC.name);
	}
}

class ChildC extends ParentC{
	
	//static String name = "Mr Bean";
	
	static{
		System.out.println("Child Static block");
	}
	{
		System.out.println("Child simple block");
	}
}


