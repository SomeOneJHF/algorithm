package algorithms_introduction.graph;

public class FloydWarshall {

    public static int size = 5;
    public static int max_value = 1 << 29;

    public static void main(String[] args){

        int[][] edges = {{0, 3, 8, max_value, -4},
                {max_value, 0, max_value, 1, 7},
                {max_value, 4, 0, max_value, max_value},
                {2, max_value, -5, 0, max_value},
                {max_value, max_value, max_value, 6, 0},
        };
        floydwarshall(edges);
    }

    public static void floydwarshall(int[][] edges){
        int[][] L = new int[size][size];
        for(int index = 0; index < size; index++){
            for(int jndex = 0; jndex < size; jndex++){
                L[index][jndex] = edges[index][jndex];
            }
        }
        for(int kndex = 0; kndex < size; kndex++){
            int[][] LL = new int[size][size];
            for(int index = 0; index < size; index++){
                for(int jndex = 0; jndex < size; jndex++){
                    if(L[index][jndex] < L[index][kndex] + L[kndex][jndex]){
                        LL[index][jndex] = L[index][jndex];
                    }else{
                        LL[index][jndex] = L[index][kndex] + L[kndex][jndex];
                    }
                }
            }
            for(int index = 0; index < size; index++){
                for(int jndex = 0; jndex < size; jndex++){
                    L[index][jndex] = LL[index][jndex];
                }
            }
        }
        for(int index = 0; index < size; index++){
            for(int jndex = 0; jndex < size; jndex++){
                System.out.print(L[index][jndex] + ", ");
            }
            System.out.println();
        }
    }
}
