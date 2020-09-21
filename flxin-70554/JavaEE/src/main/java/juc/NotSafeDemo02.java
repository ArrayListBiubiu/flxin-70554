package juc;


import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * java.util.ConcurrentModificationException
 *
 */
public class NotSafeDemo02 {

    public static void main(String[] args) {

        Set<String> set = new CopyOnWriteArraySet<String>();//new HashSet<String>();

        for(int i = 0; i < 30; i ++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

    }

}