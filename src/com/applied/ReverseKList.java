package com.applied;

public class ReverseKList {

	public static void main(String[] args) {
		LNode n0 = new LNode(7, null);
		LNode n1 = new LNode(6, n0);
		LNode n2 = new LNode(5, n1);
		LNode n3 = new LNode(4, n2);
		LNode n4 = new LNode(3, n3);
		LNode n5 = new LNode(2, n4);
		LNode n6 = new LNode(1, n5);
		printIt(n6);
		LNode h = reverse(n6, 3);
		printIt(h);
	}
	
	
	private static void printIt(LNode head) {
		LNode cur = head;
		while(cur != null){
			System.out.print(cur.data+"->");
			cur = cur.next;
		}
		System.out.println("null");
	}


	private static LNode reverse(LNode head, int k) {
		LNode cur = head;
		LNode prev = null;
		LNode next = null;
		int count = 0;
		while(count < k && cur != null){		
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			count++;
		}
		
		if(next != null){
			head.next = reverse(next, k); //head points to old first element
		}
		
		return prev;
		
	}


	static class LNode{
		int data ;
		LNode next;
		public LNode(int data, LNode next){
			this.data = data;
			this.next = next;
		}
	}

}
