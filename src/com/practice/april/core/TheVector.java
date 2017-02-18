package com.practice.april.core;



public class TheVector extends Thread{

	public static void main(String[] args) {
		TheVector t = new TheVector();
		t.run();
	}
	
	public void run(){
		System.out.println("Running...");
	}

}
