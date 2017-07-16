package com.hackerrank.dp;

public class TowerHanoi {

	public static void main(String[] args) {
		int height = 3;
		moveTower(height, "A", "B", "C");		

	}

	private static void moveTower(int height, String fromPole, String toPole, String withPole) {
		if(height >=1){
			moveTower(height-1, fromPole, withPole, toPole);
			moveDisk(height, fromPole, toPole);
			moveTower(height-1, withPole, toPole, fromPole);
		}
	}

	private static void moveDisk(int i, String fromPole, String toPole) {
		System.out.println("Moving disk "+i+" from "+fromPole+" to "+toPole);
		
	}

}
