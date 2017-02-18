package com.xpanxion.asked;

import java.util.ArrayList;
import java.util.List;


public class PoolParty {

	static WThread a1;
	static WThread a2;
	static WThread a3;
	
	static ArrayList<Thread> pool = new ArrayList<Thread>();
	
	static{
		a1 = new WThread(5,"Ranga"); 
		pool.add(a1);
		a2 = new WThread(10,"Billa"); 
		pool.add(a2);
		a3 = new WThread(15,"Moti"); 
		pool.add(a3);
	}
	public static void main(String[] args) {
		int i = 0;
		while(i < pool.size()){
			Thread t1 = pool.remove(i);
			//t1.start();
			i++;
		}
		
		//int arr[] = {1,2,3,4,5,6};
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		for (int j = 0; j < list.size(); j++) {
			if(list.get(j)%2 == 0){
				System.out.println("even :"+list.get(j));
				list.remove(j);
			}else{
				System.out.println("odd :"+list.get(j));
			}
		}
	}

}




class WThread extends Thread{
	Integer task;
	public WThread(Integer task,String name){		
		super(name);
		this.task = task;
		System.out.println("New thread created with name "+name);
	}
	public void run(){
		for (int i = 0; i < task; i++) {
			System.out.println("Current thread "+Thread.currentThread().getName()+" task:"+i);
		}
	}
}