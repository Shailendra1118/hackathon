package com.sapient.test;

class ThreadExp {

	public static void main(String[] args) {
		Doable d = new Doable();
		d.doIt();
		byte b = 1;
		b += 1;
		System.out.println(b);
		
		Hello h = new Hi();
		h.sayIt();
	}

}


interface IDoable{
	public void doIt();
}


class Doable implements IDoable{
	public void doIt(){
		
	}
}

class Hello{
	public static void sayIt(){
		System.out.println("statically say");
	}
}

class Hi extends Hello{
	//public void sayIt() throws ClassCastException{ //compiler error - cant override static method
	//	System.out.println("concrete say");
	//}
	
}