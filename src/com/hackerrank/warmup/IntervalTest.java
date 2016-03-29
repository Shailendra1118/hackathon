package com.hackerrank.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class IntervalTest {

	static class Interval implements Comparable<Interval>{
		int start =0;
		int end=0;
		
		Interval(int start, int end){
			this.end = end;
			this.start = start;			
		}

		@Override
		public int compareTo(Interval o) {
			//System.out.println("compareTO "+this.start+" "+o.start);
			return o.start - this.start;
		}
	}
	public static void main(String[] args) {
		Interval i1 = new Interval(6,8);
		Interval i2 = new Interval(1,9);
		Interval i3 = new Interval(2,4);
		Interval i4 = new Interval(4,7);
		Interval i5 = new Interval(5,6);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1); list.add(i2); list.add(i3); list.add(i4); list.add(i5);
		Collections.sort(list,Collections.reverseOrder());
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).start+"-"+list.get(i).end);
//		}
		
		//merge logic
		//Iterator<Interval> iter = list.iterator();
		List<Interval> result = new ArrayList<Interval>();
		//result.add(list.get(0));
		int resIdx = 0;
		for(int i=0; i<4; i++){			
			Interval cur = list.get(i);
			if((resIdx != 0) && (list.get(resIdx-1)).start >= cur.end){ //cur.start <= last.end){
				Interval last = list.get(resIdx-1);
				//means overlapping
				//if(cur.end < last.end){
					last.end = Math.max(last.end, cur.end);
					last.start = Math.max(last.start, cur.start);
				//}
			}else{
				list.add(resIdx, cur);
				resIdx++;
				
			}			
		}
		System.out.println("------");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).start+"-"+list.get(i).end);
		}
		
	}

}
