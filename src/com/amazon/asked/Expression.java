package com.amazon.asked;

public class Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "5 + 20 / 2 * 6 + 2 - 1";
		
		for (int i = 0; i < exp.length(); i++) {
			char curr = exp.charAt(i);
			if(curr != 32)
			System.out.println((int)curr);
			//Integer a = Integer.valueOf(curr);
			//System.out.println(a);
		}
	}

}
