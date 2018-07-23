package algorithms_introduction.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Point{
    int freq;
    char c;
    Point left, right;

    public Point(char c, int freq){
        this.c = c;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public Point(int freq){
        this.c = ' ';
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    public void set_left(Point point){
        this.left = point;
    }

    public void set_right(Point point){
        this.right = point;
    }
}

public class huffman_code {

    public static void main(String[] args){

        ArrayList<Point> list = new ArrayList<Point>();
        init(list);
        haffman_tree(list);
    }

    public static void init(ArrayList<Point> list){
        list.add(new Point('f', 5));
        list.add(new Point('e', 9));
        list.add(new Point('c', 12));
        list.add(new Point('b', 13));
        list.add(new Point('d', 16));
        list.add(new Point('a', 45));
        Collections.sort(list, new Comparator<Point>() {
            public int compare(Point x, Point y){
                return x.freq - y.freq;
            }
        });
    }

    public static void haffman_tree(ArrayList<Point> list){
        while(list.size() > 1){
            Point x = list.remove(0);
            Point y = list.remove(0);
            Point z = new Point(x.freq + y.freq);
            z.set_left(x);
            z.set_right(y);
            list.add(z);
            Collections.sort(list, new Comparator<Point>() {
                public int compare(Point x, Point y){
                    return x.freq - y.freq;
                }
            });
        }
        Point root = list.remove(0);
        String str = "";
        output_result(root, str);
    }
    public static void output_result(Point root, String str){
        if(root.c != ' '){
            System.out.println(root.c + " : " + str);
        }
        if(root.left != null){
            output_result(root.left, str + "0");
        }
        if(root.right != null){
            output_result(root.right, str + "1");
        }
    }
}
