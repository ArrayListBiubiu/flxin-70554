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
 * 4种不同的入队和出队方法的区别：（2）返回布尔值：offer(e)  poll()
 */
public class $02_BlockingQueue {

    public static void main(String[] args) {

        // offer(e)：队列未满时添加，返回true，队列满时添加，返回false
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        boolean b = queue.offer("a");
        boolean b3 = queue.offer("c");
        boolean b2 = queue.offer("b");
        boolean b4 = queue.offer("d");
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);

        // poll()：队列中有元素时取元素，返回该元素，队列空时取元素，返回null
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(3);
        queue2.offer("e");
        String element = queue2.poll();
        String element2 = queue2.poll();
        System.out.println(element);
        System.out.println(element2);
    }
}

