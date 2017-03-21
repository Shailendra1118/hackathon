package com.march.prac.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class GrahamScan {

	public static void main(String[] args) {
		Point2D points[] = {new Point2D(6d,0d), new Point2D(3d,1d), new Point2D(4d,2d), new Point2D(1d,2d),
							new Point2D(2d,3d), new Point2D(5d,3d), new Point2D(5d,5d), new Point2D(1d,5d), 
							new Point2D(3d,6d), new Point2D(6d,6d)};
		
		//System.out.println(Arrays.toString(points));
		mergeSortIt(points, new YComparator());
		//sortIt(points, new YComparator());
		System.out.println(Arrays.toString(points));
		//sortIt(points, new XComparator());
		mergeSortIt(points, points[0].POLAR_ORDER);
		System.out.println(Arrays.toString(points));
		// now we know the p point
		Point2D p = points[0]; // fixed in convex hull
		Stack<Point2D> hull = new Stack<>();
		hull.push(p);
		
		hull.push(points[1]);
		for (int i = 2; i < points.length; i++) {
			Point2D top = hull.pop();
			while(Point2D.ccw(hull.peek(), top, points[i]) <= 0){
				top = hull.pop();
				System.out.println("popped: "+top);
			}
			hull.push(top);
			hull.push(points[i]);
			System.out.println("pushed: "+top+" & "+points[i]);
		}
		
		Iterator<Point2D> iter = hull.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
	
	public static void sortIt(Point2D[] arr, Comparator<Point2D> comp) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(less(arr[j], arr[j-1], comp)){
					exch(arr, j, j-1);
				}
			}
		}
	}
	
	private static boolean less(Point2D a, Point2D b, Comparator<Point2D> comp){
		return comp.compare(a, b) < 0;
	}
	
	private static void exch(Point2D[] arr, int i, int j){
		Point2D temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	
	
	//merge sort logic ahead
	private static void mergeSortIt(Point2D[] arr, Comparator<Point2D> comp) {
		Point2D aux[] = Arrays.copyOf(arr, arr.length);
		sortIt(comp, arr, aux, 0, arr.length-1);
	}

	private static void sortIt(Comparator<Point2D> comp, Point2D[] arr, Point2D[] aux, int lo, int hi) {
		if(lo >= hi)
			return;	
		int mid = (hi-lo)/2+lo;
		sortIt(comp, arr, aux, lo, mid);
		sortIt(comp, arr, aux, mid+1, hi);
		mergeIt(comp, arr, aux, lo, mid, hi);
	}

	// abstract in-place merge
	private static void mergeIt(Comparator<Point2D> comp, Point2D[] arr, Point2D[] aux, int lo, int mid,
			int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		int i = lo; // for first half
		int j = mid+1; // for second half after mid
		for (int k = lo; k <= hi; k++) {
			if(i > mid)
				arr[k] = aux[j++];
			else if(j > hi)
				arr[k] = aux[i++];
			else if(less(aux[j], aux[i], comp))
				arr[k] = aux[j++];
			else
				arr[k] = aux[i++];
		}
		
	}

}


class Point2D{
	Double x;
	Double y;
	
	public Comparator<Point2D> POLAR_ORDER = new PolarOrder();
	
	public Point2D(Double x, Double y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return x+","+y;
	}
	
	private class PolarOrder implements Comparator<Point2D>{
		@Override
		public int compare(Point2D o1, Point2D o2) {
			double dy1 = o1.y - y;
			double dy2 = o2.y - y;
			if(dy1 == 0 && dy2 == 0){
				System.out.println("p o1 o2 are horizontal");
				return 0;
			}
			else if(dy1 >= 0 && dy2 < 0)
				return -1;
			else if(dy2 >= 0 && dy1 < 0)
				return 1;
			else 
				return -ccw(Point2D.this, o1, o2);
		}
		
	}
	
	/*
	 * (y2 - y1)*(x3 - x2) - (y3 - y2)*(x2 - x1)
	 *	Above expression is negative when slopeAB < slopeBC, i.e., counterclockwise
	 *	Above expression is 0 when slopeAB = slopeBC, i.e., co-linear
	 *	Above expression is positive when slopeAB > slopeBC, i.e., clockwise
	 */
	public static int ccw(Point2D a, Point2D b, Point2D c){
		//double slopeAB = (b.y-a.y)/(b.x-a.x);
		//double slopeBC = (c.y-b.y)/(c.x-b.x);
		//System.out.println("slopeAB: "+slopeAB+" slopeBC: "+slopeBC);
		/*if(slopeAB < slopeBC)
			return true;
		else
			return false; */
		double res = (b.y - a.y)*(c.x - b.x) - (c.y - b.y)*(b.x - a.x);
		if(res < 0)
			return 1; // cw
		else if(res > 0)
			return -1;  // ccw
		else 
			return 0; // coliner
				
	}
	
	
}

class XComparator implements Comparator<Point2D>{

	@Override
	public int compare(Point2D o1, Point2D o2) {
		return o1.x.compareTo(o2.x);
	}
	
}

class YComparator implements Comparator<Point2D>{

	@Override
	public int compare(Point2D o1, Point2D o2) {
		return o1.y.compareTo(o2.y);
	}
	
}

