package netease;

import java.util.Scanner;

public class Shine {

	public static void main(String[] args){
		Integer t ;
		Integer n;
		String s;
		Scanner scanner = new Scanner(System.in);
		t = scanner.nextInt();
		if(t > 0){
			for(Integer index = 0; index < t; index++){
				n = scanner.nextInt();
				Integer count = 0;
				if(n > 0){
					s = scanner.next();
					for(Integer jndex = 0; jndex < n; jndex++){
						if(s.charAt(jndex) == '.'){
							count++;
							jndex += 2;
						}
					}
					System.out.println(count);
				}
			}
		}
	}
}
