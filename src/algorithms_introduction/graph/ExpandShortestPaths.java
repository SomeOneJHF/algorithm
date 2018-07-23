package algorithms_introduction.graph;

public class ExpandShortestPaths {

    public static int size = 5;
    public static int max_value = 1 << 28;

    public static void main(String[] args){

        int[][] edges = {{0, 3, 8, max_value, -4},
                        {max_value, 0, max_value, 1, 7},
                        {max_value, 4, 0, max_value, max_value},
                        {2, max_value, -5, 0, max_value},
                        {max_value, max_value, max_value, 6, 0},
                        };
        int[][] L = new int[size][size];
        for(int index = 0; index < size; index++){
            for(int jndex = 0; jndex < size; jndex++){
                L[index][jndex] = edges[index][jndex];
            }
        }
        for(int index = 1; index < size; index = index * 2){
            L = extendShortestPaths(L, L);
            for(int kndex = 0; kndex < size; kndex++){
                for(int jndex = 0; jndex < size; jndex++){
                    System.out.print(L[kndex][jndex] + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
        /*
        for(int index = 0; index < size - 2; index++){
            L = extendShortestPaths(L, edges);
            for(int kndex = 0; kndex < size; kndex++){
                for(int jndex = 0; jndex < size; jndex++){
                    System.out.print(L[kndex][jndex] + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
        */

    }

    public static int[][] extendShortestPaths(int[][] L, int[][] W){

        int[][] LL = new int[size][size];
        for(int index = 0; index < size; index++){
            for(int jndex = 0; jndex < size; jndex++){
                LL[index][jndex] = max_value;
                for(int kndex = 0; kndex < size; kndex++){
                    if(LL[index][jndex] > L[index][kndex] + W[kndex][jndex]){
                        LL[index][jndex] = L[index][kndex] + W[kndex][jndex];
                    }
                }
            }
        }
        return LL;
    }
}
