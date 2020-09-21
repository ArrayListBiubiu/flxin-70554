package jvm.reference;


import java.util.WeakHashMap;


/**
 * 基于弱引用引申的新的问题
 * 	WeakHashMap，继承于AbstractMap，实现了Map接口
 */
public class MyWeakHashMap__03 {

    public static void main(String[] args) {

        WeakHashMap map = new WeakHashMap();
        Integer key = new Integer(1);
        String value = "一";


        map.put(key, value);
        System.out.println(map);

        key = 2;
        System.gc();
        System.out.println(map);

    }
}
