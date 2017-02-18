package com.practice.april.core;

import java.util.ArrayList;
import java.util.List;

public class TestClassDefNotFound {

	private final static int TOTAL_RECORDS = 100;

	public static void main(String args[]) {
		System.out.println(System.getProperty("java.class.path"));
		try{
			List records = new ArrayList(TOTAL_RECORDS);

			for(int i=1; i < TOTAL_RECORDS; ++i)
				records.add(Record.ID);   //new Record(i));
		}
		catch(Throwable t) {
			t.printStackTrace();
			throw t;
		}
	}
}

class Record {
	public static Integer ID = getRandomInteger();

	public Record(Integer Id){
		this.ID = Id;
	}

	private static Integer getRandomInteger() {
		throw new RuntimeException("The method is not implemented...");
		//return new Random.nextInt();
	}
}