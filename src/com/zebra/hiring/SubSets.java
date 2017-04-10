package com.zebra.hiring;

public class SubSets {

	public static void main(String[] args) {
		String str = "abcd";
		subSets("", str);
		
	}

	private static void subSets(String soFar, String rest) {
		if(rest.length() == 0)
			System.out.print(soFar+" ");
		else{
			subSets(soFar + rest.charAt(0), rest.substring(1));
			subSets(soFar, rest.substring(1));
		}
	}

}
