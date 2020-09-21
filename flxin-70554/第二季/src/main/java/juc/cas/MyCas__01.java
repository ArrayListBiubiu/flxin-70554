package juc.cas;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么？
 *      compare and swap、比较并交换
 */
public class MyCas__01 {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(10);

        /**
         * 当真实值与期望值相同时，进行修改
         */
        atomicInteger.compareAndSet(10, 20);

        System.out.println(atomicInteger);

    }
}
