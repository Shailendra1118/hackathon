package com.amazon.asked;

public class TestBST {

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(3);
		//root.right = new Node(7);
		root.left.left = new Node(1);
		//root.left.left.right = new Node(8);
		
		System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

	private static boolean isBST(Node root, int minValue, int maxValue) {
		
		if(root == null)
			return true;
		
		if(root.data < minValue || root.data > maxValue){
			return false;
		}
		return isBST(root.left, minValue, root.data) && isBST(root.right, root.data, maxValue);
	}

}
