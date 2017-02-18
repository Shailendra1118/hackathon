package com.amazon.asked;

public class StringIntern {

	public static void main(String[] args) throws Exception {
		String a = "Shailendra";
		String b = new String("Shailendra");
		String c = "Shailendra";
		
		if(a == b)
			System.out.println("==");
		
		if(a.equals(b))
			System.out.println("equals");
		
		if(a == c)
			System.out.println("a==c");
		
		String d = b.intern();
		if(d == c)
			System.out.println("d==c after intern");
		
		if(a == d)
			System.out.println("a==d after intern");
		
		if(b == c)
			System.out.println("b==c");
		
		printIt(null);
		
		String first = "one";
		String sec = "second";
		String res = first+" "+sec;
		System.out.println(res);
		
		
	}

	private static void printIt(Object object) {
		System.out.println(object);
	}
	
	private static void printIt(String str) throws Exception{
		System.out.println(str);
		//throw new Exception();
	}

}
