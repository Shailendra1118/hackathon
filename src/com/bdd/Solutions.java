package com.bdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Solutions extends Employee {

	final public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("running");
		Solutions sol = new Solutions();
		sol.display();
	}
	
	public void display(){
		this.setName("Ramu");
		this.name = "Shyamlal";
		System.out.println(this.name);
		System.out.println(this.getName());
		Stack<Integer> stk = new Stack<>();
		stk.push(1);
		stk.push(15);
		stk.push(8);
		stk.push(3);
		stk.push(2);
		sortStack(stk);
		
	}
	
	public static Stack<Integer> sortStack(Stack<Integer> input) {
		List<Integer> list = new ArrayList<>(input.size());
		list.addAll(input);
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2)
				return 1;
				else if(o1 > o2)
					return -1;
				else
					return 0;
			}
			
		});
		input.clear();
		return input;
		
	}

}


class Employee extends Manager{
	protected String name;
	
	public void setName(String name){
		this.name = name;
	}
}

class Manager{
	protected String name;
	public String getName(){
		return name;
	}
}