package netease;

import java.util.Scanner;

public class Number {

	public static void main(String[] args){

		Integer n, k;
		Integer count = 0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		if(k >= 0 && n > k){
			for(Integer y = k + 1; y <= n; y++){
				int d = y - k;
				for(Integer x = k; x <= n; x+=y){
					count += Math.min(d, n - x + 1);
				}
			}
			System.out.println(count);
		}
	}
}
