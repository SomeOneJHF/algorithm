package netease;

import java.util.Scanner;

public class Turn {

	public static void main(String[] args){
		Integer N;
		Scanner scanner = new Scanner(System.in);
		String left = "NWSE";
		String right = "NESW";
		String turn;
		Character direction = 'N';
		N = scanner.nextInt();
		if(N > 0){
			turn = scanner.next();
			if(turn.length() != N) {
				System.out.println("error input");
				return;
			}
			for(Integer index = 0; index < N; index++){
				if(turn.charAt(index) == 'L'){
					direction = left.charAt((left.indexOf(direction) + 1) % 4);
				}else if(turn.charAt(index) == 'R'){
					direction = right.charAt((right.indexOf(direction) + 1) % 4);
				}
			}
			System.out.println(direction);
		}else{
			System.out.println("N");
		}
	}
}
