package juc;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


public class NotSafeDemo01 {

    public static void main(String[] args) {

        // ArrayList是线程不安全的，使用Vector，内部add方法，使用了synchronized锁。
        List<String> list = new CopyOnWriteArrayList<String>();//Collections.synchronizedList(new ArrayList());//new Vector<>();//new ArrayList();
//		list.add("a");
//		list.add("b");
//		list.add("c");
//		list.forEach(System.out::println);


        for(int i = 0; i < 30; i ++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }





    }

}
