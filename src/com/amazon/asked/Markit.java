package com.amazon.asked;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Markit implements Serializable{
	
	private static final long serialVersionUID = 1L;
	int data = 100;
	String line = "Hello I am Markit";

	Markit(){
		System.out.println("Markit");
	}
	
	private void readObject(ObjectInputStream input) throws ClassNotFoundException, IOException{
		input.defaultReadObject();
		//String line = (String) input.readObject();
		//System.out.println("Got string object "+line);
		//int data = input.readInt();
		//System.out.println("Got data "+data);
		
	}
	

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
    	stream.defaultWriteObject();
        //stream.writeObject(line);
        //stream.writeInt(data);
    }
    
    private Object readResolve() throws ObjectStreamException {
    	System.out.println("In readResolve");
    	Markit m = new Markit();
    	m.data = 200;
    	m.line = "Bye bye";
    	return m;
    }
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		
		Markit mar = new Markit();
		
		File file = new File("D:\\Keppler\\Hackerrank\\src\\com\\amazon\\asked\\test.txt");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(mar);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}finally{
			fos.close();
			oos.close();
		}
		
		//reading it from file
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream
					(new File("D:\\Keppler\\Hackerrank\\src\\com\\amazon\\asked\\test.txt")));
		
		Markit obj = (Markit) ois.readObject();
		System.out.println("Found while deserialing "+obj.data+" "+obj.line);
	}
}
