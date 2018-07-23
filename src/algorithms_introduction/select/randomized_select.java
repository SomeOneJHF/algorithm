package algorithms_introduction.select;

public class randomized_select {

    public static int partition(int[] unsorted, int first_index, int last_index){
        //System.out.println(first_index + ", " + last_index);
        int index = first_index - 1;
        int jndex;
        int value;
        for(jndex = first_index; jndex < last_index; jndex++){
            if(unsorted[jndex] < unsorted[last_index]){
                index++;
                value = unsorted[jndex];
                unsorted[jndex] = unsorted[index];
                unsorted[index] = value;
            }
        }
        value = unsorted[index + 1];
        unsorted[index + 1] = unsorted[last_index];
        unsorted[last_index] = value;
        return index + 1;
    }

    public static int randomized_select(int[] unsorted, int first_index, int last_index, int min_index){
        if(first_index == last_index)
            return unsorted[first_index];
        //System.out.println(first_index + ", " + last_index + ", " + min_index);
        int mid_index = partition(unsorted, first_index, last_index);
        if(mid_index - first_index + 1 == min_index)
            return unsorted[mid_index];
        else if(mid_index - first_index + 1 < min_index)
            return randomized_select(unsorted, mid_index + 1, last_index, min_index - mid_index + first_index - 1);
        else
            return randomized_select(unsorted, first_index, mid_index - 1, min_index );
    }

    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        int min_i = 3;
        int value = randomized_select(unsorted, 0, length - 1, min_i);
        System.out.println(value);
    }
}
