package algorithms_introduction.sort;

public class bubble_sort {

    public static void bubble_sort(int[] unsorted, int first_index, int last_index){
        int index, jndex;
        int value;
        for(index = first_index; index <= last_index; index++){
            for(jndex = last_index; jndex > index; jndex--){
                if(unsorted[jndex] < unsorted[jndex-1]){
                    value = unsorted[jndex];
                    unsorted[jndex] = unsorted[jndex-1];
                    unsorted[jndex-1] = value;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        bubble_sort(unsorted, 0, length - 1);
        for(int index = 0; index < length; index++){
            System.out.print(unsorted[index] + ", ");
        }
        System.out.println();
    }
}
