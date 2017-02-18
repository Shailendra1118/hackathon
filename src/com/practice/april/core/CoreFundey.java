package com.practice.april.core;

public class CoreFundey {

	public static void main(String[] args) {
		String obj = new String("Shailendra");
		
		Object str = obj;  //no casting expression required auto
		
		//Number num = new Integer(10);
		//Human h = new Person();
		//Person p = (Person) new Human(); 		
		System.out.println(str);
		
		long lon = 300L;
		//assert lon > 300L : "bigger than 300";
		System.out.println(Long.toBinaryString(lon));
		//System.out.println();
		byte a = (byte)300L;
		System.out.println(a);
		
		System.out.println("LOng bytex "+Long.BYTES);
		System.out.println(numberOfLeadingZeros(lon));
		System.out.println(Math.pow(2, 32) );
		System.out.println(Long.MAX_VALUE);
		System.out.println( (long)Math.pow(2, 31) << 33); //9223372036854775807 int : 2147483647 /-2147483648
		
		System.out.println(Integer.numberOfLeadingZeros(2048));
		
	}
	
	 public static int numberOfLeadingZeros(long i) {
	        // HD, Figure 5-6
	         if (i == 0)
	            return 64;
	        int n = 1;
	        int x = (int)(i >>> 32);
	        System.out.println(Long.toBinaryString(x));
	        
	        if (x == 0) 
	        	{ n += 32; x = (int)i; }
	        	System.out.println(Long.toBinaryString(x));
	        if (x >>> 16 == 0) 
	        	{ n += 16; x <<= 16; }
	        	System.out.println(Long.toBinaryString(x));
	        if (x >>> 24 == 0) 
	        	{ n +=  8; x <<=  8; }
	        	System.out.println(Long.toBinaryString(x));
	        if (x >>> 28 == 0) 
	        	{ n +=  4; x <<=  4; }
	        	System.out.println(Long.toBinaryString(x));
	        if (x >>> 30 == 0) 
	        	{ n +=  2; x <<=  2; }
	        	System.out.println(Long.toBinaryString(x));
	        n -= x >>> 31;
	        return n;
	    }

}
