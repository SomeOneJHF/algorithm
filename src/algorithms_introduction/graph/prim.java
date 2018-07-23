package algorithms_introduction.graph;

import java.util.*;

class Point{
    Character key;
    HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
    Integer value;

    public Point(Character key, HashMap<Character, Integer> edges, Integer max_value){
        this.key = key;
        this.value = max_value;
        Iterator iterator = edges.keySet().iterator();
        while(iterator.hasNext()){
            Character neighbor_key = (Character) iterator.next();
            Integer neighbor_value = (Integer) edges.get(neighbor_key);
            this.edges.put(neighbor_key, neighbor_value);
        }
    }

    public Point(Point point){
        this.key = point.key;
        this.value = point.value;
        Iterator iterator = point.edges.keySet().iterator();
        while(iterator.hasNext()){
            Character neighbor_key = (Character) iterator.next();
            Integer neighbor_value = (Integer) point.edges.get(neighbor_key);
            this.edges.put(neighbor_key, neighbor_value);
        }
    }
}

public class prim {

    public static int max_value = 1<<30;
    public static void main(String[] args){
        ArrayList<Point> list = new ArrayList<Point>();
        ArrayList<Point> A = new ArrayList<Point>();
        ArrayList<Point> B = new ArrayList<Point>();
        init(list);
        exchange(list, A);
        prim(A, B);
    }

    public static void init(ArrayList<Point> list){
        HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
        edges.put('b', 4);
        edges.put('h', 8);
        Point a = new Point('a', edges, max_value);
        list.add(a);
        edges.clear();
        edges.put('a', 4);
        edges.put('c', 8);
        edges.put('h', 11);
        Point b = new Point('b', edges, max_value);
        list.add(b);
        edges.clear();
        edges.put('b', 8);
        edges.put('d', 7);
        edges.put('f', 4);
        edges.put('i', 2);
        Point c = new Point('c', edges, max_value);
        list.add(c);
        edges.clear();
        edges.put('c', 7);
        edges.put('e', 9);
        edges.put('f', 14);
        Point d = new Point('d', edges, max_value);
        list.add(d);
        edges.clear();
        edges.put('d', 9);
        edges.put('f', 10);
        Point e = new Point('e', edges, max_value);
        list.add(e);
        edges.clear();
        edges.put('c', 4);
        edges.put('d', 14);
        edges.put('e', 10);
        edges.put('g', 2);
        Point f = new Point('f', edges, max_value);
        list.add(f);
        edges.clear();
        edges.put('f', 2);
        edges.put('h', 1);
        edges.put('i', 6);
        Point g = new Point('g', edges, max_value);
        list.add(g);
        edges.clear();
        edges.put('a', 8);
        edges.put('b', 11);
        edges.put('g', 1);
        edges.put('i', 7);
        Point h = new Point('h', edges, max_value);
        list.add(h);
        edges.clear();
        edges.put('c', 2);
        edges.put('g', 6);
        edges.put('h', 7);
        Point i = new Point('i', edges, max_value);
        list.add(i);
        edges.clear();
    }

    public static void exchange(ArrayList<Point> list, ArrayList<Point> A){
        for(Point point : list){
            A.add(new Point(point));
        }
        for(Point point : A){
            point.value = max_value;
        }
        A.get(0).value = 0;
    }

    public static void prim(ArrayList<Point> A, ArrayList<Point> B){
        sort(A);
        while(A.size() != 0){
            Point point = A.remove(0);
            B.add(new Point(point));
            update(A, point);
            sort(A);
        }
        for(Point point : B){
            System.out.println(point.key.toString() + ' ' + point.value);
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
        Iterator iterator = edges.keySet().iterator();
        while (iterator.hasNext()){
            Character key = (Character) iterator.next();
            Integer value = edges.get(key);
            for(Point neighbor_point : list){
                if(neighbor_point.key == key && value < neighbor_point.value) {
                    neighbor_point.value = value;
                }
            }
        }
    }
}
