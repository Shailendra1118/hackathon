package com.booking.redhat;

public class OutputString {
	
	/*
	 * Tell me why you chose the container implementation that you did.
	 *  - Strings are immutable objects
	 *	Is the optimized function thread safe?
	 *	- No
	 *  Is the unoptimized function thread safe?
	 *  - Yes
     * If not, how can you make it thread safe?
	 *	- Use of StringBuffer class
	 */

	public static void main(String args[]){
		String []items = new String[100];
		items[0] = "Hello";
		items[1] = "There";
		items[2] = "Hello";
		OutputString os = new OutputString();
		os.addStringItems(items, true);
		
	}
	
	public String addStringItems(String[] items, boolean forceUpperCase) {
	    // String returnValue=""; Instead StringBuilder should be used
		StringBuilder returnValue = new StringBuilder();
	    for(int i = 0; i < items.length; i++) {
	      //returnValue+=items[i];
	    	returnValue.append(items[i]);
	    }
	    
	    String output = returnValue.toString();	    
	    return forceUpperCase?output.toUpperCase():output;
	 
	}

}
