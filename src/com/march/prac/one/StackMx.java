package com.march.prac.one;

import java.util.EmptyStackException;

public class StackMx {

	public static void main(String[] args) {
		StackMax<Integer> s = new StackMax<Integer>();
		s.push(5);
		System.out.println("max: "+s.max());
		s.push(3);	
		System.out.println("max: "+s.max());
		s.push(8);
		System.out.println("max: "+s.max());	
		s.push(1);
		System.out.println("max: "+s.max());
		s.push(4);
		System.out.println("max: "+s.max());
		s.push(9);
		System.out.println("max: "+s.max());
		s.push(6);
		System.out.println("max: "+s.max());
		
		
		
		while(! s.isEmpty()){
			System.out.println("remaing: "+s.pop());
			System.out.println("max now: "+s.max());
		}
	}
	
	private static class StackMax<T extends Comparable<T>>{
		Object [] elements = new Object[1];
		Object [] maxElements = new Object[1];
		private int ptr = 0;
		private int maxPtr = 0;
		
		@SuppressWarnings("unchecked")
		public void push(T item){
			elements[ptr++] = item;
			elements = resize(ptr, elements);
			
			if(maxPtr == 0){
				maxElements[maxPtr++] = item;
				maxElements = resize(maxPtr, maxElements);
			}else{
				T last = (T) maxElements[maxPtr-1];
				if(last.compareTo(item) < 0){
					maxElements[maxPtr++] = item;
					maxElements = resize(maxPtr, maxElements);
				}
			}			
		}
		
		@SuppressWarnings("unchecked")
		public T pop(){			
			if(ptr-1 < 0 || maxPtr-1 < 0)
				throw new EmptyStackException();
			ptr--;
			if(elements[ptr] == maxElements[maxPtr-1]){
				maxPtr--;
			}
			return (T)elements[ptr];
		}
		
		public boolean isEmpty(){
			return ptr-1 < 0;
		}
		
		@SuppressWarnings("unchecked")
		public T max(){
			if(maxPtr-1 < 0)
				throw new EmptyStackException();
			return (T)maxElements[maxPtr-1];			
		}
		
		private Object[] resize(int ptr, Object [] ele){
			if(ptr == ele.length){
				Object [] nArray = new Object[ele.length*2];
				System.arraycopy(ele, 0, nArray, 0, ele.length);
				//System.out.println("new Array: "+Arrays.toString(nArray));
				for(Object o : ele){
					o = null;
				}
				ele = nArray;
			}
			return ele;
		}
		
		
	}
	
	

}
