package com.stanlay;

public class NxtMax {
	public static void main(String[] args) {
		int num = 4765;
		int arr[] = new int[4];
		int i = 0;
		//System.out.println("d");
		while(num % 10 > 0){
			//System.out.println("%"+num%10);
			arr[i] = num%10;
			//System.out.print(arr[i]+" ");
			i++;
			num = num/10;
			
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
		System.out.println();
		
		for (int j = 0; j < arr.length; j++) {
			//int cur = arr[j];
			if(j+1 < arr.length){
				if(arr[j] > arr[j+1]){
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
		System.out.println();
		for (int j = arr.length-1; j >=0; j--) {
			System.out.print(arr[j]+" ");
		}
	}

}
