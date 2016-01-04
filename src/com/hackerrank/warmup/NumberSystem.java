package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class NumberSystem {

	//static int arr[] = new int[999999999];
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	static ArrayList<String> output = new ArrayList<String>();
	public static void main(String[] args) {
		String numCode = "";
		populateMap();
		int num = 901208;//503512;//5268312;
		// 2 1 3 8 6 2 5
		//store each digit in array
		int temp = num;
		int remainder = 0;
		int result = 0;
		//System.out.println("5%10 "+5%10);
		while(temp >0){
			result  = temp/10;
			remainder = temp%10;
			arr.add(remainder);
			//System.out.println(remainder);
			temp = result;			
		}
		//Collections.reverse(arr); //reverse 
		// 2 1 3 8 6 2 5
		int array [] = convertToArray(arr);
		for (int i = 0; i < arr.size(); i++) {
			int curr = array[i];
			switch(i){
			case 0: //unit
				if((i+1) < arr.size() && array[i+1] > 0){
					int key = array[i+1]*10+array[i];
					//System.out.println("key "+key + " value "+map.get(key));
					output.add(map.get(key));
					i++;
				}else{
					output.add(map.get(array[i]));
				}
				
				break;
			case 1: //tens
				if(array[i-1] == 0){
					if(map.get(curr).equals("Two"))
						output.add("Twenty");
					if(map.get(curr).equals("Three"))
						output.add("Thirty");
					if(map.get(curr).equals("Four"))
						output.add("Fourty");
					if(map.get(curr).equals("Five"))
						output.add("Fifty");
					if(map.get(curr).equals("Six"))
						output.add("Sixty");
					if(map.get(curr).equals("Seven"))
						output.add("Seventy");
					if(map.get(curr).equals("Eight"))
						output.add("Eighty");
					if(map.get(curr).equals("Nine"))
						output.add("Ninty");
				}
				
				break;
			case 2: //hundrades
				if(curr > 0)
				output.add(map.get(curr)+" hundrade");
				break;
			case 3: //thousands
				if((i+1) < arr.size() && array[i+1] > 0){
					if(map.get(array[i+1]).equals("Six")){
						output.add("Sixty "+map.get(curr));
						i++;
					}
					//int key = array[i+1]*10+array[i];
					//System.out.println("key "+key + " value "+map.get(key));
					//output.add(map.get(key));					
				}else{
					output.add(map.get(array[i])+" thousand");
				}
				break;
			case 4: //ten thous
				if(curr > 0)
					output.add(map.get(array[i])+" thousand");
				break;
			case 5: //lac
				output.add(map.get(array[i])+" lacs");
				break;
			case 6: // ten lacs
				break;
			case 7: // crore
				break;
			default :
				System.out.println("You are so rich, we cant help you");
			}
				

			
			
			
			
		}
		Collections.reverse(output);
		System.out.println(output);
		
		
	}
	private static int[] convertToArray(ArrayList<Integer> arr2) {
		int[] array = new int[100000000];
		for(int i=0; i<arr2.size(); i++){
			array[i] = arr2.get(i).intValue();
			System.out.print(" "+array[i]);
		}		
		return array;
	}
	private static void populateMap() {
		// 2 1 3 8 6 2 5
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");
		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Ninteen");
		map.put(20, "Twenty");
		
		
	}

}
