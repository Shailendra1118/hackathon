package com.hackerrank.warmup;

import java.util.Stack;

public class NGE {

	public static void main(String[] args) {
		int [] array = {4, 15, 2, 9, 20, 11, 13};
		Stack<Integer> stack = new Stack<Integer>();
		int current = 0;
		
		for(int i=0; i< array.length; i++){
			current = array[i];
			//if(stack.isEmpty())
			//	stack.push(current);
			
			if(!stack.isEmpty() && current > stack.peek()){
				System.out.println(stack.pop()+"->"+current);
				stack.push(current);
			}else
				stack.push(current);
		}
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+"-> -1");
		}
		
		
	}

}
