package algorithms_introduction.sort;

/*
    堆排序算法：
        分为三个步骤：
            首先，对整个堆构造最大堆，然后迭代（每次迭代都要将堆的大小减一），每次将index=0的元素
            与现有堆元素中最后一个元素交换，在进行最大堆的维护，最后将结果输出。
            构造最大堆实质上是对index=[0,length/2-1]节点进行堆维护的过程。//证明规则参考算法导论。
            堆的维护是一个递归的过程，递归的边界是一个节点的左右子节点（如果有的话）都比该节点小。

        注：堆的维护是一个递归过程
            迭代时一定要将堆的大小减一
            堆分为：最大堆和最小堆，此处为最大堆

 */

public class heap_sort {

    public static void max_heapify(int[] unsorted, int index, int length){
        int left_index = index * 2 + 1;
        int right_index = index * 2 + 2;
        int largest_index = index;
        int value;
        if(left_index < length && unsorted[index] < unsorted[left_index]) {
            largest_index = left_index;
        }
        if(right_index < length && unsorted[largest_index] < unsorted[right_index]){
            largest_index = right_index;
        }
        if(largest_index != index){
            value = unsorted[index];
            unsorted[index] = unsorted[largest_index];
            unsorted[largest_index] = value;
            max_heapify(unsorted, largest_index, length);
        }
    }

    public static void build_max_heap(int[] unsorted, int length){
        int mid_index = length / 2 - 1;
        int index;
        for(index = mid_index; index >= 0; index--){
            max_heapify(unsorted, index, length);
        }
    }

    public static void heap_sort(int[] unsorted){
        int length = unsorted.length;
        int index;
        int value;
        build_max_heap(unsorted, length);
        for(index = length -1; index > 0; index--){
            value = unsorted[index];
            unsorted[index] = unsorted[0];
            unsorted[0] = value;
            max_heapify(unsorted, 0, index);
        }
    }

    public static void main(String[] args){
        int[] unsorted = {1,4,6,3,5,7,5,3,7,4};
        int length = unsorted.length;
        heap_sort(unsorted);
        for(int index = 0; index < length; index++){
            System.out.print(unsorted[index] + ", ");
        }
        System.out.println();
    }
}
