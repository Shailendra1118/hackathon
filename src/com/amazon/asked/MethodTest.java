package com.amazon.asked;

public class MethodTest {

	public static void main(String[] args) {
		MethodTest test = new MethodTest();
		String str = "Bye Bye";
		test.print(str);
		System.out.println("test.print(str) "+str);
		
		SomeClass clazz = new SomeClass();
		test.print(clazz.value);
		System.out.println(clazz.value);
		
		test.print(clazz);
		System.out.println(clazz.value);
		
		AbsClass<Integer> c1 = new AbsClass<Integer>(){
			@Override
			Integer createObject() {
				return new Integer(100);
			}
		};
		
		System.out.println(c1.createObject());
		
	}
	
	public void print(SomeClass e){
		e.value = "changed";
	}
	
	public void print(Object e){
		
	}

	public void print(String e){
		e = "Hello there";
	}

	
}


class SomeClass{
	int a = 10;
	String value = "Shailendra";
	
	public void showValue(){
		System.out.println(value+" a: "+a);
	}
}

abstract class AbsClass<T>{
	public AbsClass(){
		System.out.println("constructor of AbsClass");
	}	
	
	abstract T createObject();
}