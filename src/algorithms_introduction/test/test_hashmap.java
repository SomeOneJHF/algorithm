package algorithms_introduction.test;

import java.util.HashMap;
import java.util.Iterator;

public class test_hashmap {

    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = (Integer)iterator.next();
            Integer value = map.get(key);
            System.out.println("key : " + key + ",  value : " + value);
        }
        map.clear();
        System.out.println(map.size());
        iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = (Integer)iterator.next();
            Integer value = map.get(key);
            System.out.println("key : " + key + ",  value : " + value);
        }
    }
}
