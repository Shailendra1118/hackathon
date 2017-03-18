package com.march.prac;

import java.util.Random;


public class PercolationStats {	
	
	private double pList[] = null;
	private int nByn = 0;
	public PercolationStats(int n, int trials){ 
	// perform trials independent experiments on an n-by-n grid		
		pList = new double[trials];
		nByn = n;
		for (int i = 0; i < trials; i++) {
			Percolation p1 = new Percolation(n);
			while (!p1.percolates()) {
				int x = getRandom(); //p1.getRandom();
				int y = getRandom();
				p1.open(x, y);
			}

			//System.out.println("PERCOLATES: " + p1.percolates());
			//System.out.println("Total open sites: " + p1.numberOfOpenSites());
			Double th = Double.valueOf(p1.numberOfOpenSites())
					/ Double.valueOf(n * n);
			pList[i] = th;
			//System.out.println("threashold: " + th);
			
		}
	}
	 
	public double mean(){
	// sample mean of percolation threshold same as average
		double sum = 0d;
		for (int j = 0; j < pList.length; j++) {
			sum = sum + j;
		}
		return sum / pList.length;
	}
	   
	public double stddev(){
	//sample standard deviation of percolation threshold
		double numi = 0d;
		double num = 0d;
		for (int j = 0; j < pList.length; j++) {
			numi = Math.pow(pList[j] - mean(), 2);
			num += numi;
		}

		return Math.sqrt(num / pList.length - 1);
	}
	   
	public double confidenceLo(){ // low endpoint of 95% confidence interval
		double cl = 0d;
		cl = mean() - (1.96 * stddev()) / Math.sqrt(pList.length);
		return cl;
	}

	public double confidenceHi(){ // high endpoint of 95% confidence interval
		double ch = 0d;
		ch = mean() + (1.96 * stddev()) / Math.sqrt(pList.length);
		return ch;
	}

	public static void main(String[] args){ // test client (described below)
		int nByN = 2;
		int trials = 10000;
		PercolationStats stats = new PercolationStats(nByN, trials);

		System.out.println("mean: " + stats.mean());
		System.out.println("stddev: " + stats.stddev());
		System.out.println("95% confidence interval: [" + stats.confidenceLo()
				+ ", " + stats.confidenceHi() + "]");
	} 
	
	private int getRandom(){
		Random rand = new Random();
		int toOpen = rand.nextInt(nByn);
		//System.out.println("getRandom: "+toOpen);
		return toOpen;
	}
	
}
