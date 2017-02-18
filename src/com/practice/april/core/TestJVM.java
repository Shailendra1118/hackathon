package com.practice.april.core;

import java.net.URL;
import java.net.URLClassLoader;

public class TestJVM {

	public static void main(String[] args) {
		
		 ClassLoader cl = ClassLoader.getSystemClassLoader();
		 System.out.println(cl);
	        URL[] urls = ((URLClassLoader)cl).getURLs();

	        for(URL url: urls){
	        	System.out.println(url.getFile());
	        }

	}

}
