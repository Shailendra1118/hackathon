package com.booking.redhat;

public class RangeTest {
	public static void main(String args[]){
		RangeImplem r = new RangeImplem();
		r.add(r.newRange(11, 15)).add(r.newRange(12, 13));
		System.out.println(r.isIn(8));
	}
}
