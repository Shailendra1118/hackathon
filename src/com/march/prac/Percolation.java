package com.march.prac;

import java.io.FileNotFoundException;
import java.util.Random;

public class Percolation {
	private static int gridSize = 0;// = 10;
	private static int row = 0;
	private static int col = 0;
	private static Site arr[][] = null;
	private static int openSites = 0;
	private QuickUnion qu;
	
	private class Site{
		int x;
		int y;
		int val;
		boolean open;
		public Site(int val, int x, int y, boolean open){
			this.val = val;
			this.x = x;
			this.y = y;
			this.open = open;
		}
		
		public String toString(){
			return Integer.toString(this.val);
		}
	}
	
	public Percolation(int n){
		// create n-by-n grid, with all sites blocked
		gridSize = n;
		//System.out.println("percolation constructed initialized.");
		qu = new QuickUnion(gridSize);
		row = n;
		col = n;
		arr =  new Site[row][col];
		
		int seed = 0;
		//int after2 = 1; //alignment hack
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = new Site(++seed, i, j, false);			
				/*if(after2 > 2)
					System.out.print(arr[i][j]+" ");
				else
					System.out.print(arr[i][j]+"  ");
					*/
			}
			//System.out.println();
			//after2++;
		}
	}
	
	public void open(int row, int col){		
		if(! isOpen(row, col)){
			//arr[row][col] = 0;
			Site site = arr[row][col];
			site.open = true;
			openSites++;
			//System.out.println("Opened site with "+row+", "+col+" of value "+site.val);
			
			//check if this open site can be connected to other open site to make a component
			if(withinLimit(row-1, col) && isOpen(row-1, col)){
				//qu.union(arr[row][col], arr[row-1][col]);
				Site a = arr[row][col];
				Site b = arr[row-1][col];
				qu.union(a.val, b.val);
				//System.out.println("open:union: "+a.val+", "+b.val);
			}
			if(withinLimit(row+1, col) && isOpen(row+1, col)){
				Site a = arr[row][col];
				Site b = arr[row+1][col];
				qu.union(a.val, b.val);
				//System.out.println("open:union: "+a.val+", "+b.val);
				//System.out.println("open:union: "+arr[row][col]+", "+arr[row+1][col]);
			}
			if(withinLimit(row, col-1) && isOpen(row, col-1)){
				Site a = arr[row][col];
				Site b = arr[row][col-1];
				qu.union(a.val, b.val);
				//System.out.println("open:union: "+a.val+", "+b.val);
			}
			if(withinLimit(row, col+1) && isOpen(row, col+1)){
				Site a = arr[row][col];
				Site b = arr[row][col+1];
				qu.union(a.val, b.val);
				//System.out.println("open:union: "+a.val+", "+b.val);
			}
			
		}
		else{
			//System.out.println("open: "+row+", "+col+" is already an open site.");
		}
	}
	
	private boolean withinLimit(int row, int col) {
		//System.out.println("checking withing limite: "+row+", "+col);
		if(row >= 0 && row < gridSize && col >= 0 && col < gridSize)
			return true;
		else
			return false;
	}

	private boolean isOpen(int row, int col){
		Site site = arr[row][col];
		return site.open;
		//return arr[row][col] == 0 ? true : false;		
	}
	
	private boolean isFull(int row, int col){
		//if connected to the any open site of top rows
		boolean connected = false;
		Site site = arr[row][col];
		Site topOpenSites[] = getTopOpenSites();
		for (int i = 0; i < topOpenSites.length; i++) {
			if(topOpenSites[i] != null && qu.isConnected(site.val, topOpenSites[i].val)){
				connected = true;
				//System.out.println("isFull: "+site.val+", "+topOpenSites[i].val+" are connected.");
				break;
			}
		}
		return connected;
	}
	
	private Site[] getTopOpenSites() {
		Site topOpenSites[] = new Site[gridSize];
		int counter = 0;
		for (int i = 0; i < col; i++) {
			if(isOpen(0, i)){
				topOpenSites[counter] = arr[0][i]; 
				counter++;
			}
		}
		//System.out.println("top open sites: "+Arrays.toString(topOpenSites));
		return topOpenSites;
	}

	public int numberOfOpenSites(){
		return openSites;		
	}
	
	public boolean percolates(){
		boolean percolate = false;
		for (int i = 0; i < col; i++) {
			if(isOpen(gridSize-1, i) && isFull(gridSize-1, i)){
				percolate = true;
				break;
			}
		}			
		return percolate;
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		//Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\march\\prac\\input.txt"));		
		//int lines = s.nextInt();
		
		Percolation p1 = new Percolation(10);
		//for (int i = 0; i < lines; i++) {
		while(! p1.percolates()){
			//int x = s.nextInt();
			//int y = s.nextInt();
			//p1.open(x, y);
			
			int x = p1.getRandom();
			int y = p1.getRandom();
			p1.open(x, y);
		}
	
		
		System.out.println("isPercolate: "+p1.percolates());
		System.out.println("Total open sites: "+p1.numberOfOpenSites());
		Double th = Double.valueOf(p1.numberOfOpenSites())/Double.valueOf(gridSize*gridSize);
		//double th1 = 7d/10d;
		System.out.println("threashold: "+th);
		//s.close();
	}
	

	private int getRandom(){
		Random rand = new Random();
		int toOpen = rand.nextInt(gridSize);
		//System.out.println("getRandom: "+toOpen);
		return toOpen;
	}
}
