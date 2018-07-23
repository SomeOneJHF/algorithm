package test;

import java.util.ArrayList;
import java.util.Arrays;

public class SlipArrayTest {

	public static void main(String[] args) {

		int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};

		int[] newData;

		newData = Arrays.copyOfRange(data, 2, 5);
		for(int i : newData)
			System.out.println(i);
	}
}
