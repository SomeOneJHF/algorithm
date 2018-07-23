package algorithms_introduction.pinduoduo;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        int N;
        int gen;
        Scanner scanner = new Scanner(System.in);
        int x;
        while (true) {
            N = scanner.nextInt();
            gen = (int) (Math.log(N + 4) / Math.log(2));
            if (Math.pow(2, gen) == (N + 4)) {
                gen--;
            }
            System.out.println(gen);
            System.out.println(((N + 4) - Math.pow(2, gen)));
            System.out.println((int) ((N + 4) - Math.pow(2, gen)) / Math.pow(2, gen - 2));
            x = (int) (((N + 4) - Math.pow(2, gen)) / Math.pow(2, gen - 2));
            if (x *   Math.pow(2, gen - 2) < ((N + 4) - Math.pow(2, gen)))
                x++;
            System.out.println(x);
            switch (x) {
                case 0:
                    System.out.println("Dave");
                    break;
                case 1:
                    System.out.println("Alice");
                    break;
                case 2:
                    System.out.println("Bob");
                    break;
                case 3:
                    System.out.println("Cathy");
                    break;
                case 4:
                    System.out.println("Dave");
                    break;
            }

        }
    }
}
