package algorithms_introduction.test;

public class int_array_test {

    public static void test(int[] n){
        for(int i = 0; i < 10; i++){
            n[i] = 10;
        }
    }

    public static void main(String[] args){
        /*
        int[] n = new int[10];
        for(int i = 0; i < 10; i++){
            n[i] = -1;
        }
        test(n);
        for(int i = 0; i < 10; i++){
            System.out.print(n[i] + ",");
        }
        */
        int[][] A = {{1, 2},{3, 4}};
        int[][] B = A;
        B[1][1] = 5;
        System.out.println(A[1][1]);
    }
}
