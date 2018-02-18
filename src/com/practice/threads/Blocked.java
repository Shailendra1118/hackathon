package com.practice.threads;

public class Blocked {

	public static void main(String[] args) {
		
		Thread bt = new Thread(new Runnable() {			
			@Override
			public void run() {
				Object obj = new Object();
				synchronized (obj) {
					try {
						//System.out.println("Inside bt " +Thread.interrupted());
						obj.wait();
					} catch (InterruptedException e) {
						//System.out.println(Thread.interrupted());
						e.printStackTrace();
						
					}
					System.out.println("In bt");
					
					try {
						obj.wait();
					} catch (InterruptedException e) {
						System.out.println("2nd time interruption");
						e.printStackTrace();
					}
				}
				
				
			}
		});
		
		Thread at = new Thread(new Task(bt));
		at.start();		
		bt.start();
		
		try {
			at.join();
			Object obj = new Object();
			obj.equals(obj);
			//bt.start();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	private static class Task implements Runnable{
		Thread thread;
		public Task(Thread another){
			this.thread = another;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.thread.interrupt();
			System.out.println("interruption sccess ? "+this.thread.isInterrupted());
			
			this.thread.interrupt();
			System.out.println("interruption sccess again? "+this.thread.isInterrupted());
		}
		
	}

}
