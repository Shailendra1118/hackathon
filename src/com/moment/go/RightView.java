package com.moment.go;

import java.util.LinkedList;
import java.util.Queue;



public class RightView {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		Node dest1 = new Node(4);
		root.left.left = dest1;
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node dest = new Node(10);
		root.left.right.left = dest;
		root.right.left.right = new Node(11);
		root.right.left.right.right = new Node(12);
		printLevel(root);
		System.out.println("right view : ");
		printNewline(root);
		
	}

	private static void printNewline(Node root) {
		int count = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(! q.isEmpty()){
			count = q.size();
			if(count == 0){
				break;
			}
			Node t = null;
			while(count > 0){
				t = q.poll();
				//System.out.print(t.data);
				if(t.left != null)
					q.add(t.left);
				if(t.right != null)
					q.add(t.right);
				count--;
			}
			System.out.print(t.data+" ");
			//System.out.println();
			
		}
		
	}

	private static void printLevel(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(! q.isEmpty()){
			Node temp = q.poll();
			System.out.print(temp.data+" ");
			
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}

}

class Node{
	int data = 0;
	Node right = null;
	Node left = null;
	
	Node(int data){
		this.data = data;
	}
}
