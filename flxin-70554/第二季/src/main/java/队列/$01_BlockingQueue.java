package 队列;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 *
 * Iterable(接口) -> Collection(接口) -> Queue(接口) -> BlockingQueue(接口)
 * 实现类：
 *      （1）ArrayBlockingQueue；（2）LinkedBlockingQueue；（3）SynchronousQueue； 这里重点说这3种实现类，他们在中间件MQ中发挥着重大的作用。
 */

/**
 * 4种不同的入队和出队方法的区别：（1）抛出异常组：add(e)  remove()
 */
public class $01_BlockingQueue {

    public static void main(String[] args) {

        // add(e)：队列满时再次添加，会抛出异常 -> IllegalStateException: Queue full
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");

        // remove()：队列空时取元素，会抛出异常 -> NoSuchElementException
        BlockingQueue<String> queue2 = new ArrayBlockingQueue<String>(3);
        queue2.remove();

        // element()：查看队首元素（即查看队列中是否有元素）
        String element = queue2.element();
        System.out.println(element);

    }
}

