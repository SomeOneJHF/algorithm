package netease;

import java.util.*;

public class FindWork {

	public static void main(String[] args){

		Long M, N;
		HashMap<Long, Long> work = new HashMap<Long, Long>();
		ArrayList<Long> ability = new ArrayList<Long>();
		Scanner scanner = new Scanner(System.in);
		M = scanner.nextLong();
		N = scanner.nextLong();
		if(M > 0 && N > 0){
			for(int index = 0; index < M; index++) {
				Long difficult = scanner.nextLong();
				Long pay = scanner.nextLong();
				work.put(difficult, pay);
			}
			for(int index = 0; index < N; index++) {
				Long ai = scanner.nextLong();
				ability.add(ai);
			}
			for(int index = 0; index < N; index++){
				Long payout = -1L;
				Iterator iterator = work.keySet().iterator();
				while(iterator.hasNext()){
					Long difficult = (Long) iterator.next();
					if(difficult <= ability.get(index) && work.get(difficult) > payout)
						payout = work.get(difficult);
				}
				System.out.println(payout);
			}

		}
	}
}
