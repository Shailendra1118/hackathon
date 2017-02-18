package com.amazon.asked;

import java.util.Stack;

public class Histogram {

	public static void main(String[] args) {
		//TreeSet tree = new TreeSet();
		//tree.add(null);
		//tree.add("A");
		//System.out.println(tree);
		
		//int x, y = 10;
		//x = 10;
		//if(x == 10 && y/0 > 1){
		//	System.out.println("its never gonna make it");
		//}
		int arr[] = {6,2,5,4,5,1,6};
		
		Stack<Integer> stack = new Stack<>();
		int max = arr[0];
		stack.push(max);
		
		for(int i=1; i<arr.length; i++){
			int curr = arr[i];
			
			if(curr<stack.peek()){
				stack.push(curr);
			}
			
			int cmax = curr * (i+1);
			if(cmax > max)
				max = cmax;		
			
		}
		
		System.out.println("max: "+max);
	}

}
