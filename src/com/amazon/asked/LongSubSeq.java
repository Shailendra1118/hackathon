package com.amazon.asked;


public class LongSubSeq {

	static int count = 0;
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int mx_here = lis(arr, arr.length);
		System.out.println("max_ending_here "+mx_here);
		System.out.println("count: "+count);

	}

	private static int lis(int[] arr, int n) {
		System.out.print("Got: n="+n+" ");
		//Arrays.toString(arr);
		
		//base
		if(n == 1)
			return 1;
		
		int res, max_ending_here = 1;
		
		for (int i = 1; i < n; i++) {
			System.out.println("lis calling with i:"+i);
			res = lis(arr, i);
			//System.out.println("lis returned with res:"+res+" n is "+n);
			if(arr[i-1] < arr[n-1] && res +1 > max_ending_here){
				//System.out.println(arr[n-1]+" is greater than "+arr[i-1]);
				max_ending_here = res+1;
			}else{
				//System.out.println(arr[n-1]+" is NOT greater than "+arr[i-1]);
				//System.out.println(res +1 > max_ending_here);
			}
			
		}
		
		// Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (count < max_ending_here)
           count = max_ending_here;
 
        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
		
		
		
		
	}

}
