package com.booking.redhat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RangeImplem implements Range{
	
	private int from;
	private int to;
	private List<Range> list; // = new ArrayList<>();
	//private List<Integer> list = new ArrayList();

	@Override
	public Range newRange(int from, int to) {
		this.from = from;
		this.to = to;
		return this;
	}

	@Override
	public boolean isIn(int value) {
		return checkInList(value);
	}

	private boolean checkInList(int value) {
		Collections.sort(this.list, new RangeComparator());
		boolean found = false;
		for(int i=0; i<list.size(); i++){
			if(value >= ((RangeImplem)list.get(i)).from && value <= ((RangeImplem)list.get(i)).to){
				found = true;
			}
		}
		return found;
	}

	@Override
	public int min() {
		//RangeImplem r = (RangeImplem) list.get(0);
		//return r.from;
		return this.from;
	}

	@Override
	public int max() {
		//RangeImplem r = (RangeImplem) list.get(list.size()-1);
		//return r.to;
		return this.to;
	}

	@Override
	public Range add(Range r) {		
		//this.list.add(r);		
		//return this;
		if(list == null){
			list = new ArrayList<Range>();
		}
		System.out.println("before "+list.size());
		this.list.add(r);
		System.out.println("after "+list.size());
		Collections.sort(this.list, new RangeComparator());
		List<Range> temp = this.list;
		for(int i=0; i< temp.size(); i++){
			if(i+1 <temp.size()){
				RangeImplem r1 = (RangeImplem)temp.get(i);
				RangeImplem r2 = (RangeImplem)temp.get(i+1);
				System.out.println("r1 :"+r1.min()+" "+r1.max());
				System.out.println("r2 :"+r2.min()+" "+r2.max());
				if(r1.max() >= r2.min()){
					r1.setFrom(Math.min(r1.min(), r2.min()));
					r1.setTo(Math.max(r1.max(), r2.max()));
					System.out.println("merging "+r1.getFrom()+" "+r1.getTo());
					temp.remove(temp.get(i+1));
				}
			}
		}
		System.out.println("After add size :"+temp.size());
		Iterator<Range> iter = this.list.iterator();
		while(iter.hasNext()){
			Range r1 = iter.next();
			System.out.println("min "+r1.min()+" max "+ r1.max());
		}	
		this.list = temp;	
		return this;
	}

	/**
	 * @return the from
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public int getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(int to) {
		this.to = to;
	}
	

}

class RangeComparator implements Comparator<Range>{	
	@Override
	public int compare(Range o1, Range o2) {
		return ((RangeImplem) o1).getFrom() - ((RangeImplem) o2).getFrom();
	}
	
}
