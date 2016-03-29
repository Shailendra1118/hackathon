package com.booking.ques;

public class NiceObjects {
	String value;
	public NiceObjects(String input){
		this.value = input;
	}
	public static void main(String args[]){
		NiceObjects n1 = new NiceObjects("First Object");
		NiceObjects n2 = n1;
		callAnother(n2);
		System.out.println(n2.value);
	}

	private static void callAnother(NiceObjects n2) {
		//n2 = new NiceObjects("Second Object");	
		n2.value = "changed";
		System.out.println(n2.value);
	}
}


