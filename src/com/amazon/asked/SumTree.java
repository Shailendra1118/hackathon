package com.amazon.asked;

import com.amazon.asked.Sibling.Node;

public class SumTree {

	public static void main(String[] args) {
		Node n6 = new Node(7);
		Node n4 = new Node(8);
		Node n5 = new Node(-4);
		Node n2 = new Node(-2, n4, n5, null);
		Node n7 = new Node(5);
		Node n3 = new Node(6, n6, n7, null);
		Node n1 = new Node(10, n2, n3, null);
		
		printTree(n1);
		sumTree(n1);
		System.out.println("After sum: ");
		printTreeInorder(n1);
	}

	private static int sumTree(Node node) {
		if(node == null)
			return 0;
		
		/*Store the old value
        int old_val = node.data;
  
        // Recursively call for left and right subtrees and store the sum
        // as new value of this node
        node.data = toSumTree(node.left) + toSumTree(node.right);
  
        // Return the sum of values of nodes in left and right subtrees
        // and old_value of this node
        return node.data + old_val;
		 */
		int l = sumTree(node.left);
		int r = sumTree(node.right);
		int temp = node.data;
		node.data = (l+r);
		return node.data+temp;
		
	}

	private static void printTree(Node n1) {
		if(n1 == null)
			return;
		System.out.print(n1.data+" ");
		printTree(n1.left);
		printTree(n1.right);
	}
	private static void printTreeInorder(Node n1) {
		if(n1 == null)
			return;
		
		printTree(n1.left);
		System.out.print(n1.data+" ");
		printTree(n1.right);
	}
}
