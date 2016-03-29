package com.hackerrank.warmup;

public class ListAtleast {
	public static void main(String args[]){
		int [] arr1 = {2,4,5,7,8};
		int [] arr2 = {2,6,8,34,23};
		int [] res = new int[10];
		int upto = 0;
		//res[0] = arr1[0];
		for(int i=0; i<arr2.length; i++){			
			//if(i+1 < arr1.length)
				upto = upto^arr2[i]; 
			System.out.print(" "+upto);
		}
		
	}
}
