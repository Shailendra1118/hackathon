package com.booking.ques;

public class Nice {
	public static void main(String args[]){
		LowerAbs abs = new LowerAbs(10);
		abs.init();
		
		Abs obj = new LowerAbs(100);
		System.out.println(obj.add(1,3));
	}
}

abstract class Abs{
	public Abs(){
		System.out.println("In Abs contr");
		init();
	}
	
	public abstract void init();
	public int add(int a, int b){
		return (a+b);
	}
}

class LowerAbs extends Abs{
	private int value;
	public LowerAbs(int value){
		this.value = value;
	}
	@Override
	public void init() {
		System.out.println("in init method "+value);
	}
	
	public int sub(int a, int b){
		return (a-b);
	}
	
}