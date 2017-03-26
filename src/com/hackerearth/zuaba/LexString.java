package com.hackerearth.zuaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LexString {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>(9);
		list.add("fuNny");
		list.add("funny");		
		list.add("fun");
		list.add("All");
		list.add("hall");
		list.add("Call");
		list.add("5");
		list.add("ball");
		list.add("Hello World ");
		list.add("hello world");
		
		String pStr = ".*http://.*";
		/*
		Pattern pattern = Pattern.compile(pStr);
		Matcher matcher = pattern.matcher("https://mybodyissexy.com");
	    boolean matches = matcher.matches();
		if(matches)
			System.out.println("matches");
		else
			System.out.println("dones match");
		*/
		if(! isInteger("ssdf"))
		Collections.sort(list, new LexComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}		
	
	}
	
	static class LexComparator implements Comparator<String>{
		@Override
		public int compare(String s1, String s2) {
			if(s1.equalsIgnoreCase(s2)){
				for(int i=0; i<s1.length(); i++){
					char c1 = s1.charAt(i);
					char c2 = s2.charAt(i);
					if(c1 < c2){
						return 1;
					}else if(c1 > c2)
						return -1;
				}
			}
			return 0;			
		}		
	}
	
	private static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	        } catch(NumberFormatException e) { 
	            return false; 
	        } catch(NullPointerException e) {
	            return false;
	        }
	        // only got here if we didn't return false
	        return true;
	    }

}
