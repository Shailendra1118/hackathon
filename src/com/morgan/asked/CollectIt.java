package com.morgan.asked;

public class CollectIt {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable(){
			public void run(){
				int cnt = 100;
				while(cnt > 0){
					//System.out.println("cnt-"+cnt);
				}
				System.out.println("t1 completed");
					
			}
		});
		
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				//new Object().wait();
				try {
					t1.sleep(4000); //put this current thread to sleep not t1
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t1.stop();
				
				System.out.println("t2"+" completed");
					
			}
		});
		
		t1.start();
		t2.start();
		
	}

}
