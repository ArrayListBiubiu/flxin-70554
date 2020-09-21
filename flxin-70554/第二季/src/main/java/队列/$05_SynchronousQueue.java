package 队列;


/**
 * 阻塞队列
 *
 * Iterable(接口) -> Collection(接口) -> Queue(接口) -> BlockingQueue(接口)
 * 实现类：
 *      （1）ArrayBlockingQueue；（2）LinkedBlockingQueue；（3）SynchronousQueue； 这里重点说这3种实现类，他们在中间件MQ中发挥着重大的作用。
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 单个元素的阻塞队列 SynchronousQueue ，队列中最多一个元素，只要不消费掉，不允许继续插入
 */
public class $05_SynchronousQueue {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue = new SynchronousQueue<String>();

        // 线程A连续向队列中插入3个元素，但是由于该队列是"SynchronousQueue"，必须要等待线程B消费掉一个元素才能继续插入，并再次等待线程B消费
        new Thread(() -> {
            try {
                queue.put("a");
                System.out.println(Thread.currentThread().getName() + "向队列中插入了一个元素。。。");
                queue.put("b");
                System.out.println(Thread.currentThread().getName() + "向队列中插入了一个元素。。。");
                queue.put("c");
                System.out.println(Thread.currentThread().getName() + "向队列中插入了一个元素。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                queue.take();
                TimeUnit.SECONDS.sleep(3);
                queue.take();
                TimeUnit.SECONDS.sleep(3);
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();


    }
}

