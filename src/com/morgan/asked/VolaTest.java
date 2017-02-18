package com.morgan.asked;

public class VolaTest {

	static volatile int i = 0;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("t1 current value "+i);
				i++;
				System.out.println("t1 current value upated "+i);
			}
		});
		

		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("t2 current value "+i);
				i++;
				System.out.println("t2 current value updated "+i);
			}
		});
		
		
		t1.start();
		t2.start();
		
		int idx =100;
		while(idx >0){
			System.out.println("final value "+i);
			idx--;
		}
	}

}
