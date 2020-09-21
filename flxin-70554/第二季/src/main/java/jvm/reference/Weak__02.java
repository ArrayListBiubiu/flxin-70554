package jvm.reference;


import java.lang.ref.WeakReference;


/**
 * 弱引用：无论内存空间是否充足，在发生垃圾回收时，一定会回收该对象所占空的内存空间
 */
public class Weak__02 {

    public static void main(String[] args) {

        String str = new String("abc");
        WeakReference weakReference = new WeakReference(str);

        str = "def";
        System.gc();

        System.out.println(str);
        System.out.println(weakReference.get());

    }

}
