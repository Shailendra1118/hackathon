/**
 * 
 */
package com.bdd;

/**
 * @author Shailendra
 *
 */
public class Bst2dll {

	static TNode head = null;
	static TNode tail = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TNode root = new TNode(10);
		TNode fiv = new TNode(5);
		TNode fiftn = new TNode(15);
		TNode fr = new TNode(4);
		TNode eight = new TNode(8);
		TNode six = new TNode(6);
		TNode eighteen = new TNode(18);
		TNode twlv = new TNode(12);

		root.left = fiv;
		root.right = fiftn;

		fiv.left = fr;
		fiv.right = eight;

		fiftn.left = twlv;
		fiftn.right = eighteen;

		eight.left = six;

		convertToDll(root);
		TNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.right;
		}

	}

	/**
	 * @param root
	 * @param head
	 * @param tail
	 */
	private static void convertToDll(TNode node) {
		// recursive condition
		if (node == null) {
			return;
		}

		if (node.left != null) {
			convertToDll(node.left);
		}

		// like current node to previous/tail
		node.left = tail;

		// set head if tail is null OR set tail's right to current node
		if (tail != null) {
			tail.right = node;
		} else {
			head = node;
		}

		// update the tail
		tail = node;

		if (node.right != null) {
			convertToDll(node.right);
		}

	}

	static class TNode {
		int data;
		TNode left;
		TNode right;

		public TNode(int data) {
			this.data = data;
		}
	}

}
