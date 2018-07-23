package netease;

import java.util.Map;
import java.util.Scanner;

public class MaxOverlop {

	public static void main(String[] args){

		Integer n;
		Integer[][] x = new Integer[50][2];
		Integer[][] y = new Integer[50][2];
		Integer minx = -(1<<30);
		Integer maxx = 1<<30;
		Integer miny = -(1<<30);
		Integer maxy = 1<<30;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		if(n > 1 && n < 51){
			for(Integer index = 0; index < n; index++){
				x[index][0] = scanner.nextInt();
				y[index][0] = scanner.nextInt();

			}
		}
	}
}
