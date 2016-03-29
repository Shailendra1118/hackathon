package com.random.bits;

import java.util.Iterator;
import java.util.LinkedList;

public class Circle {

	public static void main(String[] args) {
		LinkedList<Integer> la = new LinkedList<Integer>();
		LinkedList<Integer> lb = new LinkedList<Integer>();
		la.add(1);
		la.add(3);
		la.add(4);
		la.add(2);
		
		Node curr = null;
		Node head = null;
		Node n1 = new Node(1, null);
		Node n2 = new Node(3, null);
		Node n3 = new Node(4, null);
		Node n4 = new Node(2, null);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		Node temp = null;
		head = curr = n1;
		while(curr != null){
			temp = curr.next.next;
			head = curr.next;
			
			
		}
	}
	

}


class Node{
	Integer digit;
	Node next;
	
	public Node(Integer d, Node next){
		this.digit = d;
		this.next = next;
	}
}
