package algorithms_introduction.sort;
/*
    选择排序
        首次选择最小（大）的数据与第一个数据交换，第二次选择次小（大）的数据与第二个数据交换，一次类推，排序length-1次
        运算情况和插入排序相同。
 */
import java.util.Scanner;

public class selection_sort {

    public static void main(String[] args){
        int size = 10;
        int index, jndex;
        int[] unsorted = new int[10];
        int min, min_index;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据：");
        for(index = 0; index < size; index++){
            unsorted[index] = scanner.nextInt();
        }
        for(index = 0; index < size -1; index++){
            min = unsorted[index];
            min_index = index;
            for(jndex = index+1; jndex < size; jndex++){
                if(min > unsorted[jndex]){
                    min = unsorted[jndex];
                    min_index = jndex;
                }
            }
            unsorted[min_index] = unsorted[index];
            unsorted[index] = min;
        }
        for(index = 0; index < size; index++){
            System.out.print(unsorted[index] + ", ");
        }
    }
}
