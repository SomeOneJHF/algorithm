package algorithms_introduction.graph;

import java.util.*;

class Edge{
    private Character endPoint1, endPoint2;
    private Integer length;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    private Boolean selected;

    public Character getEndPoint1() {
        return endPoint1;
    }

    public void setEndPoint1(Character endPoint1) {
        this.endPoint1 = endPoint1;
    }

    public Character getEndPoint2() {
        return endPoint2;
    }

    public void setEndPoint2(Character endPoint2) {
        this.endPoint2 = endPoint2;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }


    public Edge(Character endPoint1, Character endPoint2, Integer length){
        this.endPoint1 = endPoint1;
        this.endPoint2 = endPoint2;
        this.length = length;
        this.selected = false;
    }

    public boolean equals(Object obj){
        Edge edge = (Edge)obj;
        return this.getLength() == edge.getLength();
    }
}

class EndPoint{
    Character key;
    Character value;

    public Character getKey() {
        return key;
    }

    public Character getValue() {
        return value;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public EndPoint(Character key){
        this.key = key;
        this.value = key;
    }

    @Override
    public boolean equals(Object obj){
        EndPoint point = (EndPoint)obj;
        return this.key == point.getKey();
    }
}

public class kruskal {

    public static void main(String[] args){

        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<EndPoint> points = new ArrayList<EndPoint>();
        init_edge(edges);
        init_point(points, edges);
        sortEdge(edges);
        kruskal(edges,points);
    }

    public static void kruskal(ArrayList<Edge> edges, ArrayList<EndPoint> points){
        for(Edge edge : edges){
            EndPoint point1 = getEndPoint(points, edge.getEndPoint1());
            EndPoint point2 = getEndPoint(points, edge.getEndPoint2());
            if(point1.getValue() == point2.getValue()){
                continue;
            }else if(point1.getValue() < point2.getValue()){
                updateEndPoint(points, point2.getValue(), point1.getValue());
                edge.setSelected(true);
            }else{
                updateEndPoint(points, point1.getValue(), point2.getValue());
                edge.setSelected(true);
            }
        }
        for(Edge edge : edges){
            if(edge.getSelected()){
                System.out.println(edge.getEndPoint1() + "--" + edge.getEndPoint2() + " : " + edge.getLength());
            }
        }
    }
    public static void init_edge(ArrayList<Edge> edges){
        Edge edge = new Edge('a','b',4);
        edges.add(edge);
        edge = new Edge('a', 'h', 8);
        edges.add(edge);
        edge = new Edge('b','c',8);
        edges.add(edge);
        edge = new Edge('b', 'h',11);
        edges.add(edge);
        edge = new Edge('c','d',7);
        edges.add(edge);
        edge = new Edge('c', 'f',4);
        edges.add(edge);
        edge = new Edge('c','i',2);
        edges.add(edge);
        edge = new Edge('d','e',9);
        edges.add(edge);
        edge = new Edge('d','f',14);
        edges.add(edge);
        edge = new Edge('e','f',10);
        edges.add(edge);
        edge = new Edge('f','g',2);
        edges.add(edge);
        edge = new Edge('g','h',1);
        edges.add(edge);
        edge = new Edge('g','i',6);
        edges.add(edge);
        edge = new Edge('h', 'i',7);
        edges.add(edge);
    }

    public static void init_point(ArrayList<EndPoint> points, ArrayList<Edge> edges){
        for(Edge edge : edges){
            EndPoint point1 = new EndPoint(edge.getEndPoint1());
            if(!points.contains(point1)){
                points.add(point1);
            }
            EndPoint point2 = new EndPoint(edge.getEndPoint2());
            if(!points.contains(point2)){
                points.add(point2);
            }
        }
    }

    public static void sortEdge(ArrayList<Edge> edges){
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getLength() - o2.getLength();
            }
        });
    }

    public static EndPoint getEndPoint(ArrayList<EndPoint> points, Character key){
        EndPoint ret_point = null;
        for(EndPoint point : points){
            if(point.getKey() == key) {
                ret_point = point;
                break;
            }
        }
        return ret_point;
    }

    public static void updateEndPoint(ArrayList<EndPoint> points, Character oldValue, Character newValue){
        for(EndPoint point : points){
            if(point.getValue() == oldValue){
                point.setValue(newValue);
            }
        }
    }
}
