package com.morgan.asked;

public class MyClass {

	public static void main(String[] args) {
		Parent c = new Child();
		//Parent.disp();
		try{
			Parent.disp();
		}catch(MyException ex){
			//if(ex.getClass().equals(MyException.class))
					System.out.println("Found our exception!!");
			ex.printStackTrace();
		}
	}

}



class Parent{
	public static void disp() throws MyException{
		System.out.println(Parent.class.getName());
		throw new MyException("Temporary availability");
	}
}

class Child extends Parent{
	public static void disp(){
		System.out.println(Child.class.getName());
	}
}
