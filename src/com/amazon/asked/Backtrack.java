package com.amazon.asked;

import java.util.Arrays;

public class Backtrack {

	static int target = 35;
	public static void main(String[] args) {
		int set[] = {1,3,5,4,6};
		boolean isSubset = isSubSum(set, set.length-1, 13);
		System.out.println("Ans: "+isSubset);
	}

	private static boolean isSubSum(int[] arr, int n, int sum) {
		
		if(sum == 0)
			return true;
		if(sum < 0)
			return false;
		if(n <= 0 && sum > 0)
			return false;
		System.out.println("n: "+n+" sum: "+sum+" arr[n] "+arr[n]);
		return isSubSum(arr, n-1, Math.abs(sum-arr[n])) || isSubSum(arr, n-1, sum);
		
	}

	private static void findSubset(int[] sofar, int[] rest, int sid) {
		if(rest.length == 0){
			System.out.println(Arrays.toString(sofar)); // soFar sum is equal to target then return true;
			return;
		}else{
			for (int i = 0; i < rest.length; i++) {
				sofar[sid++] = rest[i];
				int remaining[] = Arrays.copyOfRange(rest, 0, i);
				for (int j = i+1; j < rest.length; j++) {
					remaining[j] = rest[j];
				}
					findSubset(sofar, remaining, sid);
			}
			
		}
		
		
	}

}
