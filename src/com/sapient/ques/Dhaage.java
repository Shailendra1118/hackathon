package com.sapient.ques;

public class Dhaage {
	public static void main(String args[]){
		boolean counter = false;
		final Object obj = new Object();
		
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("in T1 run");
				new Generator<Integer, RuntimeException>(new Integer(100), new RuntimeException("Heello"));
				String [] arr = new String [22];
				arr[0] = "First";
				arr[1] = "Second";
				//Generator.showIt(arr);
				try {
					
					if(Thread.interrupted()){
						System.out.println("Got interruption");
						//Thread.sleep(4000);
						throw new InterruptedException();
					}
				} catch (InterruptedException e) {
					//counter = true;
					e.printStackTrace();
					System.out.println("Interuppted it is.");
				}
			}
			
		});
		
		t1.start();				
		System.out.println("My main thread");
		t1.interrupt();
		try {
			//Thread.sleep(2000);			
			//throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	static class Generator<T,V extends Exception>{
		private T value = null; //static is not allowed
		private V tea = null;
		
		public Generator(T value, V tea){
			this.value = value;
			this.tea = tea;
			//System.out.println(value+" "+tea);
		}
		
		public static <T extends Comparable> void showIt(T[] array){
			System.out.println(array.length+" below elements :");
			for(int i=0; i<array.length; i++){
				System.out.println(array[i]);
			}
		}
		
	}
}


