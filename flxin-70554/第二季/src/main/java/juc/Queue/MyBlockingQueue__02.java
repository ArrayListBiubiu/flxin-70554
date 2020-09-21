package juc.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * 特殊值
 * offer(e)  poll(e)	peek()
 */
public class MyBlockingQueue__02 {

    public static void main(String[] args) {

        //参数是界值
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //往阻塞队列添加元素
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("c"));


        //获取队首元素
        System.out.println(blockingQueue.peek());

        //从阻塞队列取元素，先进先出
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.peek());

    }
}
