package com.funds.karumanchi;

public class HeapIt {

	static int heap[] = new int[20];
	static int len = 1;
	public static void main(String[] args) {
		int arr[] = {6, 4, 5, 3, 2, 0, 1};
		buildheap(arr); //min heap
		
		printHeap();
		
		
		
	}

	private static void buildheap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];
			insert(curr);
			
			printHeap();
		}
	}

	private static void insert(int curr) {
		//int root = heap[1];		
		heap[len] = curr;
		System.out.println("Root : "+heap[1]);
		heapifyUp(len);
		len++;
	}

	private static void heapifyUp(int idx) {
		if(idx == 1)
			return;
		else{
		//for (int i = len; i > 0; i++) {
			int p = idx/2;
			if(heap[idx] > heap[p]){
				int temp = heap[p];
				heap[p] = heap[idx];
				heap[idx] = temp;
			}
			idx--;
			heapifyUp(idx);
		}
			
		//}
	}
	
	private static int remove(){
		len--;
		int minmax = heap[1];
		heapifyDown();
		return minmax;
	}

	private static void heapifyDown() {
		
	}
	
	private static void printHeap(){
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}

}
