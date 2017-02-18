package com.sapient.ques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1DArray {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\Keppler\\Hackerrank\\src\\com\\sapient\\ques\\test.txt");
		Scanner scan = new Scanner(file);
		int total = scan.nextInt(); //System.out.println("total "+total);		
		for(int i=0 ;i<total; i++){
			int size = scan.nextInt(); //System.out.println("size "+size);
			int jump = scan.nextInt(); //System.out.println("jump "+jump);
			String arr[] = new String[500];
			for(int j=0; j<size; j++){				
				//arr = new String[size];
				String input = scan.next();
				//System.out.println(input);
				arr[j] = input;
				//System.out.println("arr size "+arr.length);				
			}
			int ptr = 0;
			boolean flag = true;
			while((ptr >=0) && ptr <=size-1){
				try{
					if((jump >1) && arr[ptr+jump].equals("0")){
						ptr = ptr+jump;
					}
					else{
						if((ptr+1 <=size-1) && arr[ptr+1].equals("0")){
							ptr = ptr+1;
						}
						else{
							if((jump >1) && (ptr-1 >=0) && (ptr-1+jump <=size-1) && arr[ptr-1+jump].equals("0")){ //what if it on first position only
								ptr = ptr-1;
								ptr = ptr+jump;
							}
							else{
								flag = false;
								break;
							}
						}
					}
				}catch(NullPointerException exp){
					//flag = true;
					break;
				}
			}
			
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
			
			//String input = scan.next();
			//printArray(arr);						
			//System.out.println();
		}

	}

	private static void printArray(int[] arr) {
		for(int x=0; x<arr.length; x++)
			System.out.print(" "+arr[x]);
		
	}

}
