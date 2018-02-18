package com.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeadLock {
	public static void main(String[] args) throws FileNotFoundException {

		class Animal {
			private final String name;

			public Animal(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}

			public synchronized void bite(Animal bitter) {
				System.out.format("%s: %s has bitten me!%n", this.name,
						bitter.getName());
				bitter.runAway(this);
			}

			public synchronized void runAway(Animal bitter) {
				System.out.format("%s: %s has run away! I am still hungry %n",
						this.name, bitter.getName());
			}
		}

		Scanner in = new Scanner(new File(
				"D:\\Keppler\\Hackerrank\\src\\com\\bdd\\input.txt"));// (System.in);//(System.in);
		String _name1;
		String _name2;
		try {
			_name1 = in.nextLine();
			_name2 = in.nextLine();
		} catch (Exception e) {
			_name1 = null;
			_name2 = null;
		}

		final Animal wolf = new Animal(_name1);
		final Animal fox = new Animal(_name2);

		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				wolf.bite(fox);
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				fox.bite(wolf);

			}
		});
		//TODO
		thread1.start();
		thread2.start();
		
		in.close();
	}

}
