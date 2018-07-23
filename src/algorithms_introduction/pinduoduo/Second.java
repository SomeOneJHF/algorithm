package algorithms_introduction.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Second {

    public static void main(String[] args) {
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        List<String> ticket = new ArrayList<String>(M);
        for (int i = 0; i < M; i++) {
            ticket.add(scanner.next());
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }
        int[][] compare = new int[N][N];
        for(int i = 0; i < N; i++)
            compare[i][i] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int countI = 0;
                int countJ = 0;
                for (int k = 0; k < M; k++) {
                    if (ticket.get(k).charAt(i) < ticket.get(k).charAt(j)) {
                        countI++;
                    } else if (ticket.get(k).charAt(i) > ticket.get(k).charAt(j)) {
                        countJ++;
                    }
                }
                if (countI > countJ) {
                    compare[i][j] = 1;
                    compare[j][i] = -1;
                }else if(countI < countJ) {
                    compare[i][j] = -1;
                    compare[j][i] = 1;
                }else {
                    compare[i][j] = compare[j][i] = 0;
                }
            }
        }
        int star = -1;
        for(int i = 0; i < N; i++){
            int j;
            for(j = 0; j < N; j++) {
                if(compare[i][j] != 1) {
                    break;
                }
            }
            if(j == N){
                star = i;
                break;
            }
        }
        System.out.println(star);
    }

}
