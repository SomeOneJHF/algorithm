package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuffer;
import java.lang.StringBuilder;
import java.util.HashMap;


public class ForeachTest {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		LinkedList<String> linkedList = new LinkedList<String>();

		for(Integer i = 0; i < 100000; i++){
			arrayList.add(i.toString());
			linkedList.add(i.toString());
		}

		long start = 0;
		long end = 0;
		String array;

		start = System.currentTimeMillis();
		for(Integer i = 0; i < arrayList.size(); i++){
			array = arrayList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("用for循环arrayList 100万次花费时间 : " + (end - start));


		start = System.currentTimeMillis();
		for(String i : arrayList){
			array = i;
		}
		end = System.currentTimeMillis();
		System.out.println("用foreach循环arrayList 100万次花费时间 : " + (end - start));



		start = System.currentTimeMillis();
		for(String i : linkedList){
			array = i;
		}
		end = System.currentTimeMillis();
		System.out.println("用foreach循环linkedList 100万次花费时间 ：" + (end - start));

		start = System.currentTimeMillis();
		for(Integer i = 0; i < linkedList.size(); i++){
			array = linkedList.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("用for循环linkedList 100万次花费时间 ：" + (end - start));

	}
}
