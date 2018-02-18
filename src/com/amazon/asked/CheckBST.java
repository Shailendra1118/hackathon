package com.amazon.asked;

import java.util.LinkedList;


public class CheckBST {

	public static void main(String args[]){
		//iterative way
		Node root = new Node(6);
		root.left = new Node(3);
		//root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		
		System.out.println(isBST(root, -999, 999));
	}
	
	private static boolean isBST(Node node, int min, int max) {
		boolean isBST = true;
		LinkedList<BNode> queue = new LinkedList<BNode>();
		queue.add(new BNode(node, min, max));
		
		while(! queue.isEmpty()){
			BNode curr = queue.poll();
			if(curr.node.data < curr.leftValue || curr.node.data > curr.rightValue)
				return false;
			
			if(curr.node.left != null)
				queue.offer(new BNode(curr.node.left, curr.leftValue, curr.node.data));
			
			if(curr.node.right != null)
				queue.offer(new BNode(curr.node.right, curr.node.data, curr.rightValue));
			
		}
		return isBST;
	}

}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
	}
}

class BNode{
	Node node;
	int leftValue;
	int rightValue;
	
	BNode(Node node, int left, int right){
		this.node = node;
		this.leftValue = left;
		this.rightValue = right;
	}
}
