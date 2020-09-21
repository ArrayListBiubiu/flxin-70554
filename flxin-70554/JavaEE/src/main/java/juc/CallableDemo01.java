package juc;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class CallableDemo01 {


    public static void main(String[] args) throws Exception {

        //FutureTask implements Runnable，构造方法需要传入参数Callable类。
        FutureTask futureTask = new FutureTask(new MyCallable());


        // 线程一
        new Thread(futureTask ,"A").start();

        Integer result = (Integer) futureTask.get();

        System.out.println(result);


        // 线程二
        new Thread(new MyRunnable(),"B").start();

    }

}

class MyCallable implements Callable{
    public String call() throws Exception{
        return "MyCallable";
    }
}
class MyRunnable implements Runnable{
    public void run() {
        System.out.println("MyRunnable");
    }
}

