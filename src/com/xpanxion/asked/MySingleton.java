package com.xpanxion.asked;

public enum MySingleton {

	 INSTANCE;
	 String name = "Init";

	    private MySingleton(){

	    }

	    public Object[] buildAnimalList(){
	        final Object[] animals = new Object[10];

	        animals[0] = new Object();
	        animals[1] = new Object();
	        animals[2] = new Object();
	     
	        return animals;
	    }
	    
	   

}


