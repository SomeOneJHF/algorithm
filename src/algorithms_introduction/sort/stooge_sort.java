package algorithms_introduction.sort;

/*
    臭皮匠算法：
        是一种低效的递归排序算法，甚至慢于冒泡排序
 */
public class stooge_sort {

    public static void stooge_sort(int[] unsorted, int first_index, int last_index){
        int value;
        int mid_part;
        if(unsorted[first_index] > unsorted[last_index]){
            value = unsorted[first_index];
            unsorted[first_index] = unsorted[last_index];
            unsorted[last_index] = value;
        }
        if(first_index + 1 >= last_index){
            return;
        }
        mid_part = (last_index - first_index + 1) / 3;
        stooge_sort(unsorted, first_index, last_index - mid_part);
        stooge_sort(unsorted, first_index + mid_part, last_index);
        stooge_sort(unsorted, first_index, last_index - mid_part);
    }
    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        stooge_sort(unsorted, 0, length-1);
        for(int index = 0; index < length; index++) {
            System.out.print(unsorted[index] + ",");
        }
    }
}
