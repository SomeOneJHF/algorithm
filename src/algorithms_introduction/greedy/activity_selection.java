package algorithms_introduction.greedy;

/*
    贪心算法：
        问题的复杂度小于动态规划的复杂度，因此注意问题的建模。
        主要原因感觉：贪心算法中有很多排序
 */
public class activity_selection {

    public static void main(String[] args){

        int[][] A = {{0, 0}, {1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 9},
                {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 14}, {12, 16}};
        int size = 11;
        //greedy(A, 0, size);
        greedy_activity_selector(A, 0, size);
    }

    public static void greedy(int[][] A, int k, int size){
        int m = k + 1;
        while(m <= size && A[k][1] > A[m][0]){
            m++;
        }
        if(m <= size){
            System.out.println(m);
            greedy(A, m, size);
        }
    }

    public static void greedy_activity_selector(int[][] A, int k, int size){
        int m = k + 1;
        while(m <= size){
            if(A[k][1] < A[m][0]){
                System.out.println(m);
                k = m;
            }
            m++;
        }
    }
}
