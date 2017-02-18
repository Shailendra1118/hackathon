package com.practice.april.core;

public class FindRepeated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,2,4,5,5,3,1};
		int res = arr[0];
		for(int i=1; i<arr.length; i++){
			res = res ^ arr[i];
		}
		System.out.println(res);
		//int x = 7;
		for(int i=1; i<=5;i++){
			res = res ^ i;
		}
		System.out.println(res);
		//int y = 7^6;
		//System.out.println("7^6 "+y);
		System.out.println(Integer.toBinaryString(res));
		
		int a = 4;
		int b = 4;
		int c = a ^ b;
		//System.out.println(c);

	}

}
