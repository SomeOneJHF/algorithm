package netease;

import java.util.Scanner;

public class Divisible {

	public static void main(String[] args){

		Long l, r;
		Scanner scanner = new Scanner(System.in);
		l = scanner.nextLong();
		r = scanner.nextLong();
		Long count = 0L;
		if(l >=1 && r > l){
			while(l < r && l % 3 != 1) {
				count++;
				l++;
			}
			while(l < r && r % 3 != 1){
				count++;
				r--;
			}
			if(l < r)
				count += (r - l)/3 * 2;
			System.out.println(count);
		}
	}
}
