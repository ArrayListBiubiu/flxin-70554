package juc.arraylist;

import java.util.HashSet;


/**
 * HashSet底层结构是什么？
 * HashSet的add()方法，只需要一个参数
 */
public class MyHashSet__02 {

    public static void main(String[] args) {


        /**
         *public HashSet() {
         *         map = new HashMap<>();
         *     }
         */
        HashSet set = new HashSet();


        /**
         *public boolean add(E e) {
         *         return map.put(e, PRESENT)==null;
         *     }
         */
        set.add("hello");

    }
}
