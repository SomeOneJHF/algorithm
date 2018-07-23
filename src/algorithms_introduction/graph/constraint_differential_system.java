package algorithms_introduction.graph;

/*
    约束差分系统
    建模很关键。 x1-x2<w ==> x2->x1 = w 不是x1 -> x2 = w，这样可以用于最短路径来求解约束差分。

    实现有两种方式：一种设置一个初始节点，该节点到所有节点的距离都是0，这样就可以直接使用Bellman-Ford
    算法，但这样会使算法的复杂度有所增加；另一种，将所有节点的处置都设置为0，这样也可以直接使用
    Bellman-Ford算法，会降低算法的复杂度。
 */

import java.util.ArrayList;
import java.util.HashMap;

public class constraint_differential_system {

    public static Integer max_value = 0; //1 << 30;
    public static void main(String[] args){
        ArrayList<bellman_ford_point> points = new ArrayList<bellman_ford_point>();
        init(points);
        bellman_ford.releax(points);
        Boolean flag = bellman_ford.recognize(points);
        if(flag){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            for(bellman_ford_point point : points){
                if(point.getPrePoint() != null){
                    System.out.print(point.getPrePoint().getKey() + "--");
                }
                System.out.println(point.getKey() + ", " + point.getValue());
            }
        }
    }

    public static void init(ArrayList<bellman_ford_point> list){
        HashMap<Character, Integer> edges = new HashMap<Character, Integer>();
        /*
        edges.put('1', 0);
        edges.put('2', 0);
        edges.put('3', 0);
        edges.put('4', 0);
        edges.put('5', 0);
        edges.put('6', 0);
        bellman_ford_point point = new bellman_ford_point('0', edges, 0);
        list.add(point);
        edges.clear();
        */
        edges.put('5', -1);
        bellman_ford_point point = new bellman_ford_point('1', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('1', 1);
        edges.put('4', 2);
        point = new bellman_ford_point('2', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('2', 2);
        edges.put('6', -8);
        point = new bellman_ford_point('3', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('1', -4);
        edges.put('5', 3);
        point = new bellman_ford_point('4', edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('2', 7);
        point = new bellman_ford_point('5',edges, max_value);
        list.add(point);
        edges.clear();
        edges.put('2', 5);
        edges.put('3', 10);
        point = new bellman_ford_point('6',edges, max_value);
        list.add(point);
        edges.clear();
    }
}
