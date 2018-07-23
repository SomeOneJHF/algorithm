package algorithms_introduction.pinduoduo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Integer size = line.split(" ").length;
        List<Integer> weights = new ArrayList<>(size);
        for(Integer i = 0; i < size; i++) {
            weights.add(Integer.parseInt(line.split(" ")[i]));
        }

        weights.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        Integer count = 0;
        while (size > 0) {
            if(weights.get(size-3) == 100) {
                size -= 3;
                count++;
            }else {
                break;
            }
        }

        Integer firstIndex;
        Integer lastIndex;
        for(firstIndex = 0, lastIndex = size - 1; firstIndex <= lastIndex;) {
            if(firstIndex !=  lastIndex && weights.get(firstIndex) + weights.get(lastIndex) <= 300){
                firstIndex++;
                lastIndex--;
            }else {
                firstIndex++;
            }
            count++;
        }
        System.out.println(count);
    }
}
