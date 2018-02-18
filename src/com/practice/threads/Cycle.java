package com.practice.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Cycle {

	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " all parties are done - lets begin...");				
			}
		});
		
		
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " T1 working...");
				try {
					barrier.await();
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {				
				System.out.println(Thread.currentThread().getName() + " T2 working...");
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
			}			
		});
		
		t1.start();
		t2.start();
		
		System.out.println("In the end.");
	}

}
