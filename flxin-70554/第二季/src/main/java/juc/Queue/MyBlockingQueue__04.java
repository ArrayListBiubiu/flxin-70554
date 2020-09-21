package juc.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;


/**
 * 超时
 * offer()  poll()
 */
public class MyBlockingQueue__04 {

    public static void main(String[] args) throws Exception {

        //参数是界值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);
        blockingQueue.offer("a",2, TimeUnit.SECONDS);






    }
}
