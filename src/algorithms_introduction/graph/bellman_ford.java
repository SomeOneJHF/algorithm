package algorithms_introduction.graph;

/*
    Bellman-Ford算法，针对无向图、有向图求取开始节点到所有节点的最短路径。
    主要是针对无向图，有向图可以利用拓扑排序求取，更为简单。
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class bellman_ford_point{
    private Character key;
    private HashMap<Character, Integer> edges;
    private bellman_ford_point prePoint;
    private Integer value;

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public HashMap<Character, Integer> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Character, Integer> edges) {

        this.edges = new HashMap<Character, Integer>();
        Iterator iterator = edges.keySet().iterator();
        while(iterator.hasNext()){
            Character neighbor_key = (Character) iterator.next();
            Integer neighbor_value = edges.get(neighbor_key);
            this.edges.put(neighbor_key, neighbor_value);
        }
    }

    public bellman_ford_point getPrePoint() {
        return prePoint;
    }

    public void setPrePoint(bellman_ford_point prePoint) {
        this.prePoint = prePoint;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public bellman_ford_point(Character key, HashMap<Character, Integer> edges, Integer value){

        setKey(key);
        setEdges(edges);
        setPrePoint(null);
        setValue(value);
    }

    public bellman_ford_point(bellman_ford_point point){

        setKey(point.getKey());
        setEdges(point.getEdges());
        setPrePoint(point.getPrePoint());
        setValue(point.getValue());
    }
}
public class bellman_ford {

    static Integer max_value = 1 << 30;

    public static void main(String[] args){

        ArrayList<bellman_ford_point> list = new ArrayList<bellman_ford_point>();
        Boolean flag = true;
        init(list);
        releax(list);
        flag = recognize(list);
        if(flag){
            System.out.println("the bellman ford has not negative loop path");
        }
        for(bellman_ford_point point : list){
            if(point.getPrePoint() != null){
                System.out.print(point.getPrePoint().getKey() + "--");
            }
            System.out.println(point.getKey() + ", " + point.getValue());
        }
    }

    public static Boolean recognize(ArrayList<bellman_ford_point> list){

        Boolean flag = true;

        for(int index = 0; index < list.size(); index++){
            bellman_ford_point point = list.get(index);
            Integer value = point.getValue();
            HashMap<Character, Integer> edges = point.getEdges();
            Iterator iterator = edges.keySet().iterator();
            while (iterator.hasNext()){
                Character postKey = (Character) iterator.next();
                Integer postValue = edges.get(postKey);
                bellman_ford_point postPoint = getPoint(list, postKey);
                if(value < postValue + postPoint.getValue()){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        return flag;
    }

    public static void releax(ArrayList<bellman_ford_point> list){

        for(int index = 0; index < list.size() - 1; index++){
            for(int jndex = 0; jndex < list.size(); jndex++){
                bellman_ford_point point = list.get(jndex);
                HashMap<Character, Integer> edges = point.getEdges();
                Character key = point.getKey();
                Integer value = point.getValue();
                Iterator iterator = edges.keySet().iterator();
                while (iterator.hasNext()){
                    Character postKey = (Character) iterator.next();
                    Integer postValue = edges.get(postKey);
                    bellman_ford_point postPoint = getPoint(list, postKey);
                    if(postPoint.getValue() > value + postValue){
                        postPoint.setValue(value + postValue);
                        postPoint.setPrePoint(point);
                    }
                }
            }
        }
    }

    public static bellman_ford_point getPoint(ArrayList<bellman_ford_point> list, Character key){

        bellman_ford_point point = null;
        for(bellman_ford_point item : list){
            if(item.getKey() == key){
                point = item;
            }
        }
        return point;
    }

    public static void init(ArrayList<bellman_ford_point> list){

        HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
        edges.put('t', 6);
        edges.put('y', 7);
        bellman_ford_point point = new bellman_ford_point('s', edges, 0);
        list.add(point);
        edges.clear();
        edges.put('x', 5);
        edges.put('y', 8);
        edges.put('z', -4);
        point = new bellman_ford_point('t', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('t', -2);
        point = new bellman_ford_point('x', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('x', -3);
        edges.put('z', 9);
        point = new bellman_ford_point('y', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('s', 2);
        edges.put('x', 7);
        point = new bellman_ford_point('z',edges, max_value);
        list.add(point);
        edges.clear();
    }
}
