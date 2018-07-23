package netease;

import java.util.Scanner;

public class AlarmClock {

	public static void main(String[] args){

		Integer size = 100;
		Integer N;
		Integer[][] clock = new Integer[size][2];
		Integer X;
		Integer[] classTime = new Integer[2];
		Integer[] lastClock = new Integer[2];
		lastClock[0] = -1;
		lastClock[1] = -1;
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		if(N > 0 && N <= 100){
			for(Integer index = 0; index < N; index++){
				clock[index][0] = scanner.nextInt();
				clock[index][1] = scanner.nextInt();
			}
			X = scanner.nextInt();
			classTime[0] = scanner.nextInt();
			classTime[1] = scanner.nextInt();
			Integer lastClassTime = classTime[0] * 60 + classTime[1];
			for(Integer index = 0; index <N; index++){
				Integer inClassTime = clock[index][0] * 60 + clock[index][1];
				if(inClassTime + X <= lastClassTime && inClassTime > lastClock[0] * 60 + lastClock[1] ){
					lastClock[0] = clock[index][0];
					lastClock[1] = clock[index][1];
				}
			}
			System.out.println(lastClock[0] + " " + lastClock[1]);
		}
	}
}
