import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {
        int distance = 0;
        int[][] points = new int[locations.length][2];
        for(int index = 0; index < locations.length; index++) {
            points[index][0] = Integer.parseInt(locations[index].split(",")[0]);
            points[index][1] = Integer.parseInt(locations[index].split(",")[1]);
        }
        int maxX = 0;
        int maxY = 0;
        for(int index = 0; index < locations.length; index++) {
            if(points[index][0] > maxX){
                maxX = points[index][0];
            }
        }
        for(int index = 0; index < locations.length; index++) {
            if(points[index][1] > maxY){
                maxY = points[index][1];
            }
        }
        distance = 2 * (maxX + maxY);
        return distance;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}