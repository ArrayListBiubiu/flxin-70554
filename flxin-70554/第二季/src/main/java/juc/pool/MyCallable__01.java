package juc.pool;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


/**
 * Callable接口
 * 	1.	FutureTask implements Runnable
 * 	2.	FutureTask(Callable<V> callable)
 * 	3.	FutureTask是Runnable的一个实现类，而且其构造方法需要传入Callable接口
 */
public class MyCallable__01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(1);
        System.out.println(2);
        Integer integer = futureTask.get(); //在get()方法未取到值的时候，会阻塞进程
        System.out.println(integer);
        String s = "hello";
    }

}

class MyThread implements Callable<Integer> {
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return 1024;
    }
}

//FutureTask implements Runnable        FutureTask(Callable<V> callable)