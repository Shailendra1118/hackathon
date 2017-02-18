package com.practice.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class CanCallable {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		Future<?>future = service.submit(new YCallable(100));
		
		try {
			String result = (String) future.get();
			System.out.println("result "+result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}	
		
		service.shutdown();
		
		System.out.println("ForkJoinPool.getCommonPoolParallelism() "+ForkJoinPool.getCommonPoolParallelism());  // 3
	}

}

class YCallable implements Callable<String>{
	private int value = 10;
	
	public YCallable(int value){
		this.value = value;
	}

	@Override
	public String call() throws Exception {
		if(this.value > 10)
			return "Hello from call result "+value;
		else
			return "give me more";
	}
}