package netease;

import java.util.Scanner;

public class Snack {

	public static void main(String[] args){
		Long n, w;
		Long count = 0L;
		Long[] v = new Long[30];
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextLong();
		w = scanner.nextLong();
		if(n > 0 && n < 31 && w > 0){
			for(Integer index = 0; index < n; index++){
				v[index] = scanner.nextLong();
			}
			Integer max_value = 1 << n;
			for(Integer index = 0; index < max_value; index++){
				Long sum_v = 0L;
				Integer plan = index;
				Integer jndex = 0;
				while(plan != 0){
					if(plan % 2 == 1){
						sum_v += v[jndex];
					}
					jndex++;
					plan /= 2;
				}
				if(sum_v <= w)
					count++;
			}
			System.out.println(count);
		}
	}
}
