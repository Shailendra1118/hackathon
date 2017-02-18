package com.hackerrank.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Funday {

	public static void main(String[] args) {
		List<Developer> list = new ArrayList<>();
		list.add(new Developer(23,"Shailendra"));
		list.add(new Developer(14,"Aman"));
		list.add(new Developer(80,"Vinayak"));
		list.add(new Developer(9,"Gujju"));
		
		Comparator<Developer> cmpbyAge = new Comparator<Developer>(){
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge()-o2.getAge();
			}
		};
		
		Collections.sort(list, cmpbyAge);
		for(Developer dev : list){
			System.out.println(dev.getAge()+" "+dev.getName());
		}
		
		Comparator<Developer> cmpName = (Developer d1, Developer d2) -> d1.getName().compareTo(d2.getName());
		//Collections.sort(list, cmpName);
		System.out.println("----by name---");
		for(Developer dev : list){
			System.out.println(dev.getAge()+" "+dev.getName());
		}
		
		System.out.println("---list.sort :");
		list.sort((d1, d2)-> d1.getName().compareTo(d2.getName()));  //It can infer Developer type
		for(Developer dev : list){
			System.out.println(dev.getAge()+" "+dev.getName());
		}
	}

	
}

class Developer{
	
	public Developer(int age, String name){
		this.age = age;
		this.name = name;
	}
	private String name;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
}