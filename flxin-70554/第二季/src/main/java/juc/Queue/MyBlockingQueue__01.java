package juc.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * 抛出异常组：
 * add() element() remove()
 */
public class MyBlockingQueue__01 {

    public static void main(String[] args) {

        //参数是界值
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //往阻塞队列添加元素
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("b"));

        //获取队首元素
        System.out.println(blockingQueue.element());

        //从阻塞队列取元素，先进先出
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


        System.out.println(blockingQueue.element());
    }
}
