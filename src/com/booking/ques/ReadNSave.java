package com.booking.ques;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class ReadNSave {
	
	public static void main(String args[]){
		
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(40);	
		AtomicBoolean done = new AtomicBoolean();
		CountDownLatch doneSignal = new CountDownLatch(2);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new Runnable(){
			@Override
			public void run() {
				for(int i=0; i<50; i++){
					int value = i*100;
					try {
						Thread.sleep(100);
						queue.put(value);
						System.out.println(value+ " queued by "+Thread.currentThread().getName());
					} catch (InterruptedException e) {
						System.out.println("Excecption while putting vlaue in queue");
						e.printStackTrace();
					}
				}
				done.set(true);
				doneSignal.countDown();
			}
			
		});
		
		
		executor.execute(new Runnable(){
			@Override
			public void run() {
				while(!queue.isEmpty() || !done.get()){ //!done.get()
					try {
						List<Integer> list = new ArrayList<Integer>();
						int value = queue.drainTo(list, 5);//queue.take();
						System.out.println("Got "+value+" values from queue by "+Thread.currentThread().getName());
						Iterator<Integer> iter = list.iterator();
						while(iter.hasNext())
							System.out.println("--"+iter.next());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("Exception while taking out from queue");
						e.printStackTrace();
					}
				}
				doneSignal.countDown();
			}
			
		});
		
		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			System.out.println("Exception while waiting ");
			e.printStackTrace();
		}
		System.out.println("Shutting down all...");
		System.out.println("Is shutdonw "+executor.isShutdown()+" is terminated "+executor.isTerminated());
		executor.shutdown();		
		System.out.println("After call to shutdone : Is shutdonw "+executor.isShutdown()+
				" is terminated "+executor.isTerminated());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Is shutdonw "+executor.isShutdown()+" is terminated "+executor.isTerminated());
	}

}
