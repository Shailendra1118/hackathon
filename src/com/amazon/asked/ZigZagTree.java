package com.amazon.asked;

import java.util.Stack;


public class ZigZagTree {

	public static void main(String[] args) {
		//print spiral tree using two stacks
		
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		six.right = eight;
		seven.right = nine;
		
		printzz(one);

	}
	
	private static void printzz(Node node) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.push(node);
		
		while (!(s1.isEmpty() && s2.isEmpty())) {
			while (!s1.isEmpty()) {
				Node cur = s1.pop();
				System.out.println(cur.data);
				if (cur.left != null)
					s2.push(cur.left);
				if (cur.right != null)
					s2.push(cur.right);
			}

			while (!s2.isEmpty()) {
				Node cur = s2.pop();
				System.out.println(cur.data);
				if (cur.right != null)
					s1.push(cur.right);
				if (cur.left != null)
					s1.push(cur.left);
			}
		}
		
	}

	static class Node{
		int data;
		Node left, right;
		
		public Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(int data){
			this.data = data;
		}
	}

}
