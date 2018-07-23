package offer;

public class MinNumberInRotateArray {

	public static int minNumberInRotateArray(int[] array){

		if(array == null)
			return 0;
		if(array.length == 0)
			return 0;
		int lastIndex, firstIndex, midIndex;
		lastIndex = array.length - 1;
		firstIndex = 0;
		midIndex = 0;
		while(array[firstIndex] >= array[lastIndex]){
			if(lastIndex - firstIndex == 1){
				midIndex = lastIndex;
				break;
			}
			midIndex = (firstIndex + lastIndex) / 2;
			if(array[firstIndex] == array[lastIndex] && array[firstIndex] == array[midIndex]){
				int result = array[firstIndex];
				for(Integer index = firstIndex + 1; index <= lastIndex; index++){
					if(result < array[index])
						result = array[index];
				}
				return result;
			}
			if(array[midIndex] >= array[firstIndex])
				firstIndex = midIndex;
			else
				lastIndex = midIndex;
		}
		return array[midIndex];
	}

	public static void main(String[] args){
		int[] array = {5,6, 7, 8,9, 1,2, 3, 4};
		System.out.println(minNumberInRotateArray(array));
	}
}
