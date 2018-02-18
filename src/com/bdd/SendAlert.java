package com.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class SendAlert {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\bdd\\input.txt"));//(System.in);
		String _item;
		try {
			_item = in.nextLine();
		} catch (Exception e) {
			_item = null;
		}

		Vector<String> input = new Vector<String>();
		Send sendClass = new Send(_item);
		sendClass.setInput(input);
		Thread sendThread = new Thread(sendClass);

		Alert alertClass = new Alert();
		alertClass.setInput(input);
		Thread alertThread = new Thread(alertClass);

		sendThread.start();
		alertThread.start();
	}
}


class Send implements Runnable {
	
	private String threadName;
	
	public Send(String threadName){
		this.threadName = threadName;
	}
	
    private Vector<String> input;

    public Vector<String> getInput() {
        return input;
    }

    public void setInput(Vector<String> input) {
        this.input = input;
    }
    
    public void finalize(){
    	
    }

    public void run() {
        synchronized (input) {
            try {
                input.add("item1");
                System.out.println(threadName + ": Before - size:" + input.size());
                input.wait(); 
                System.out.println(threadName + ": After - size:" + input.size());

            } catch (InterruptedException e) {
            }
        }
    }
}

class Alert implements Runnable {
    private Vector<String> input;

    public Vector<String> getInput() {
        return input;
    }

    public void setInput(Vector<String> input) {
        this.input = input;
    }

    public void run() {
        synchronized (input) {
            try {
                Thread.sleep(3000);
                input.add("item2");
                notify();
            } catch (InterruptedException e) {
            }
        }
    }
}
