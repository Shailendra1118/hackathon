package com.interview.bit;

public class MathMax {

	public static void main(String[] args) {
		System.out.println(new FindPrime().isPrime(39601));
		//System.out.println(new Excel().titleNumber("AA"));
	}

}


class FindPrime{
	public int isPrime(int input) {
	    //System.out.println("Sqrt of input "+input+"-"+Math.sqrt(input));
	    //edge case for 1
	    if(input == 1)
	    	return 0;
	    for(int i=2; i<=Math.sqrt(input); i++ ){
	        if(isFactorOf(i, input)){
	            return 0;	
	        }
	    }
	    
	    return 1;
	}
	
	private boolean isFactorOf(int num, double d){
		//System.out.println("input "+d+" num "+num);
	    if(d%num == 0){
	    	System.out.println(d+" is divied by "+num);
	        return true;
	    }
	   else
	        return false;
	}
}

