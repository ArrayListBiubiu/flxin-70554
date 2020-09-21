package juc.volatil;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证volatile没有原子性
 * 在有volatile修饰的number，在多线程的操作下不能保证原子性，出现写值覆盖的情况，number值小于20000
 *
 * 不保证原子性，出现写值覆盖的原因：
 * addNumber++反编译底层源码为： 1.getfiled 获取number值
 *                              2.add       +1
 *                              3.putfiled  重新赋值
 * 但是由于不能保证原子性，多个线程number++已经全部启动，可见性已经不起作用，出现多次写值覆盖的情况，只有一次有效
 *
 * 解决方式：
 *      1.在addNumber方法上家synchronized锁，（杀鸡不用牛刀）
 *      2.使用juc下的AtomicInteger，天生就是不可分割，不会出现写覆盖的情况
 *
 */
public class MyVolatile__02 {

    public static void main(String[] args) {

        MyData myData = new MyData();

        for(int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addNumber();
                    myData.addAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }

        //等待上面所有线程结束任务，线程数>2时，强制main线程交出时间片
        while (Thread.activeCount() > 2) {

        }

        System.out.println("number:" + myData.number);
        System.out.println("atomicInteger:" + myData.atomicInteger);

    }
}


class MyData {

    volatile int number = 0;
    public void addNumber() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomicInteger() {
        atomicInteger.getAndIncrement();
    }

}
