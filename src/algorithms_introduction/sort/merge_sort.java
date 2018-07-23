package algorithms_introduction.sort;

/*
    归并排序
        分为两个函数：
            merge_sort
                将序列按2的指数进行分割，由于/具有取地板的原因，只要first_index<last_index，说明序列中不止
                两个元素，这时，需要对序列再次进行切割，然后再将排序的元素进行缝合。递归切割的终结是数组中有
                一个或者0个元素。
            merge
                因为unsorted元素中[first_index, mid_index],[mid_index+1, last_index]已经排序，所以需要
                只需将每次取较小元素，重新填充到unsorted数组中，数组即为有序的了。同时要注意，最后可能没有
                填充完毕就退出循环了，因为循环的标志是前半段或后半段其中之一没有可以数据可以填充。

                注：这里的unsorted的第一个索引是first_index不是0
                    要有最后的循环判断。
 */

public class merge_sort {

    public static void merge(int[] unsorted, int first_index, int mid_index, int last_index){
        int left_size = mid_index - first_index + 1;
        int right_size = last_index - mid_index;
        int[] left_sorted = new int[left_size];
        int[] right_sorted = new int[right_size];
        int index, left_index, right_index;
        for(left_index = 0; left_index < left_size; left_index++){
            left_sorted[left_index] = unsorted[first_index + left_index];
        }
        for(right_index = 0; right_index < right_size; right_index++){
            right_sorted[right_index] = unsorted[mid_index + right_index + 1];
        }
        for(index = first_index, left_index = 0, right_index = 0; left_index < left_size && right_index < right_size; index++){
            if(left_sorted[left_index] < right_sorted[right_index]){
                unsorted[index] = left_sorted[left_index++];
            }else{
                unsorted[index] = right_sorted[right_index++];
            }
        }
        while (left_index < left_size){
            unsorted[index++] = left_sorted[left_index++];
        }
        while(right_index < right_size){
            unsorted[index++] = right_sorted[right_index++];
        }
    }
    public static void merge_sort(int[] unsorted, int first_index, int last_index){
        int mid_index;
        if(first_index < last_index){
            mid_index = (first_index + last_index) / 2;
            merge_sort(unsorted, first_index, mid_index);
            merge_sort(unsorted,mid_index + 1, last_index);
            merge(unsorted, first_index, mid_index, last_index);
            for(int index = first_index; index <= last_index; index++){
                System.out.print(unsorted[index] + ",");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        System.out.println(length);
        merge_sort(unsorted, 0 , length-1);
        for(int index = 0; index < length; index++){
            System.out.print(unsorted[index] + ",");
        }
    }
}
