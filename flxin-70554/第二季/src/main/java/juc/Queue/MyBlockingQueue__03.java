package juc.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * 阻塞
 * put(e)   take()      不可用
 */
public class MyBlockingQueue__03 {

    public static void main(String[] args) throws Exception {

        //参数是界值
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");

        System.out.println(1);
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        System.out.println(2);
        blockingQueue.take();

        System.out.println("-----");
    }
}
