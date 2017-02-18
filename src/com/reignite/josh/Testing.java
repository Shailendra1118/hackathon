package com.reignite.josh;


public class Testing {

	static Integer first = 0;
	static Integer sec = 1;
	static Integer term = 10;
	public static void main(String[] args) {
		
		System.out.println(fib(term)& 0xffffffffl);

	}
	
	private static Integer fib(double term){
		if(term == 2){
			return new Integer("1");
		}else
			if(term == 1 )
				return new Integer("0");
			else{
				Integer a = fib(term-1);
				Integer b = fib(term-2);
				Integer c = (int) Math.pow(a.doubleValue(), 2);
				System.out.println("C "+c);
				Integer d = c + b;
				System.out.println("D "+d);
				//Integer c = (int) (Math.pow(a.doubleValue(), 2)+b.doubleValue());
				//int d[] = new int[10];
				//d[0] = c.intValue();
				//System.out.println();
				return d; //new Integer(String.valueOf(c.intValue()));
			}
	}

}
