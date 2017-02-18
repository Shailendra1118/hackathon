package com.hackerrank.warmup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendCircle {

	public static void main(String[] args) {
		
		String [][] arr1 = {{"Y","Y","N","N"},
						   {"Y","Y","Y","N"},
						   {"N","Y","Y","N"},
						   {"N","N","N","Y"}};
		
		String [][] arr = {{"Y","N","N","N","N"},
						   {"N","Y","N","N","N"},
						   {"N","N","Y","N","N"},
						   {"N","N","N","Y","N"},
						   {"N","N","N","N","Y"},};
	
		
		int row = 5;
		int col = 5;
		List<Pair> frnds = new ArrayList<>();
		Pair set = null;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				//System.out.println(arr[i][j]);
				if(arr[i][j].equals("Y")){
					set = new Pair(i,j);
					if(!frnds.contains(set))
						frnds.add(set);
				}
				
			}
			//System.out.println();
		}
		
		
		Iterator<Pair> iter = frnds.iterator();
		Pair prev = null;
		int grpBegin = 0;
		int grpEnd = 0;
		int counter = 0;
		while(iter.hasNext()){
			Pair curr = iter.next();
			System.out.println(curr);
			if(prev == null) //first case
				prev = curr;
			else{
				if((prev.second == curr.first) ){  //merge
					if(grpBegin == 0)
						grpBegin = prev.first;
					prev = curr;
					continue;
				}else{
					//break here
					grpEnd = prev.second;
					counter++;
					System.out.println("circle found :("+grpBegin+","+grpEnd+")");
					grpBegin = curr.first;
					grpEnd = curr.second;
					prev = curr;
				}
			}
		}
		//last case handled
		counter++;
		System.out.println("last group found :("+grpBegin+","+grpEnd+")");
		
		System.out.println("Total circle :"+counter);
		
		
		
		
		
		
		
		
		
	}
	
	private static class Pair{
		
		public Pair(int first, int second){
			this.first = first;
			this.second = second;
			
		}
		
		private int first = 0;
		private int second = 0;
		
		public String toString(){
			return "("+first+","+second+")";
			
		}
		
		public boolean equals(Object o){
			if(this == o)
				return true;
			if(o == null)
				return false;			
			if(o instanceof Pair){
				Pair other = (Pair) o;
				return ( 
						 ((other.first == this.first) && (other.second == this.second)) ||
						 ((other.first == this.second) && (other.second == this.first))
					   );
			}
			else
				return false;
		}
	}
	

}
