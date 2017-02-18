package com.morgan.asked;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class CollectionUtil {

	public static void main(String[] args) {
		CollectionUtil col = new CollectionUtil();
		col.Collections();
		
		Employee e1 = new Employee(1, "Shailendra");
		Employee e2 = new Employee(2, "Shailendra");
		Employee e3 = new Employee(3, "Shailendra");
		Employee e4 = new Employee(4, "Shailendra");
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e4);
		list.add(e3);
		list.add(e2);
		list.add(e1);
		
		//printIt(list.iterator());	
		//java.util.Collections.sort(list);
		//System.out.println("After sorting");
		//printIt(list.iterator());	
		
		Manager em1 = new Manager(11, "Shailendra");
		Manager em2 = new Manager(22, "Azad");
		Manager em3 = new Manager(33, "Pallavi");
		Manager em4 = new Manager(44, "Sonal");
		ArrayList<Manager> list1 = new ArrayList<Manager>();
		list1.add(em4);
		list1.add(em3);
		list1.add(em2);
		list1.add(em1);
		
		printIt(list1.iterator());	
		java.util.Collections.sort(list1, new Manager(99,"Dummy"));
		//list1.sort(null);                                 //comparator is optional
		System.out.println("After manager sorting");
		printIt(list1.iterator());	
			
	}
	
	public static void printIt(Iterator<Manager> iter){
		while(iter.hasNext()){
			Employee e = iter.next();
			System.out.println(e.id +" "+e.name);
		}
	}
	
	
	
	public void Collections(){  //method with same name as class is allowed
		System.out.println("method");
	}

}


class Employee implements Comparable<Employee>{
	Integer id;
	String name;
	public Employee(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Employee o) {
		if(this.id > o.id)
			return 1;
		else if(this.id < o.id)
			return -1;
		else
			return 0;
	}
}



class Manager extends Employee implements Comparator<Manager>{
	public Manager(Integer id, String name) {
		super(id, name);
	}

	@Override
	public int compare(Manager o1, Manager o2) {
		return o1.name.compareTo(o2.name);
	}

}