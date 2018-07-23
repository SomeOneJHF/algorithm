package algorithms_introduction.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class steep_strip_cutting {
    /*
    cut_rod函数反复重复计算，导致运算量很高。
     */
    public static int cut_rod(Map<Integer, Integer> map, int n){
        if(n == 0){
            return 0;
        }else {
            int q = -1;
            for(int i = 1; i <= map.size() && i <= n; i++){
                //System.out.println( cut_rod(map, n-i));
                int mid_q = map.get(i) + cut_rod(map, n-i);
                if(q < mid_q){
                    q = mid_q;
                }
            }
            return q;
        }
    }
    /*
    带备忘的自顶向下的实现方法
     */
    public static int memorized_cut_rod(Map<Integer, Integer>map ,int n){
        int[] r = new int[n+1];
        for(int i = 0; i <= n; i++){
            r[i] = -1;
        }
        int result_q = memorized_cut_rod_aux(map, n, r);
        for(int i = 0; i <= n; i++){
            System.out.print(r[i] + ", ");
        }
        System.out.println();
        return result_q;
    }

    public static int memorized_cut_rod_aux(Map<Integer, Integer> map, int n, int[] r){
        int q = -1;
        if(r[n] >= 0){
            return r[n];
        }
        if(n == 0){
            return 0;
        }else{
            for(int i = 1; i <= n; i++){
                int sub_q = memorized_cut_rod_aux(map, n - i, r);
                if(q < map.get(i) + sub_q) {
                    q = map.get(i) + sub_q;
                }
            }
        }
        r[n] = q;
        return q;
    }

    /*
    自底向上的实现方法
    这个算法实现的特别精巧，主要是r数组赋值时，只赋值了索引0的元素，虽然没有赋值其它的元素，但是在循环里
    只用到了赋值之后的元素，因为循环中用到的元素均为[0, index-jndex]。
     */
    public static int button_up_cut_rod(Map<Integer, Integer>map, int n){
        int[] r = new int[n+1];
        r[0] = 0;
        for(int index = 1; index <= n; index++){
            int q = -1;
            for(int jndex = 1; jndex <= index; jndex++){
                if(q < map.get(jndex) + r[index - jndex]){
                    q = map.get(jndex) + r[index - jndex];
                }
            }
            r[index] = q;
        }
        return r[n];
    }

    public static void extended_button_up_cut_rod(Map<Integer, Integer> map, int n){
        int[] r = new int[n+1];
        int[] s = new int[n+1];
        r[0] = 0;
        for(int index = 1; index <= n; index++){
            int q = -1;
            for(int jndex = 1; jndex <= index; jndex++){
                if(q < r[index - jndex] + map.get(jndex)){
                    q = r[index - jndex] + map.get(jndex);
                    s[index] = jndex;
                }
            }
            r[index] = q;
        }
        for(int index = 1; index <= n; index++){
            System.out.print(s[index] + ", ");
        }
    }

    public static void init_map(Map<Integer, Integer> map){
        map.put(1, 1);
        map.put(2, 5);
        map.put(3, 8);
        map.put(4, 9);
        map.put(5, 10);
        map.put(6, 17);
        map.put(7, 17);
        map.put(8, 20);
        map.put(9, 24);
        map.put(10,30);
    }
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        init_map(map);
        int n = 10;
        int size = 40;
        //int q = cut_rod(map, n);
        //int q = memorized_cut_rod(map, n);
        //int q = button_up_cut_rod(map, n);
        //System.out.println(q);
        extended_button_up_cut_rod(map, n);
    }
}
