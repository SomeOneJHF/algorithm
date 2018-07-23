package algorithms_introduction.test;


import java.util.Scanner;

public class test1 {

    public static void main(String[] args){

        int t;
        int[] x = new int[4];
        int[] y = new int [4];
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        for(int i =0; i < t; i++){
            for(int j = 0; j < 4; j++){
                x[j] = scanner.nextInt();
            }
            for(int j = 0; j < 4; j++){
                y[j] = scanner.nextInt();
            }

            if(((x[0]-x[1])*(x[0]-x[2]) == -(y[0]-y[1])*(y[0]-y[2])) &&
                    ((x[2]-x[0])*(x[2]-x[3]) == -(y[2]-y[0])*(y[2]-y[3])) &&
                    ((x[3]-x[2])*(x[3]-x[1]) == -(y[3]-y[2])*(y[3]-y[1]))&&
                    (((x[2]-x[0])*(x[2]-x[0])+ (y[2]-y[0])*(y[2]-y[0])) ==((x[3]-x[2])*(x[3]-x[2])+ (y[3]-y[2])*(y[3]-y[2])))){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
