package algorithms_introduction.dynamic_programming;

public class LCS {

    public static void lcs_length(String X, String Y){
        int m = X.length();
        int n = Y.length();
        int[][] b = new int[m+1][n+1];
        int[][] c = new int[m+1][n+1];
        int index, jndex;
        for(index = 0; index <= m; index++){
            c[index][0] = 0;
        }
        for(jndex = 0; jndex <= n; jndex++){
            c[0][jndex] = 0;
        }
        for(index = 1; index <= m; index++){
            for(jndex = 1; jndex <= n; jndex++){
                if(X.charAt(index) == Y.charAt(jndex)){
                    c[index][jndex] = c[index - 1][jndex - 1] + 1;
                    b[index][jndex] = 0;
                }else if (c[index][jndex - 1] > c[index - 1][jndex]){
                    c[index][jndex] = c[index][jndex - 1];
                    b[index][jndex] = -1;
                }else{
                    c[index][jndex] = c[index - 1][jndex];
                    b[index][jndex] = 1;
                }
            }
        }

    }

    public static void main(String[] args){

    }
}
