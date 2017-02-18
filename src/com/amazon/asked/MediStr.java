package com.amazon.asked;

import java.util.HashSet;
import java.util.Set;

public class MediStr {

	public static void main(String[] args) {
		String str = "Hello World!";
		String[] arr = str.split(" ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		String rev = reverse(arr[1]);
		System.out.println(rev);
		
		System.out.println("isUnique: "+isUniqueChar("ABCAE"));
		isUnique("aba");
		
	}

	private static boolean isUniqueChar(String str) {
		if(str.length() == 0)
			return true;
		boolean flag = true;
		Set<Character> set = new HashSet<>();
		char arr[] = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			Character c = arr[i];
			if(set.contains(c)){
					flag = false;
					break;
			}else{
				set.add(c);
			}
		}
		
		return flag;
	}

	private static void isUnique(String s) {
		boolean flag = true;
		int arr[] = new int[30];
		char[] ip = s.toCharArray();
		int prev = 0;
		for (int i = 0; i < ip.length; i++) {
			int c = ip[i];
			System.out.println(c-'a');
			
			
		}
		System.out.println("prev "+prev);
		System.out.println("flag "+flag);
		//System.out.println(Arrays.toString(arr));
		
	}

	private static String reverse(String s) {
		int i = 0;
		int j = s.length()-1;
		char arr[] = s.toCharArray();
		while(i<j){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		//System.out.println(arr);
		
		return new String(arr);
	}

}
