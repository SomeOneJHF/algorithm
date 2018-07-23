package algorithms_introduction.dynamic_programming;

public class matrix_chain_order {

    static int max_value = 1 << 30;

    public static void main(String[] args){
        int size = 6;
        int [][] A = {{0, 0}, {30, 35}, {35, 15}, {15, 5}, {5, 10}, {10, 20}, {20, 25}};
        //int[][] A = new int[size+1][2];
        /*
        Scanner scanner = new Scanner(System.in);
        for(int index = 1; index <= size; index++){
            A[index][0] = scanner.nextInt();
            A[index][1] = scanner.nextInt();
        }
        */
        matrix_chain_order(A, size);
        //memoized_matrix_chain(A, size);
    }

    /*
        这个方法比较精巧，首先计算2个矩阵乘法所需的计算量，接着3,4,...,size,后面的计算利用前面得到的结果，
        如果没有赋值，同样不会被利用。

        通过这个算法，动态规划--利用空间换时间的套路，也是穷举，但是省略了重复的计算。
     */
    public static void matrix_chain_order(int[][] A, int size){
        int[][] m = new int[size+1][size+1];
        int[][] s = new int[size+1][size+1];
        int index, jndex, kndex, lndex;
        int max_value = (int)Math.pow(2, 30);
        for(index = 1; index <= size; index++){
            m[index][index] = 0;
        }
        for(lndex = 2; lndex <= size; lndex++){
            for(index = 1; index <= size - lndex + 1; index++){
                jndex = index + lndex - 1;
                m[index][jndex] = max_value;
                for(kndex = index; kndex < jndex; kndex++){
                    int q = m[index][kndex] + m[kndex + 1][jndex] + A[index][0]*A[kndex][1]*A[jndex][1];
                    if(q < m[index][jndex]){
                        m[index][jndex] = q;
                        s[index][jndex] = kndex;
                    }
                }
            }
        }
        for(index = 1; index <= size; index++){
            for(jndex = 1; jndex <= size; jndex++)
                System.out.printf("%5d  ",m[index][jndex]);
            System.out.println("");
        }
        System.out.println("");
        for(index = 1; index <= size; index++){
            for(jndex = 1; jndex <= size; jndex++)
                System.out.printf("%5d  ",s[index][jndex]);
            System.out.println();
        }
    }

    public static void memoized_matrix_chain(int[][] p, int size){

        int[][] m = new int[size + 1][size + 1];
        int index, jndex;
        for(index = 1; index <= size; index++){
            for(jndex = 1; jndex <= size; jndex++){
                m[index][jndex] = max_value;
            }
        }
        lookup_chain(m, p, 1, size);
        for(index = 1; index <= size; index++){
            for(jndex = 1; jndex <= size; jndex++){
                System.out.printf("%10d ",m[index][jndex]);
            }
            System.out.println();
        }
    }

    public static int lookup_chain(int[][] m, int[][] p, int first_index, int last_index){

        if(m[first_index][last_index] < max_value){
            return m[first_index][last_index];
        }
        if(first_index == last_index) {
            return 0;
        }else{
            for(int kndex = first_index; kndex < last_index; kndex++){
                int q = lookup_chain(m, p, first_index, kndex) + lookup_chain(m, p, kndex+1, last_index) + p[first_index][0] * p[kndex][1] * p[last_index][1];
                if(q < m[first_index][last_index]){
                    m[first_index][last_index] = q;
                }
            }
            return m[first_index][last_index];
        }
    }
}
