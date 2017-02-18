package com.amazon.asked;

public class DeleteNode {

	static class Node{
		int data;
		Node next;
		Node(int data, Node node){
			this.data = data;
			this.next = node;
		}
	}
	public static void main(String[] args) {
		Node ne = new Node(1, null);
		Node nd = new Node(2, ne);		
		Node nc = new Node(2, nd);
		Node nb = new Node(1, nc);
		Node na = new Node(2, nb);
		printNodes(na);
		Node ptr1 = na;
		Node ptr2 = ptr1;
		Node prev = ptr1;
		while(ptr1 != null){
			ptr2 = ptr1.next;
			prev = ptr1;
			while(ptr2 != null){
				if(ptr1.data == ptr2.data){	
					prev.next = ptr2.next;
					ptr2.next = null;
					ptr2 = prev.next;
					
				}else{
					prev = ptr2;
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
		printNodes(na);
	}
	private static void printNodes(Node na) {
		System.out.println();
		while(na != null){
			System.out.print(na.data+"->");
			na = na.next;
		}
		System.out.print("null");
	}

}
