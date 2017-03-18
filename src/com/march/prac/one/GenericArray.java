package com.march.prac.one;

public class GenericArray {

	public static void main(String[] args) {
		Object[] arr = new String[5];
		arr[0] = "Shailendra";
		arr[1] = 10;
		// java arrays are covariant but generics are NOT
		System.out.println("All's good.");
	}

}
