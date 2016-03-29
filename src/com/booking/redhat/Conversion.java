package com.booking.redhat;

import java.util.ArrayList;

public class Conversion {
	static ArrayList<Integer> list = new ArrayList();
	public static void main(String args[]){
		base10to2("74");
		String output = "";
		for(int i=0;i<list.size();i++)
			output = output + list.get(i);
			//System.out.print(list.get(i));
		
		//pad to make it 8-bit
		//String.format("%8s", output).replace(' ', '0');
		System.out.println(String.format("%8s", output).replace(' ', '0'));
	}
	  
	  /**
	    * Convert a base-10 integer to an 8-bit two's complement binary number, and  return the binary number.
	   */
	 
	  public static void base10to2(String base10) {
		  printBinaryform(Integer.valueOf(base10));
		 // return 
	   }
	  
	  private static void printBinaryform(int number) {
		  System.out.println("number is "+number);
	        int remainder;
	        if (number <= 1) {
	            //System.out.print(number);
	            list.add(number);
	            return; 
	        }

	        remainder = number %2; 
	        printBinaryform(number >> 1);
	        list.add(remainder);
	       // System.out.print(remainder);
	    }

	 
	 
	 
	  /**
	   * Return 2's complement negative of the given base10 number and return the binary number
	  */
	 
	  public String negBase2(String base10) {
		  //logic would be on the same line
		  //leaving due to time constraint
		return base10;
	    
	   }

}
