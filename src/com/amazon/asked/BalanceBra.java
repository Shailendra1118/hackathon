package com.amazon.asked;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalanceBra {

	static int count = 0;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		String str = "((()))";
		//findCount(str, "");
		set.forEach(s -> System.out.print(s));
		printBalanced(0, 0, "", str.length()/2);
	}

	private static void printBalanced(int openc, int closec, String str, int len) {
		if(openc == len && closec == len){ 
			System.out.println(str);
			return;
		}
		
		if(openc < len){
			printBalanced(openc+1, closec, str+"(", len);
		}
		if(closec < openc){
			printBalanced(openc, closec+1, str+")", len);
		}
		
	}

	private static void findCount(String remaining, String soFar) {
		if(remaining.length() == 0){
			System.out.println("Rem: "+soFar);
			isBalance(soFar);
			return;
		}
		
		else{
			for (int i = 0; i < remaining.length(); i++) {
				String next = soFar + remaining.charAt(i);
				String rest = remaining.substring(0, i) + remaining.substring(i+1);
				findCount(rest, next);
			}
			
		}
	}

	private static boolean isBalance(String soFar) {
		Stack<Character> stk = new Stack<>();
		char[] arr = soFar.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == '('){
				stk.push(arr[i]);
			}
			else{
				stk.pop();
			}
		}
		if(stk.isEmpty()){
			set.add(soFar);
			return true;
		}
		else
			return false;
	}

}
