package com.practice.april.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ITestable implements ITest {

	public static void main(String[] args) {
		
		List list = new ArrayList();
		list.add(2);
		list.add(5);
		list.add(6);
		list.add(7);
		System.out.println(list);
		list.remove(2);
		list.remove(new Integer(7));
		System.out.println(list);
		HashSet map = new HashSet();
		map.add(5);
		map.add(6);
		map.add(9);
		
		System.out.println(map);
		
		//ITest.i = 100;
		int arr[] = new int[26];
		//char a = 'a';
		//arr[a-a] = 100;
		//arr[a-'a'] = 200;
		//System.out.println(arr[0]);
		String str = "myfoxygirlfriendisnotsofoxy";
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			//System.out.println("char "+c);
			if(arr[c-'a'] != 0){
				System.out.println("First repeated char is: "+c+" "+(int)c);
				break;
			}
			arr[c-'a'] = c;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	protected void calc(){
		System.out.println("in Itestable class.");
	}

}

class ChildITest extends ITestable{
	protected void calc(){
		System.out.println("In childItest");
	}
}
