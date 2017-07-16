package com.hackerrank.java8;

//import java.math.BigInteger;

public class PowerOfTwo {

	public static void main(String[] args) {
		int res = power("1");//("147573952589676412928");
		System.out.println("res: "+res);
		
		String str = "16832";
		System.out.println("new: "+powerSmart(str));

	}
	
	// very bad solution - should think of more granular level
	public static int power(String a) {
		
		   java.math.BigInteger num = new java.math.BigInteger(a);
		   java.math.BigInteger two = new java.math.BigInteger("2");
		   java.math.BigInteger zero = new java.math.BigInteger("0");
		   java.math.BigInteger one = new java.math.BigInteger("1");
		   //System.out.println(num.remainder(two).equals(zero));
		   if(num.intValue() ==1)
			   return 0;
		   while(num.remainder(two).equals(zero)){		     
		       num = num.divide(two);
		       System.out.println("num: "+num);
		   }
		   if(num.equals(one))
		   return 1;
		   else
		   return 0;
	}
	
	public static int powerSmart(String A) {
	    
	    String dividend = A;
	    StringBuilder str;
	    
	    if (A == null || A.length() == 0)
	        return 0;
	    
	    if (A.length() == 1 && A.charAt(0) == '0')
	        return 0;
	    
	    while (dividend.length() > 0 && !dividend.equalsIgnoreCase("2")) {
	    	System.out.println("dividend: "+dividend);
	        str = new StringBuilder();
	        int carry = 0;
	        int n = dividend.length();
	        
	        if (n > 0) {
    	        int num = dividend.charAt(n - 1) - '0';    	        
    	        if (num % 2 == 1)
    	            return 0;
	        }
	        
	        for (int i = 0; i < n; i++) {	            
	            char c = (char) (dividend.charAt(i) - '0');
	            int res = c + 10 * carry;
	            
	            c = (char) (res / 2 + '0');
	            carry = res % 2;	            
	            str.append(c);
	            System.out.println("str: "+str);
	        }
	        
	        if (str.charAt(0) == '0')
	            str.deleteCharAt(0);
	            
	        dividend = str.toString();
	    }
	    
	    return 1;
	    
	}

}
