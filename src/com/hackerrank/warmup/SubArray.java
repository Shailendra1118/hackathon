package com.hackerrank.warmup;

public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_so_far = 0;
		int max_ending_here = 0;
		for(int i=0; i< array.length; i++){
			max_ending_here = max_ending_here + array[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		System.out.println(max_so_far);

	}

}