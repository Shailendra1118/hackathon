package com.stanlay;

import java.util.Stack;

public class QueueIt {

	//Queue using stacks
	public static void main(String[] args) {
		MyQueue que = new MyQueue();
		System.out.println("pushing 1");
		que.push(1);
		System.out.println("pushing 2");
		que.push(2);
		System.out.println("poping "+que.pop());
		System.out.println("pushing 3");
		que.push(3);
		System.out.println("pushing 4");
		que.push(4);
		System.out.println("poping "+que.pop());
		System.out.println("poping "+que.pop());
		System.out.println("poping "+que.pop());
		System.out.println("poping "+que.pop());
		
		
		
	}

}

class MyQueue{
	int size = 0;
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	
	public void push(Integer item){
		s1.push(item);
	}
	public Integer pop(){
		//making pop expensive
		if(s1.empty() && s2.empty()){
			System.out.println("No items found.");
			return null;
		}
		if(!s2.isEmpty()){
			return s2.pop();
		}else{
			while(!s1.isEmpty()){
				s2.push(s1.pop());			
			}
			return s2.pop();
		}
		
	}
	
	public boolean isEmpty(){
		if(s1.isEmpty())
			return true;
		else
			return false;
	}
}
