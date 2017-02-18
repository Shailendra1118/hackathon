package com.practice.threads;

public class Blocked {

	public static void main(String[] args) {

		Thread at = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("In at");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread bt = new Thread(new Runnable() {			
			@Override
			public void run() {
				Object obj = new Object();
				try {
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("In bt");
				
			}
		});
		
		//at.start();		
		
		try {
			at.join();
			Object obj = new Object();
			obj.equals(obj);
			//bt.start();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

}
