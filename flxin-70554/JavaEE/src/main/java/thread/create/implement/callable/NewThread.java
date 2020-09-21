package thread.create.implement.callable;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 创建线程的第三种方法
 *      FutureTask 是 Runnable 接口的实现类，而 FutureTask 构造方法需要传入参数 Callable
 */
public class NewThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new MyCallable());
        Thread t = new Thread(futureTask);
        t.start();

        Object o = futureTask.get();
        System.out.println(o);

    }

}
