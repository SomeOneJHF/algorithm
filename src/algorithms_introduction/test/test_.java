package algorithms_introduction.test;

import java.util.*;

public class test_ {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] v=new int[n];
            for(int i=0;i<n;i++) v[i]=sc.nextInt();
            if(n<=2) {
                System.out.println(0);
            }else{
                int[][] dp=new int[n][n];
                dp[0][0]=0-Math.abs(v[1]-v[0]);//这里是为了计算时dp[1][0]=0；
                int[] acc=new int[n];//用来保存dp[i+1][i]的初始值
                for(int i=1;i<n;i++){
                    acc[i]=acc[i-1]+Math.abs(v[i]-v[i-1]);//初始值。。
                    dp[i][i-1]=acc[i-1];
                    for(int j=0;j<i-1;j++){
                        dp[i][j]=dp[i-1][j]+Math.abs(v[i]-v[i-1]);
                        dp[i][i-1]=Math.min(dp[i][i-1],dp[i-1][j]+Math.abs(v[i]-v[j]));
                    }
                }
                int min=Integer.MAX_VALUE;
                for(int j=0;j<n-1;j++){

                    min=Math.min(dp[n-1][j],min);
                }
                System.out.println(min);
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(dp[i][j]);
                    }
                    System.out.println();
                }
            }

        }

    }
}

