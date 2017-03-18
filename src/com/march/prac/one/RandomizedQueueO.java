package com.march.prac.one;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

public class RandomizedQueueO<E> implements Iterable<E> {
	// Deque will be used here as a queue only
	// with addLast() and removeFirst methods
	private Deque<E> deq = null;

	public RandomizedQueueO() {
		// construct an empty randomized queue
		deq = new Deque<>();
	}

	public boolean isEmpty() {
		// is the queue empty?
		return deq.isEmpty();
	}

	public int size() {
		// return the number of items on the queue
		return deq.size();
	}

	public void enqueue(E item) {
		// add the item
		deq.addLast(item);
	}

	// bad design, to much work to do, not efficient
	public E dequeue() {
		// remove and return a random item	
		if(this.isEmpty()){
			throw new NoSuchElementException("Queue is empty."); 
		}
		Random r = new Random();
		int nxt = r.nextInt(deq.size());
		Stack<E> stk = new Stack<>();
		for (int i = 0; i <= nxt; i++) {
			stk.push(deq.removeFirst());
		}
		E item = stk.pop();
		while (!stk.isEmpty()) {
			deq.addLast(stk.pop());
		}
		return item;
	}

	public E sample() {
		// return (but do not remove) a random item
		Random r = new Random();
		int nxt = r.nextInt(deq.size());
		Stack<E> stk = new Stack<>();
		for (int i = 0; i < nxt; i++) {
			stk.push(deq.removeFirst());
		}
		E item = stk.peek();
		while (!stk.isEmpty()) {
			deq.addLast(stk.pop());
		}
		return item;
	}
	
	public Iterator<E> iterator() {
		// return an independent iterator over items in random order
		return new XIterator();
	}
	
	private class XIterator implements Iterator<E>{
		private Random r = new Random();
		private int nxt = r.nextInt(deq.size());		
		private Deque<E> temp = new Deque<>();
		private Iterator<E> iter = null;
		
		//problem here. can return same number again and again
		private XIterator() {			
			Stack<E> stk = new Stack<>();
			while(temp.size() < deq.size()){
				nxt = r.nextInt(deq.size());
				//System.out.println("deqSize: " + deq.size() + " next: " + nxt);
				for (int j = 0; j <= nxt && j < deq.size(); j++) {
					stk.push((E) deq.removeFirst());
				}
				E item = stk.peek();
				temp.addLast(item);
				while (!stk.isEmpty()) {
					deq.addLast((E) stk.pop());
				}				
			}
			// to debug
			System.out.println("In tempDeque -");
			iter = temp.iterator();
			while (iter.hasNext()) {
				System.out.println(iter.next());
			}
		}
		
		
		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		@Override
		public E next() {
			return iter.next();
			
		}
		
		public void remove(){
			throw new UnsupportedOperationException("remove() is not supported.");
		}
		
	}
	

	public static void main(String[] args) {
		// unit testing (optional)
		RandomizedQueueO<Integer> q = new RandomizedQueueO<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.println(": "+q.dequeue());
		//System.out.println(": "+q.dequeue());
		//System.out.println(": "+q.dequeue());
		//System.out.println(": "+q.dequeue());//System.out.println(": "+q.dequeue());
		//System.out.println("deq size now: "+q.size());
		Iterator<Integer> iter = q.iterator();
		while(iter.hasNext()){
			System.out.println("iter: "+iter.next());
		}
		
		
	}
}