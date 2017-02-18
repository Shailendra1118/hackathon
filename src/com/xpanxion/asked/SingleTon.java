package com.xpanxion.asked;

public class SingleTon {
	public static void main(String args[]){
		MySingleton ton = MySingleton.INSTANCE;
		System.out.println(ton.name+ton.hashCode());
		ton.name = "other";
		MySingleton ton1 = MySingleton.INSTANCE;
		System.out.println(ton1.name+ton1.hashCode());
	}
}
