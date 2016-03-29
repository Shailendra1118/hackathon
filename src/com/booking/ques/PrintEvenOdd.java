package com.booking.ques;

public class PrintEvenOdd {
	static int ctr = 0;
	static int max = 10;
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				while(ctr < max){
					System.out.println("T1 :"+(++ctr)); //odd
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				while(ctr < max){
					try {						
						System.out.println("T2 :"+(++ctr));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}

}
