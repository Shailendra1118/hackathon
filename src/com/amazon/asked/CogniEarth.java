package com.amazon.asked;

import java.util.ArrayList;

public class CogniEarth {

	public static void main(String[] args) {
		
		int arr[] = {4,5,6,7,8,3,4,5,6,7,8};
		int a = arr[0];
		for (int i = 1; i < arr.length; i++) {
			//System.out.println(Integer.toBinaryString(a));
			//System.out.println(Integer.toBinaryString(arr[i]));
			a = a^arr[i];
			//System.out.println(a);
			//System.out.println(Integer.toBinaryString(a)+"-");
		}
		
		System.out.println("Last "+a);
		
		int b = 12;
		System.out.println(b^1);
		
		ArrayList<Integer> list = new ArrayList<>(); //default capacity is 10 only after first add
		list.add(1);
		list.add(11);
		list.add(122);
		list.remove(new Integer(11));
		System.out.println(list);
		
		
		int x = 0;
		int y = 1;
		int z = x++;
		int p = ++y;
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(p);
		
		
	}

}

