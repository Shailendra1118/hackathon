package com.march.prac.one;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<E> {
	
	private Node<E> first = null;
	private Node<E> last = null;
	int count = 0;
	public Deque() {
		// construct an empty deque
		first = last;
	}

	public boolean isEmpty() {
		// is the deque empty?
		return size() == 0;
	}

	public int size() {
		// return the number of items on the deque
		return count;
	}

	public void addFirst(E item) {
		// add the item to the front
		if(item == null)
			throw new NullPointerException("item to be added is null.");
		Node<E> node = null;
		if(first == null){ // isEmpty() could be used here !!
			//first node to be added
			node = new Node<>(first, item, last);
			first = node;
			last = first;
		}else{
			node = new Node<>(null, item, first);
			first.prev = node;
			first = node;
		}
		count++;
	}

	public void addLast(E item) {
		// add the item to the end
		if(item == null)
			throw new NullPointerException("item to be added is null.");
		Node<E> node = null;
		if(last == null){
			//first node to be added at last position
			node = new Node<>(first, item, last);
			last = node;
			first = last; // order of this is important
		}else{
			node = new Node<>(last, item, null);
			last.next = node;
			last = node;
		}		
		count++;
	}

	public E removeFirst() {
		// remove and return the item from the front
		if(count == 0)
			throw new NoSuchElementException("Trying to remove from empty Deque.");
		
		E item = first.item;
		first = first.next;
		if(first == null) //it was the last item, if count == 1 could be used
			last = null;
		if(first != null)
			first.prev = null;
		count--;
		return item;
	}

	public E removeLast() {
		// remove and return the item from the end
		if(count == 0)
			throw new NoSuchElementException("Trying to remove from empty Deque.");
		
		E item = last.item;
		last = last.prev;
		if(last == null) //it was the last item
			first = null;
		if(last != null)
			last.next = null;
		count--;
		return item;
	}

	public Iterator<E> iterator() {
		return new XIterator();
		// return an iterator over items in order from front to end		
	}
	

	public static void main(String[] args) {
		Deque<Integer> d = new Deque<>();
		d.addFirst(1);
		d.addFirst(2);
		d.addFirst(3);
		System.out.println("removed "+d.removeFirst());
		System.out.println("removed "+d.removeFirst());
		System.out.println("removed "+d.removeFirst());
		//System.out.println("removed "+d.removeFirst());
		
		d.addFirst(10);
		System.out.println("remove "+d.removeLast());
		
		d.addLast(20);
		System.out.println("remove "+d.removeLast());
		
		d.addLast(30);
		System.out.println("remove "+d.removeLast());
		
		d.addLast(40);
		d.addLast(50);
		d.addLast(60);
		d.addLast(70);
		Iterator<Integer> iter = d.iterator();
		while(iter.hasNext()){
			System.out.println("Iter: "+iter.next());
		}
		
		
	}
	
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
	
	private class XIterator implements Iterator<E>{
		private Node<E> curr = (Node<E>) first;
		@Override
		public boolean hasNext() {
			if(curr == null)
				return false;
			return true;
			// return curr != null; could be used
		}

		@Override
		public E next() {
			if(count == 0) // call to hasNext() would be handy
				throw new NoSuchElementException("next() is not allowed on empty Deque.");
			E item = curr.item;
			curr = curr.next;
			return item;
			
		}
		
		public void remove(){
			throw new UnsupportedOperationException("remove() is not implemented yet.");
		}
		
	}

}
