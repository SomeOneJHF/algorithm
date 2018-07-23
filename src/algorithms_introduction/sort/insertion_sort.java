package algorithms_introduction.sort;

/*
    插入排序
        前面的数据都是已经排好序的，只需将后面的数据插入到合适的位置。
        最优情况：
            数组是已排序的，运行时间为：an+b
        最坏情况：
            数组是逆排序的，运行时间为：an^2+bn+c
        平均情况：

 */

import java.util.Scanner;

public class insertion_sort {

    public static void main(String[] args){
        int size = 10;
        int index, jndex;
        int value;
        int[] unsorted = new int[size];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组:");
        for(index = 0; index < size; index++){
            unsorted[index] = scanner.nextInt();
        }
        for(jndex = 1; jndex < size; jndex++){
            value = unsorted[jndex];
            for(index = jndex - 1; index >= 0 && value < unsorted[index]; index--){
                    unsorted[index + 1] = unsorted[index];
            }
            unsorted[index + 1] = value;
        }
        for(index = 0; index < size; index++){
            System.out.print(unsorted[index] + ", ");
        }
    }
}
