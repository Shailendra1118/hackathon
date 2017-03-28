package com.march.prac.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class RandomizedQueue<E> implements Iterable<E> {
	// array based queue so you can fill the holes by last item
	// iterator needs a copy of queue elements to iterate in a random order
	E items[] = null;
	int size = -1;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		// construct an empty randomized queue
		items = (E[]) new Object[1];
	}
	
	public boolean isEmpty() {
		// is the queue empty?
		return size() < 0;
	}
	
	public int size() {
		// return the number of items on the queue
		return size;
	}
	
	public void enqueue(E item) {
		// add the item
		items[++size] = item;
		if(items.length <= size+1){
			resize(items.length*2);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int n) {
		E temp[] = (E[]) new Object[n];
		for (int i = 0; i < items.length; i++) {
			temp[i] = items[i];
		}
		items = temp;
	}
	
	public E dequeue() {
		// remove and return a random item
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		Random rand = new Random();
		int nxt = rand.nextInt(size+1);
		E e = (E) items[nxt];
		items[nxt] = items[size];
		if(size >= 0)
			items[size] = null;
		size--;
		// reduction of array
		if(size+1 <= items.length/4){
			resize(items.length/2);
		}
		return e;
	}
	
	private void display() {
		System.out.println("----");
		for (int i = 0; i < items.length; i++) {
			System.out.print(items[i]+" ");
		}
		System.out.println("----");
	}

	public E sample() {
		// return (but do not remove) a random item
		return null;
	}
	
	public Iterator<E> iterator() {
		// return an independent iterator over items in random order
		return new RandomizedQueueIterator();
	}
	
	private class RandomizedQueueIterator implements Iterator<E> {
        private int i = 0;
        private E[] temp;
 
        @SuppressWarnings("unchecked")
		public RandomizedQueueIterator() {
            temp = (E[]) new Object[size]; 
            for (int j = 0; j < size; j++) {
                temp[j] = items[j];
            }
        }
 
        public boolean hasNext() { 
            return i < size; 
        }
 
        public E next() {
            if (!hasNext()) { 
                throw new NoSuchElementException(); 
            }
            int k = (int) (Math.random()*(size-i));
            E item = temp[k];
            temp[k] = temp[size-(++i)];
            temp[size-i] = null;
            return item;
        }
             
        public void remove() { 
            throw new UnsupportedOperationException();
        }
    }
	   
	
	public static void main(String args[]) throws FileNotFoundException{
	/*	int k = 3;
		for (int i = 1; i < 10; i++) {
			System.out.println("i: "+i);
			System.out.println("Rand "+Math.random());
			System.out.println("Prob "+(double)k/i);
			System.out.println("---");
		} */
		
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		/*rq.enqueue("A");
		rq.enqueue("B");
		rq.enqueue("C");
		rq.enqueue("D");
		System.out.println("Dequeue: "+rq.dequeue());
		System.out.println("Dequeue: "+rq.dequeue());
		System.out.println("Dequeue: "+rq.dequeue());
		System.out.println("Dequeue: "+rq.dequeue());
		*/
		
		Scanner s = new Scanner(new File("D:/Keppler/Hackerrank/src/com/march/prac/one/input.txt"));
		// Reservoir sampling
        int k = 8; //Integer.parseInt(args[0]);
        int i = 0;
        while(s.hasNext()){
        	String str = s.next();
        	if (i <= k) {
                rq.enqueue(str);
            } else if (Math.random() < (double) k/i) {
                rq.dequeue();
                rq.enqueue(str);
            }
        	i++;
        	//Iterator<String> iter = rq.iterator();
        	//while(iter.hasNext())
        	//	System.out.print(iter.next()+" ");
        	//System.out.println();
        }
        Iterator<String> iter = rq.iterator();
        while(iter.hasNext())
    		System.out.print(iter.next()+" ");
        
        s.close();
	}
}
