package jvm;

import java.util.Random;

public class MyGC {

    public static void main(String[] args) {

        // 1. 实际开发，最大内存和默认内存要保持相同，防止虚拟机堆内存忽高忽低，产生不必要的异常。

        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("最大堆内存空间" + maxMemory/1024 + "KB");
        System.out.println("出厂默认堆内存空间" + totalMemory/1024 + "KB");


        /**
         * java.lang.OutOfMemoryError: Java heap space。
         */
        String str = "hello";
        while (true) {
            str += str + new Random().nextInt(8) + new Random().nextInt(9);
        }


        /**
         * GC4大收集算法！！！
         * 1. 引用计数法。
         * 2. 复制算法。
         *      young代，因为对象存活率低，区域小，复制的对象相对少。
         *      优点：无碎片；缺点：费空间。
         * 3. 标记清除。
         *      old代，因为对象存活率高，区域大，复制的对象相对多，不适用于复制算法。
         *      算法分为标记和清除两个阶段，先标记要回收的对象，然后统一回收这些对象。
         *      GC触发，将程序暂停，先标记一遍，然后统一收集这些对象，完成清除工作后，让程序继续运行。
         *      优点：不需要额外空间；缺点： 2次扫描耗时严重，产生内存碎片（即，存活下来的对象分布杂乱，为了应付这一点
         *          JVM不得不维持一个空闲列表，这又是一种开销），GC时程序暂停。
         * 4. 标记压缩。
         *      old代。
         *      一般由标记清除和标记整理混合实现。
         *      在整理压缩阶段不再对标记的对象做回收处理，而是让所有存活的对象向一端移动，然后直接清除边界以外的内存，这样
         *          当需要给新对象分配内存空间时，JVM只需要有一个内存起始地址即可，这比维护一个空闲列表要好了很多开销。
         *      优点：没有内存碎片；缺点：需要移动对象的成本，耗时也更加严重，效率不高，不仅标记所有存活对象，还要整理所有存活
         *          对象的引用地址，从效率上来讲，不如复制算法。
         *  整理：
         *      1. 内存效率：复制>标记清除>标记压缩。
         *      2. 内存整齐度：复制=标记压缩>标记清除。
         *      3. 内存利用率：标记清除=标记压缩>复制。
         *
         */

    }
}
