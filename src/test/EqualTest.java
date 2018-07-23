package test;

public class EqualTest {

	public static void main(String[] args){

		String str1 = new String("xyz");
		String str2 = new String("xyz");

		if(str1  == str2) {
			System.out.println("str1 == str2");
		}else{
			System.out.println("str1 !== str2");
		}

		if(str1.equals(str2)){
			System.out.println("str1 equals str2");
		}else{
			System.out.println("str1 not equals str2");
		}
	}
}
