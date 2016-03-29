package com.funds.karumanchi;

public class TreeUtil {

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		System.out.println(isBST(root, -999, 999));
		
		
	}

	private static boolean isBST(Node node, int min, int max) {
		if(node == null)
			return true;
		
		if(node.data > min && node.data < max
			&& isBST(node.left, min, node.data)
			&& isBST(node.right, node.data, max))
			return true;
		else
			return false;
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
