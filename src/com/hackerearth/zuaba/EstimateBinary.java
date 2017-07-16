package com.hackerearth.zuaba;

public class EstimateBinary {

	public static void main(String[] args) {
		int arr[] = {2,5,6,8,12,15,18,22};
		boolean hasTwo = hasValue(arr,19, 0, 1);
		System.out.println("hasTwo: "+hasTwo);

	}

	private static boolean hasValue(int[] arr, int search, int start, int end) {
		int mid = (start+end)/2;
		System.out.print("Mid: "+mid);
		try{
			int val = arr[mid];
			System.out.println(" Val: "+val);
			// binary search going on
			if(val == search)
				return true;
			else if(end <= start)
				return false;
			else if(val > search){
				return hasValue(arr, search, start, mid-1);
			}
			else{
				return hasValue(arr, search, mid+1, end*2);
			}
		}catch(Exception e){
			System.out.println(" Exeption..."+e.getMessage());
			return hasValue(arr, search, start, mid-1);
			
		}
		
	}

}
