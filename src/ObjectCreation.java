import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ObjectCreation {

	public static void main(String[] args) {
		Parser p = new Parser();
		System.out.println("p "+p);
		
		@SuppressWarnings("unchecked")
		Constructor<Parser> [] cons = (Constructor<Parser>[]) Parser.class.getConstructors();
		Constructor<Parser> con = cons[0];
		try {
			Parser p1 = con.newInstance();
			System.out.println("p1 "+p1);
			ClassLoader cl = Parser.class.getClassLoader();
			System.out.println("cl for parser p1 "+cl);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			Class<?> pc = ClassLoader.getSystemClassLoader().loadClass("Parser");
			try {
				Parser p2 = (Parser) pc.newInstance();
				System.out.println("p2 "+p2);
				System.out.println("cl for parser "+p2.getClass().getClassLoader());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			Parser p3 = Parser.class.newInstance();
			System.out.println("p3 "+p3);
			System.out.println("cl for parser p3 "+p3.getClass().getClassLoader());
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}
	

}
