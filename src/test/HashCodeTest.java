package test;


import java.util.HashSet;
import java.lang.Object;

class HashCode {

	private Integer integer ;

	public HashCode(Integer integer){
		this.integer = integer;
	}

	@Override
	public int hashCode(){

		return 1;
	}

	@Override
	public boolean equals(Object obj){

		HashCode code = (HashCode)obj;
		if(integer == code.getInteger()){
			return true;
		}
		return false;
	}

	public Integer getInteger() {
		return integer;
	}
}

class HashCode1{
	private Integer integer;

	public HashCode1(Integer integer){

		this.integer = integer;
	}
}

public class HashCodeTest {

	public static void main(String[] args){


		HashSet<HashCode> set = new HashSet<HashCode>();
		HashSet<HashCode1> set1 = new HashSet<HashCode1>();
		long start, end;

		start = System.currentTimeMillis();
		for(Integer i = 0; i < 100; i++){
			set.add(new HashCode(i));
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

		System.out.println(set.size());
		/*
		start = System.currentTimeMillis();
		for(Integer i = 0; i < 10000; i++){
			set1.add(new HashCode1(i));
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		*/
	}

}
