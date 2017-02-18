package com.xpanxion.asked;

import com.xpanxion.asked.ClassNClass.TwoClass.ThreeClass;

public class ClassNClass {

	public static void main(String[] args) {
		ClassNClass a = new ClassNClass();
		OneClass one = new ClassNClass().new OneClass();
		ThreeClass three = a.new TwoClass().new ThreeClass();
		
	}
	
	class OneClass{
		public OneClass(){
			System.out.println("OneClass constructor");
		}
		
		public void display(String ip){
			System.out.println("dispaly "+ip);
		}
	}
	
	class TwoClass extends AnotherClass{
		public TwoClass(){
			System.out.println("TwoClass constructor");
		}
		
		public void display(String ip){
			System.out.println("dispaly "+ip);
		}
		
		class ThreeClass extends AnotherClass{
			public ThreeClass(){
				System.out.println("ThreeClass constructor");
			}
			
			public void display(String ip){
				System.out.println("dispaly "+ip);
			}
		}
	}

}
