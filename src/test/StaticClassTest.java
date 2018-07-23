package test;

class OuterClass{

	private static String string = "hello world";

	public static class InterStaticClass{

		public void display(){

			System.out.println("message from static class " + string);
		}
	}

	public class InterClass{

		public void display(){

			System.out.println("message from class " + string);
		}
	}
}
public class StaticClassTest {

	public static void main(String[] args) {

		OuterClass.InterStaticClass staticClass = new OuterClass.InterStaticClass();
		staticClass.display();

		OuterClass outerClass = new OuterClass();
		OuterClass.InterClass interClass = outerClass.new InterClass();
		interClass.display();


	}
}
