package algorithms_introduction.sort;

public class merge_insertion_sort {

    public static void insertion_sort(int[] unsorted, int first_index, int last_index){
        int value;
        int index, jndex;
        for(index = first_index + 1; index <= last_index; index++){
            value = unsorted[index];
            for(jndex = index-1; jndex >= first_index && unsorted[jndex] > value; jndex--){
                unsorted[jndex+1] = unsorted[jndex];
            }
            unsorted[jndex+1] = value;
        }
    }
    public static void merge(int[] sorted, int first_index, int mid_index, int last_index){
        int index, left_index, right_index;
        int left_size = mid_index - first_index + 1;
        int right_size = last_index - mid_index;
        int[] left_sorted = new int[left_size];
        int[] right_sorted = new int[right_size];
        for(left_index = 0; left_index < left_size; left_index++){
            left_sorted[left_index] = sorted[first_index+left_index];
        }
        for(right_index = 0; right_index < right_size; right_index++){
            right_sorted[right_index] = sorted[mid_index + right_index + 1];
        }
        for(index = first_index, left_index = 0, right_index = 0; left_index < left_size && right_index < right_size; index++){
            if(left_sorted[left_index] < right_sorted[right_index]){
                sorted[index] = left_sorted[left_index++];
            }else{
                sorted[index] = right_sorted[right_index++];
            }
        }
        while(left_index < left_size){
            sorted[index++] = left_sorted[left_index++];
        }
        while(right_index < right_size){
            sorted[index++] = right_sorted[right_index++];
        }
    }
    public static void merge_sort(int[] unsorted, int first_index, int last_index){
        int critical_length = 3;
        int mid_index;
        if(last_index - first_index < critical_length){
            insertion_sort(unsorted, first_index, last_index);
        }else{
            mid_index = (first_index + last_index) / 2;
            merge_sort(unsorted, first_index, mid_index);
            merge_sort(unsorted, mid_index+1, last_index);
            merge(unsorted, first_index, mid_index, last_index);
            for(int index = first_index; index <= last_index; index++){
                System.out.print(unsorted[index] + ", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        merge_sort(unsorted, 0, length - 1);
        for(int index = 0; index < length; index++){
            System.out.print(unsorted[index] + ", ");
        }
        System.out.println();
    }
}
