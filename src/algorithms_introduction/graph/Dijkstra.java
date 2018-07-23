package algorithms_introduction.graph;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class Dijkstra {

    public static Integer max_value = 1 << 30;

    public static void main(String[] args){
        ArrayList<Point> points = new ArrayList<Point>();
        init(points);
        dinjkstra(points);
    }

    public static void dinjkstra(ArrayList<Point> A){

        ArrayList<Point> B = new ArrayList<Point>();
        while(A.size() > 0){
            Point point = A.remove(0);
            B.add(point);
            update(A, point);
            sort(A);
        }
        for(Point point : B){
            System.out.println(point.key + ", " + point.value);
        }
    }

    public static void sort(ArrayList<Point> list){

        list.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });
    }
    public static void update(ArrayList<Point> list, Point point){

        HashMap<Character, Integer> edges = point.edges;
        Integer value = point.value;
        Iterator iterator = edges.keySet().iterator();
        while(iterator.hasNext()){
            Character postKey = (Character)iterator.next();
            Integer postValue = edges.get(postKey);
            Point postPoint = getPoint(list, postKey);
            if(postPoint != null && value + postValue < postPoint.value){
                postPoint.value = value + postValue;
            }
        }
    }

    public static Point getPoint(ArrayList<Point> list, Character key){
        Point retPoint = null;
        for(Point point : list){
            if(point.key == key)
                retPoint = point;
        }
        return retPoint;
    }

    public static void init(ArrayList<Point> list){
        HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
        edges.put('t', 10);
        edges.put('y', 5);
        Point s = new Point('s', edges, 0);
        list.add(s);
        edges.clear();
        edges.put('x', 1);
        edges.put('y', 2);
        Point t = new Point('t', edges, max_value);
        list.add(t);
        edges.clear();
        edges.put('z', 4);
        Point x = new Point('x', edges, max_value);
        list.add(x);
        edges.clear();
        edges.put('t', 3);
        edges.put('x', 9);
        edges.put('z', 2);
        Point y = new Point('y', edges, max_value);
        list.add(y);
        edges.clear();
        edges.put('s', 7);
        edges.put('x', 6);
        Point z = new Point('z', edges, max_value);
        list.add(z);
        edges.clear();
    }
}
