package com.applied;

import java.util.Arrays;

public class StringJuble {

	public static void main(String[] args) {
		String str = "daayv";
		process(str);

	}

	private static void process(String str) {
		
		char arr[] = str.toCharArray();
		int len = arr.length;
		boolean even = false;
		if(len%2 == 0)
			even = true;
		
		//int idx = len-1;
		int i = (len)/2;
		while(i < len-1){
			if(!even){
				char temp = arr[i];
				arr[i] = arr[0];
				arr[0] = temp;				
			}else{
				char temp = arr[i-1];
				arr[i-1] = arr[0];
				arr[0] = temp;		
			}
			i++;
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println(new String(arr));
	}

}
