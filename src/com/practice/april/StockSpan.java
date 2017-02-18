package com.practice.april;

public class StockSpan {
	
	public static void main(String[] args) {
		//int arr[] = {10, 4, 5, 90, 120, 80};
		int arr[] = { 68, 735, 101, 770, 525, 279, 559, 563, 465, 106, 146, 82, 28, 362, 492, 596, 743, 28, 637, 392, 205, 703, 154, 293, 383, 622, 317, 519, 696, 648, 127, 372, 339, 270, 713, 68, 700, 236, 295, 704, 612, 123};  
		//System.out.print(1);
		for(int i=0; i<arr.length; i++){
			int ctr = 0;			
					
			if((i-1 >=0) && arr[i] > arr[i-1]){
				ctr++;
				int curr = arr[i];
				for(int j=i; j>=0; j--){
					if((j-1 >=0) && curr > arr[j-1]){
						ctr++;
					}//important as we want continuous span
					else
						break;
				}
			}else{
				ctr++;
			}
		
		System.out.print(ctr+" ");
		}
	}

}
