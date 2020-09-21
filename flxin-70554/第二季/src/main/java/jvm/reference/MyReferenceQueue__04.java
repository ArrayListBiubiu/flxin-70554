package jvm.reference;


import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


/**
 * 虚引用
 */
public class MyReferenceQueue__04 {

    public static void main(String[] args) throws InterruptedException {

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);

        System.out.println(o1);
        System.out.println(referenceQueue.poll());
        System.out.println(weakReference.get());

        System.out.println("==========");
        o1 = null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }

}
