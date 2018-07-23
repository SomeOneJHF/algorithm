package algorithms_introduction.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class dag_shortest_path {

    public static int max_value = 1 << 30;
    public static void main(String[] args){

        ArrayList<bellman_ford_point> points = new ArrayList<bellman_ford_point>();
        init(points);
        dag_shortest_path(points);
        output(points);
    }

    public static void output(ArrayList<bellman_ford_point> list){

        for(bellman_ford_point point : list){
            if(point.getPrePoint() != null){
                System.out.print(point.getPrePoint().getKey() + "--");
            }
            System.out.println(point.getKey() + ", " + point.getValue());
        }
    }

    public static void dag_shortest_path(ArrayList<bellman_ford_point> list){

        for(int index = 0; index < list.size(); index++){
            bellman_ford_point point = list.get(index);
            HashMap<Character, Integer> edges = point.getEdges();
            Integer value = point.getValue();
            Iterator iterator = edges.keySet().iterator();
            while(iterator.hasNext()){
                Character postKey = (Character)iterator.next();
                Integer postValue = edges.get(postKey);
                bellman_ford_point postPoint = bellman_ford.getPoint(list, postKey);
                if(value + postValue < postPoint.getValue()){
                    postPoint.setValue(value + postValue);
                    postPoint.setPrePoint(point);
                }
            }
        }
    }

    public static void init(ArrayList<bellman_ford_point> list){

        HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
        edges.put('t', 2);
        edges.put('x', 6);
        bellman_ford_point point = new bellman_ford_point('s', edges, 0);
        list.add(point);
        edges.clear();
        edges.put('x', 7);
        edges.put('y', 4);
        edges.put('z', 2);
        point = new bellman_ford_point('t', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('y', -1);
        edges.put('z', 1);
        point = new bellman_ford_point('x', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('z', -2);
        point = new bellman_ford_point('y', edges, max_value);
        list.add(point);
        edges.clear();
        point = new bellman_ford_point('z', edges, max_value);
        list.add(point);
    }
}
