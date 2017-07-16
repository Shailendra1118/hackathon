package com.hackerearth.zuaba;

public class BitTest {

	public static void main(String[] args) {
		int i = 50;
		System.out.println(1 << 31);
		System.out.println(Math.pow(2.0, 31));
		//rightmost set bit
		
		int j = 10;
		System.out.println(j & ~(j-1));
		

	}

}
