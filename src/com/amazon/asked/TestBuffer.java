package com.amazon.asked;

public class TestBuffer {

	public static void main(String[] args) {

		final StringBuffer buffer = new StringBuffer("Something fishy");
		buffer.append(" Hello There");
		buffer.append(" Nope");
		
		String str = new String("Helloooo");
		str = "nope from here";
		
		System.out.println(str);
	}

}
