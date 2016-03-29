package com.booking.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class HotelRank {
	static Hotel[] hotels = new Hotel[9];
	static HashMap<Integer, List<Float>> map = new HashMap<>();
	//static HashMap<Integer, Integer> map = new HashMap<>();
	static int TH = 15;
	public static void main(String[] args) {
		populateInput();
		float count = 1;
		float avg = 0;
		List<Float> prevAvg = null;
		for(int i=0; i<hotels.length; i++){
			//int score = 0;
			//List<Integer> scores = null;
			//int count = 1;
			if(map.containsKey(hotels[i].hotel_id)){
				//scores = map.get(hotels[i].hotel_id);
				//scores.add(hotels[i].score);
				prevAvg = map.get(hotels[i].hotel_id);
				count = prevAvg.get(0);
				avg = prevAvg.get(1);
				avg = ((avg*count)+hotels[i].score)/(count+1);
				//int avg = (prevAvg*i)/i+1;
				count++;
				prevAvg.set(0, count);
				prevAvg.set(1, avg);
				map.put(hotels[i].hotel_id, prevAvg);
			}else{
				prevAvg = new ArrayList<Float>();
				//scores.add(hotels[i].score);
				count = 1;
				avg = hotels[i].score;
				prevAvg.add(count);
				prevAvg.add(avg);
				map.put(hotels[i].hotel_id, prevAvg);
			}
			
		}
		
		printScores();
	}
	
	/*
	private static void printScores() {
		Iterator<Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer, List<Integer>> e = iter.next();
			int sum = getSum(e.getValue());
			int avg = sum/e.getValue().size();
			if(avg > TH)
				System.out.println(e.getKey()+" - "+avg);
		}
	}
	*/




	private static void printScores() {
		Iterator<Entry<Integer, List<Float>>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry<Integer, List<Float>> e = iter.next();
			float avg = e.getValue().get(1);
			//if(avg > TH)
				System.out.println(e.getKey()+" - "+avg);
		}
	}

	private static int getSum(List<Integer> value) {
		int sum =0;
		Iterator iter = value.iterator();
		while(iter.hasNext()){
			Integer val = (Integer) iter.next();
			sum = sum + val;
		}
		return sum;
	}


	private static void populateInput() {
		hotels[0] = new Hotel(1,5);
		hotels[1] = new Hotel(2,34);
		hotels[2] = new Hotel(3,6);
		hotels[3] = new Hotel(4,36);
		hotels[4] = new Hotel(2,4);
		hotels[5] = new Hotel(1,3);
		hotels[6] = new Hotel(1,2);
		hotels[7] = new Hotel(2,4);
		hotels[8] = new Hotel(1,4);
	}

}


class Hotel{
	int hotel_id;
	int score;
	
	Hotel(int id, int score){
		this.hotel_id = id;
		this.score = score;
	}
}
