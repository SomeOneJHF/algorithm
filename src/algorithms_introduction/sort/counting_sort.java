package algorithms_introduction.sort;

public class counting_sort {

    public static int[] counting_sort(int[] unsorted, int first_index, int last_index){
        int max_num = 10;
        int index;
        int[] count = new int[10];
        int length = unsorted.length;
        int[] sorted = new int[length];

        for(index = 0; index < max_num; index++){
                count[index] = 0;
        }
        for(index = first_index; index <= last_index; index++ ){
            count[unsorted[index]]++;
        }
        for(index = 1;index < max_num; index++){
            count[index] = count[index] + count[index-1];
        }
        for(index = first_index; index <= last_index; index++){
            sorted[count[unsorted[index]]-1] = unsorted[index];
            count[unsorted[index]]--;
        }
        return sorted;
    }

    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        int[] sort = counting_sort(unsorted, 0, length-1);
        for(int index = 0; index < length; index++) {
            System.out.print(sort[index] + ",");
        }
    }
}
