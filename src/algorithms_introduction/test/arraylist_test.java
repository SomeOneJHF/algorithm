package algorithms_introduction.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;

class Point{
    Integer key;
    Integer value;

    public Point(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }

    public Point(Point p){
        this.key = p.key;
        this.value = p.value;
    }
}

public class arraylist_test {

    public static void main(String[] args){
        ArrayList<Point> list = new ArrayList<Point>();
        LinkedList<Point> linklist = new LinkedList();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        list.add(new Point(1, 10));
        list.add(new Point(2, 20));
        list.add(new Point(3, 30));
        list.add(new Point(4, 40));
        ArrayList<Point> A = list;//new ArrayList<Point>();
        /*for(Point point : list){
            A.add(new Point(point));
        }*/

        for(Point point : A){
            point.value = 50;
        }

        for(Point point : list){
            System.out.println(point.key + ", " + point.value);
        }

        for(Point point : A){
            System.out.println(point.key + ", " + point.value);
        }
    }
}
