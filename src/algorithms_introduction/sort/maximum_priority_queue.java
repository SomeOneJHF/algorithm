package algorithms_introduction.sort;

public class maximum_priority_queue {

    static int max_size = 10;
    static int size = 10;
    static int[] queue = new int[max_size];

    public static void max_heapify(int index){
        int left_index = index * 2 + 1;
        int right_index = index * 2 + 2;
        int largest_index = index;
        int value;
        if(left_index < size && queue[index] < queue[left_index]){
            largest_index = left_index;
        }
        if(right_index < size && queue[largest_index] < queue[right_index]){
            largest_index = right_index;
        }
        if(largest_index != index){
            value = queue[index];
            queue[index] = queue[largest_index];
            queue[largest_index] = value;
            max_heapify(largest_index);
        }
    }

    public static int heap_maximum(){
        if(size == 0) {
            System.out.println("no value");
            return -1;
        } else {
            return queue[0];
        }
    }

    public static int heap_extract_max(){
        if(size == 0) {
            System.out.println("no value");
            return -1;
        } else {
            int max = queue[0];
            queue[0] = queue[size - 1];
            queue[size - 1] = max;
            size--;
            max_heapify(0);
            return max;
        }
    }

    public static void heap_increase_key(int index, int value){
        if(value < queue[index]){
            System.out.println("error value");
        }else{
            queue[index] = value;
            int parent_index = (index - 1)/2;
            while(parent_index >= 0 && queue[index] > queue[parent_index]){
                int swap_value = queue[index];
                queue[index] = queue[parent_index];
                queue[parent_index] = swap_value;
                index = parent_index;
                parent_index = (index - 1)/2;
            }
        }
    }

    public static void max_heap_insert(int value){
        if(size == max_size){
            System.out.println("the queue is full");
        }else{
            queue[size++] = value;
            heap_increase_key(size-1, value);
        }
    }
}
