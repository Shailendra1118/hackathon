package com.hackerearth.zuaba;

import java.util.TreeSet;

public class TestIris {

	public static void main(String[] args) {
		TreeSet<Student> set = new TreeSet<>();
		//set.add(new Student());
		//set.add(new Student());
		Student a = new SmartStudent();
		a.id = 5;
		System.out.println(a.getId());
		SmartStudent b = null;
		b.print();
		System.out.println(a.id);
		
		
		
		double x = 0.1;
		double y = 0.2;
		double z = x+y;
		double temp = 0.3;
		System.out.println("z is "+z);
		if((x + y) == 0.3)  // 0.1+0.2 != 0.3 (0.30000000000000004) but 0.2+0.3 == 0.5 
			System.out.println(z);
		
		if(z == 0.3)
			System.out.println("z is 0.3");
		
		System.out.println("temp is "+temp);
		if(Double.compare(z, temp) == 0)
			System.out.println("Double.compare(z, 0.3) == 0");
		
		float oneF = -0.0f;
		float twoF = 0.0f;
		System.out.println(oneF == twoF);   // true
		
		throw new OutOfMemoryError();
		
		
	}

}


class Student{
	int id;
	String name;
	
	public int getId(){
		return id;
	}
	
	//public void print(){
	//	System.out.println("A student");
	//}
}

class SmartStudent<T> extends Student{
	int id;
	String name;
	
	public int getId(){
		return id;
	}
	
	public static void print(){
		System.out.println("B student");
	}
	
	
}