package com.march.prac.four;

public class JohnZizi {

	public static void main(String[] args) {
		//8 7 1
		int n = 8;
		int m = 7;
		int c = 1;
		
		long res = compute(n, m, c);
		System.out.println("Res: "+res);
	}

	private static long compute(int n, int m, int c) {
		//nPr
		long john = Math.abs(n-c);
		long zizi = Math.abs(m-c);
		long total = john+zizi+c-1; //remove one as that will be common
		System.out.println("total: "+total);
		return facto(total);
	}

	private static long facto(long n) {
		if(n <= 1)
			return 1;
		return n*facto(n-1);
	}

}