package com.hackerrank.warmup;

import java.util.ArrayList;

public class Geeks {
	static int [] inputArrayG = new int [20];

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(0);
		list.add(-1);
		list.add(0);
		int arr[] = {1, 2, 5, -7, 2, 3};
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(5);
		list1.add(-7);
		list1.add(2);
		list1.add(3);
		System.out.println(list1);
		System.out.println("subarray "+maxset(list1));
		maxSub(inputArrayG);
	}
	
	
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        int[] inputArray = new int[a.size()];
        for (int i=0; i < inputArray.length; i++)
        {
            inputArray[i] = a.get(i).intValue();
            inputArrayG[i] = a.get(i).intValue();
        }

      int maxSum = inputArray[0];
      int maxStartIndex = 0;
      int maxEndIndex = 0;
      
      int curSum = inputArray[0];
      int curStartIndex = 0;
      
    
      for (int i = 1; i < inputArray.length; i++)
      {
        if (curSum < 0)
        {
          curSum = 0;
          curStartIndex = i;
        }
        
        curSum = curSum + inputArray[i];
    
        if (curSum >= maxSum)
        {
    
          maxSum = curSum;
          maxStartIndex = curStartIndex;
          maxEndIndex = i;
        }
      }
      
      
      
      ArrayList<Integer> ans = new ArrayList();
      for(int i = maxStartIndex; i <= maxEndIndex; i++){
        ans.add(inputArray[i]);    
      }
      return ans;
      
	}
	
	/*
	 * Loop i = 1 to Array.length :
        IF current element is positive :
                update current sum
                compare max sum with current sum
                update max sum
                update max ranges
        ELSE :
            current sum := 0
            update current ranges.
		EndLoop;

		return elements of max ranges
	 */
	public static void maxSub(int [] list){
		int curSum = 0, maxSum = 0;
		int startIndex = 0, endIndex = 0, curIndex = 0;
				
		for (int i = 1; i < list.length; i++) {
			if(list[i] >0){
				curSum = curSum + list[i];
				if(curSum > maxSum){
					maxSum = curSum;
					  startIndex = curIndex;
			          endIndex = i;
				}
			}else{
				curSum = 0;
				curIndex = i+1;
				endIndex = i+1;
			}
		}
		
		//int arr[] = new int[20];
		 for(int i = startIndex; i <= endIndex; i++){
			 System.out.println(list[i]);
		      }
		//return arr;
		
	}

}
