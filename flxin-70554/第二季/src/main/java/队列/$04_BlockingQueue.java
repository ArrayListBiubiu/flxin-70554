package 队列;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 * 阻塞队列
 *
 * Iterable(接口) -> Collection(接口) -> Queue(接口) -> BlockingQueue(接口)
 * 实现类：
 *      （1）ArrayBlockingQueue；（2）LinkedBlockingQueue；（3）SynchronousQueue； 这里重点说这3种实现类，他们在中间件MQ中发挥着重大的作用。
 */

/**
 * 4种不同的入队和出队方法的区别：（4）超时：offer(e, time, unit)  poll(time, unit)
 */
public class $04_BlockingQueue {

    public static void main(String[] args) throws InterruptedException {

        // offer(e, time, unit)：队列满时继续添加元素时，阻塞，超过等待时间，退出阻塞状态
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        queue.offer("a", 2, TimeUnit.SECONDS);
        queue.offer("c", 2, TimeUnit.SECONDS);
        queue.offer("b", 2, TimeUnit.SECONDS);
        queue.offer("d", 2, TimeUnit.SECONDS);  // 运行到这一步开始阻塞，2秒钟之后退出等待状态
        System.out.println("2秒钟之后，退出阻塞状态继续执行。。。");


        // poll(time, unit)：队列空时取出元素时，阻塞，超过等待时间，退出阻塞状态
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(3);
        queue2.offer("e", 2, TimeUnit.SECONDS);
        String element = queue2.poll(2, TimeUnit.SECONDS);
        String element2 = queue2.poll(2, TimeUnit.SECONDS);
        System.out.println("2秒钟之后，退出阻塞状态继续执行。。。" + element);
        System.out.println("2秒钟之后，退出阻塞状态继续执行。。。" + element2);
    }
}

