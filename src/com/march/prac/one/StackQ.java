package com.march.prac.one;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackQ {

	public static void main(String[] args) {
		AQueue<Integer> q = new AQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		System.out.println("out "+q.dequeue());
		q.enqueue(3);
		System.out.println("out "+q.dequeue());
		System.out.println("out "+q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		System.out.println("out "+q.dequeue());
		System.out.println("out "+q.dequeue());
		System.out.println("out "+q.dequeue());
		
		System.out.println("remaining items...");
		while(! q.isEmpty()){
			System.out.println(q.dequeue());
		}
		
	}
	

	private static class AQueue<T>{		
		Stack<T> s1 = new Stack<T>();
		Stack<T> s2 = new Stack<T>();
		
		public void enqueue(T item){
			s1.push(item);
		}
		public T dequeue(){
			if(s2.isEmpty()){
				while(! s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			if(s2.isEmpty())
				throw new EmptyStackException();
			return s2.pop();			
		}
		
		public boolean isEmpty(){
			if(s2.isEmpty() && s1.isEmpty())
				return true;
			else
				return false;
		}
	}

}
