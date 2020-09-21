package 队列;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue; /**
 * 阻塞队列
 *
 * Iterable(接口) -> Collection(接口) -> Queue(接口) -> BlockingQueue(接口)
 * 实现类：
 *      （1）ArrayBlockingQueue；（2）LinkedBlockingQueue；（3）SynchronousQueue； 这里重点说这3种实现类，他们在中间件MQ中发挥着重大的作用。
 */

/**
 * 4种不同的入队和出队方法的区别：（3）阻塞：put(e)  take()
 */
public class $03_BlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        // put(e)：队列未满时添加，正常，队列满时添加，阻塞
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        queue.put("a");
        queue.put("c");
        queue.put("b");
        queue.put("d");  // 运行到这一步开始阻塞


        // take()：队列中有元素时取出，正常取到元素，队列空时取出元素，阻塞
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(3);
        queue2.put("e");
        String element = queue2.take();
        String element2 = queue2.take();
        System.out.println(element);
        System.out.println(element2);
    }
}

