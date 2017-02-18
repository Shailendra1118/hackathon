package com.sapient.ques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RandomTests {
	static int H = 0;
	static int B = 0;
	static boolean flag = true;
	static{		
		    File file = new File("D:\\Keppler\\Hackerrank\\src\\com\\sapient\\ques\\test.txt");
		    Scanner scan = null;
		    ArrayList<Integer> list = null;
			try {
				scan = new Scanner(file);
				list = new ArrayList<Integer>();
				    while(scan.hasNext()){
				        String h = scan.next();
				        Integer value = Integer.valueOf(h);
				        if(value <= 0){
				           System.out.println("java.lang.Exception: Breadth and height must be positive");
				            flag = false;
				            break;
				        }
				        else
				            list.add(value);            
				    }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}			
		   
		    
		   if(flag){
		    H = list.get(0);
		    B = list.get(1);
		   }
	}
	
	public static void main(String[] args) {
		long num = -9223372036854775808l;
		
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		Stack<Character> stack = new Stack<>();
		stack.clear();
		 HashSet<Character> open = new HashSet<>();
	      open.add('(');
	      open.add('{');
	      open.add('[');
	      String input = "{}(";
	      char [] curr = input.toCharArray();   
	      System.out.println(open.contains(curr[1]));
	}
}
