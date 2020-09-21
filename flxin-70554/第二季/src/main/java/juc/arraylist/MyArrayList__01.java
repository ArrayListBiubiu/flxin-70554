package juc.arraylist;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全之并发修改异常
 * java.util.ConcurrentModificationException
 *
 * 并发情况下出现异常原因：
 *      当一个线程正在添加元素时，但还未结束，另一个线程获得时间，开始执行，造成添加数据紊乱
 */
public class MyArrayList__01 {

    public static void main(String[] args) throws InterruptedException {

        List list = new ArrayList();

        //解决方案一：Vector的实现类在add()方法上加有synchronized锁，保证线程安全，但是不能保证并发性
        List list2 = new Vector();

        //解决方案二：利用Collections集合工具类
        List list3 = Collections.synchronizedList(new ArrayList<>());

        //解决方案三：利用实现类CopyOnWriteArrayList，写时复制
        List list4 = new CopyOnWriteArrayList();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },  String.valueOf(i)).start();
        }

    }
}
