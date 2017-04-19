package com.amazon.asked;

import java.util.LinkedList;
import java.util.Queue;

public class Sibling {

	public static void main(String[] args) {
		Node n8 = new Node(8);
		Node n4 = new Node(4, n8, null, null);
		Node n5 = new Node(5);
		Node n2 = new Node(2, n4, n5, null);
		Node n7 = new Node(7);
		Node n3 = new Node(3, null, n7, null);
		Node n1 = new Node(1, n2, n3, null);
		n2.parent = n1;
		n3.parent = n1;		
		n8.parent = n4;
		n4.parent = n2;
		n5.parent = n2;
		n7.parent = n3;
		int height = calHeight(n1, 0);
		System.out.println("Height "+height);
		
		linkSibling(n1);
		System.out.println(n4.next.data);
		System.out.println(n5.next.data);
	}
	
	
	private static void linkSibling(Node node) {
		Queue<QNode> q = new LinkedList<>();
		int level = 0;
		q.offer(new QNode(node, level));
		//level++;
		while(! q.isEmpty()){
			QNode qn = q.poll();
			if(q.peek() != null && q.peek().level == qn.level){
				qn.node.next = q.peek().node;
			}
			if(qn.node.left != null){
				q.offer(new QNode(qn.node.left, qn.level+1));
			}
			if(qn.node.right != null){
				q.offer(new QNode(qn.node.right, qn.level+1));
			}
			//level++;
		}
		
	}


	private static int calHeight(Node node, int h) {
		if(node == null)
			return 0;
		int l = calHeight(node.left, h+1);
		int r = calHeight(node.right, h+1);
		return Math.max(l, r)+1;
	}


	static class Node{
		public Node(int i, Node object, Node object2, Node object3) {
			this.data = i;
			left = object;
			right = object2;
			parent = object3;
		}
		public Node(Integer i){
			this.data = i;
		}
		public String toString(){
			return String.valueOf(data);
		}
		Integer data;
		Node left;
		Node right;
		Node next;
		Node parent;
	}
	
	static class QNode{
		Node node;
		int level;
		public QNode(Node node, int level){
			this.node = node;
			this.level = level;
		}
		public String toString(){
			return node+":"+level;
		}
	}

}
