package com.practice.april.core;

public class SecLargSmall {

	public static void main(String[] args) {
		int arr[] = {12,13,1,10,34,1};
		
		int f=arr[0], s=arr[0];
		for(int i=0; i<arr.length; i++){
			int cur = arr[i];
			if(cur > f){
				s = f;
				f = cur;
			}else if(cur > s)
				s = cur;			
		}
		
		System.out.println("max: "+f+" sec:"+s);
	}

}
