package algorithms_introduction.sort;

/*
    快排算法：
        这个partition有点意思，我还见过另外一种实现方式，不过没有这个精简。
        那个实现方式是最初版本，即T. Hoare提出的初始版本，在算法导论中有涉及。
 */
public class quick_sort {

    public static int partition(int[] unsorted, int first_index, int last_index){
        int index, jndex = first_index - 1;
        int value;
        for(index = first_index; index < last_index; index++){
            if(unsorted[index] < unsorted[last_index]){
                jndex++;
                value = unsorted[index];
                unsorted[index] = unsorted[jndex];
                unsorted[jndex] = value;
            }
        }
        value = unsorted[jndex+1];
        unsorted[jndex+1] = unsorted[last_index];
        unsorted[last_index] = value;
        return jndex + 1;
    }

    public static void quick_sort(int[] unsorted, int first_index, int last_index){
        if(first_index < last_index){
            int mid_index = partition(unsorted, first_index, last_index);
            quick_sort(unsorted, first_index, mid_index-1);
            quick_sort(unsorted, mid_index+1, last_index);
        }
    }

    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        quick_sort(unsorted, 0, length-1);
        for(int index = 0; index < length; index++){
        System.out.print(unsorted[index] + ",");
    }
}
}
