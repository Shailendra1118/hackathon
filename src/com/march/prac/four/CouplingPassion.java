package com.march.prac.four;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CouplingPassion {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("D:/Keppler/Hackerrank/src/com/march/prac/four/input.txt"));
		int guests = s.nextInt();
		HashSet<String> gp = new HashSet<>();
		for (int i = 0; i < guests; i++) {
			int passions = s.nextInt();
			for (int j = 0; j < passions; j++) {
				String passion = s.next();
				gp.add(passion);
			}			
		}
		//System.out.println("Total passions:");
		//gp.forEach(p->System.out.println(p));
		
		ArrayList<Destination> dList = new ArrayList<>();
		int dests = s.nextInt();
		for (int i = 0; i < dests; i++) {
			String name = s.next();
			Double longi = s.nextDouble();
			Double latti = s.nextDouble();
			int pnum = s.nextInt();
			HashSet<String> dp = new HashSet<>();
			int degree = 0;
			for (int j = 0; j < pnum; j++) {
				String p = s.next();
				if(gp.contains(p)){
					degree += 1;
				}
				dp.add(p);
			}
			Destination dest = new Destination(name, longi, latti, dp);
			dest.degree = degree;
			dList.add(dest);
		}
		
		couplePassions(gp, dList);
		
		s.close();
	}

	private static void couplePassions(HashSet<String> gp, ArrayList<Destination> dList) {
		dList.sort((o1, o2)-> { 
			if(o1.degree > o2.degree) return -1;
			else if(o1.degree < o2.degree) return 1;
			else return 0;
		});
		
		//System.out.println("print according to highest degree: ");
		//dList.forEach(d-> System.out.println(d));
		//System.out.println("Pick top 2: ");
		List<Destination> list = dList.stream().limit(2).collect(Collectors.toList());
		list.sort((o1,o2)-> o1.name.compareTo(o2.name) );
		list.forEach(d->System.out.print(d+" "));
		
	}
	
	

}

class Destination{
	String name;
	Double longi;
	Double latti;
	HashSet<String> passions;
	int degree;
	
	public Destination(String name, Double longi, Double latti, HashSet<String> passions){
		this.name = name;
		this.latti = latti;
		this.longi = longi;
		this.passions = passions;
	}
	
	public String toString(){
		return name;//+" "+degree+" "+passions;
	}
}
