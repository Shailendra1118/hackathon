package com.applied;

import java.util.Arrays;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "This is my world Sheldon!";
		
		String res = reverseIt(str);
		System.out.println(res);

	}

	private static String reverseIt(String str) {
		String[] arr = str.split(" ");
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr));
		int i = 0;
		int j = arr.length-1;
		while(i < j){
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < arr.length; k++) {
			sb.append(arr[k]+" ");
		}
		return sb.toString();
	}

}
