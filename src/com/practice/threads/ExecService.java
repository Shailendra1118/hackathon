package com.practice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ExecService {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);
 
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(callable1);
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(callable2);
 
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //executor.execute(futureTask1); //futureTask is type of Runnable
        //executor.execute(futureTask2);
        List<MyCallable> list = new ArrayList<>();
        list.add(callable1);
        list.add(callable2);
        //int result = executor.invokeAny(list);
        //System.out.println("result is "+result);
        
        List<Future<Integer>> list1 = executor.invokeAll(list);
        for(Future<Integer> one : list1){
        	System.out.println("waiting on.."+one.isDone());
        	int res = one.get();
        	System.out.println("this "+one+" got "+res);
        }
        //callWithFuture(futureTask2, futureTask2);
        
        
        
        executor.shutdown();
        System.out.println("now.. "+executor.isTerminated());
        while(!executor.isTerminated()){
        	//System.out.println("waiting..");
        }
        System.out.println("now.. "+executor.isTerminated());
        System.out.println("Executor is terminated fully");
	}

	private static void callWithFuture(FutureTask<Integer> futureTask2,
			FutureTask<Integer> futureTask1) {try{
		        System.out.println("futureTask1 "+futureTask1.isDone());
		        int res1 = futureTask1.get();
		        System.out.println("rest1 "+res1);
		        System.out.println("futureTask1 "+futureTask1.isDone());
	        }catch(Exception e){
	        	System.out.println("Exception futureTask1 "+e.getCause());
	        }
	        
	        try{
		        System.out.println("futureTask2 "+futureTask2.isDone());
		        int res2 = futureTask2.get();
		        System.out.println("rest2 "+res2);
		        System.out.println("futureTask2 "+futureTask2.isDone());
	        }catch(Exception e){
	        	System.out.println("Exception futureTask2 "+e.getCause());
	        }
	        
		
	}
}

class MyCallable implements Callable<Integer>{
	private Integer num;
	public MyCallable(Integer num){
		super();
		this.num = num;
	}
	@Override
	public Integer call() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() +" executing call with "+num);
		Thread.sleep(num);
		System.out.println(Thread.currentThread().getName()+" done");
		//throw new RuntimeException("Faking it");
		return num/2;
	}
	
}
