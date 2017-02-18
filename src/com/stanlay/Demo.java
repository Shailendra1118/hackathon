package com.stanlay;

public class Demo {
	
	public static void main(){
		Timepass p = new Timepass();
		takeIt(p);
	}
	
	static void takeIt(Timepass p){
		p = null;
		p = new Timepass();
	}
	
	
}

class Timepass{
	
}