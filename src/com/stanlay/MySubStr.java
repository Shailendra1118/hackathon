package com.stanlay;

import java.util.HashMap;
import java.util.HashSet;


public class MySubStr {

	public static void main(String[] args) {
		String str = "GEEKSFORGEEKS";
		findMaxN(str);
	}

	private static void findMaxN(String str) {
		System.out.print("Hello");
		HashMap<Character,Integer> set = new HashMap<>();
		int mxNow = 0;
		int curr = 0;
		int pos = 0;
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			//pos = i;
			if(!set.containsKey(c)){
				set.put(c, i);
				curr++;
			}else{
				set.clear();
			}
		}
	}

}
