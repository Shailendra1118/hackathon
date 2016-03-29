package com.booking.ques;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOdd {
	static AtomicInteger index = new AtomicInteger();
	static AtomicInteger index1 = new AtomicInteger(1);
	private volatile static boolean read = false;
	//private volatile int boolean started = false;

	public static void main(String args[]){
		int counter = 0;
		int arr[] = {1,2,1,2,1,2,1,2};
		//final Object lock = new Object(); 
		
		Thread first = new Thread(new Runnable() {
			@Override
			public void run() {				
			
					while(index.get() <arr.length){
						synchronized (arr) {
						//if(index.get() <arr.length){
							System.out.println("printed by first "+arr[index.get()]);
							index.incrementAndGet();
							try {
									while(!read){ //good practice
									read = true; //started = false;
									arr.wait();
									}
							} catch (InterruptedException e) {
								System.out.println("Exception in first");
								e.printStackTrace();
							}						
					}					
				}
			}
		});
		
		Thread second = new Thread(new Runnable() {
			@Override
			public void run() {
				while(index.get() <arr.length){
					if(read){
					synchronized (arr) {								
											
														
									System.out.println("printed by second "+arr[index.get()]);
									index.incrementAndGet();
									read = false;
									arr.notify();
									//read = false;
							
						}
					}
			}
			}
				
		});
		
		first.start();
		second.start();
		
	
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				while(index.get() < arr.length){
					//synchronized(arr){
						System.out.print(" "+arr[index.get()]);
						index.incrementAndGet();
						index.incrementAndGet();					
					
				}		
				
				//index.set(1);
				//sSystem.out.println("at last "+index.get());
				read = true;
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {				
				
				while(index1.get() < arr.length){
					if(read){
					//synchronized(arr){
					System.out.print(" "+arr[index1.get()]);
					index1.incrementAndGet();
					index1.incrementAndGet();
					}
				
				}
			}
			
		});
		
		//t1.start();
		//t2.start();
		
		
	}

}
