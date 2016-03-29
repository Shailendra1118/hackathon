package com.booking.ques;

import java.util.ArrayList;
import java.util.Iterator;

public class ReturnClass {
	public static void main(String args[]){
		//System.out.println(faaltoo());
		String [] arr = new String[100];
		arr[0] = "String";
		//arr[1] = 19;
		//arr[2] = 34;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		ArrayList arr1 = new ArrayList();
		arr1.add(10);
		arr1.add("String");
		arr1.add(98L);
		arr1.add(50);
		Iterator iter = arr1.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	public static int faaltoo(){
		try{
			int a = 10;
			//return;
			throw new Exception("exe");
		}catch(Exception e){
			return 10;
		}finally{
			return 11;
		}
	}
	
	
	
}
