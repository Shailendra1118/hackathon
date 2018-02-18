package com.practice.threads;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestException {

	public static void main(String[] args) throws IOException, InterruptedException {
		Parent p = new Child();
		p.display();

	}
	
	

}


class Child extends Parent{
	
	public void display() throws InterruptedException, FileNotFoundException{
		System.out.println("child");
	}
	
}


class Parent {
	
	void display() throws IOException, InterruptedException{
		System.out.println("parent");
	}
}