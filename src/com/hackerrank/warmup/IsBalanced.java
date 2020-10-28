/**
 * 
 */
package com.hackerrank.warmup;

/**
 * @author Shailendra
 *
 */
public class IsBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		if (checkBalanced(root) == -999)
			System.out.println("Not Balanced");
		else
			System.out.println("Balanced");
	}

	/**
	 * calculate height and checking balance in the same method
	 * 
	 * @param node
	 * 
	 */
	private static int checkBalanced(Node node) {
		if (node == null) {
			return 0;
		}

		int lh = checkBalanced(node.left);
		if (lh == -999)
			return lh;
		int rh = checkBalanced(node.right);
		if (rh == -999)
			return rh;

		if (Math.abs(lh - rh) > 1)
			return -999;

		return 1 + Math.max(lh, rh);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}
