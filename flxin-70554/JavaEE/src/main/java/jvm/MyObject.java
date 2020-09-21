package jvm;


/**
 * 什么是类加载器。
 * 类加载器有几种，分别是什么。
 * 双亲委派。
 * 沙箱安全机制。
 *
 * native是一个关键字，
 * 有声明，无实现，实现具体靠C语言为基础的第三方函数库。
 * native方法的装载和运行在native方法栈中。
 *
 * PC寄存器
 * 		记录了方法之间的调用和执行情况，类似值日表。
 * 		用来存储指向下一个指令的地址，它是当前线程所执行的字节码的行号指示器。
 *
 * 方法区
 * 		供各线程共享的运行时内存区域，存储每一个类的结构信息。
 * 		最典型的是就是永久代和元空间。
 *
 * stack
 * 		栈管运行，堆管存储。
 * 		java方法==栈帧（一个方法A被调用，产生栈贞F1）
 * 		8种基本类型+引用类型+方法，存在于栈中。
 *		每个方法执行的同时，会创建一个栈帧，用于存储局部变量、动态链接、方法出口
 * 		java.lang.StackOverflowError	属于error，不是异常
 *
 * heap
 * 		新生代（1/3）    伊甸区（Eden space）（80%）		伊甸区满的时候开启GC/YGC
 *                      幸存者0区（S0/from区）（10%）
 * 				        幸存者1区（S1/to区）（10%）
 *
 *
 * 		老年代（2/3）	养老区         养老区满的时候开启Full GC/FGC
 *                                    -- 当多次调用FGC，但是养老区还是满载时，报OOM，java.lang.OutOfMemoryError: Java heap space异常 ，
 *                                          即堆内存溢出。
 * 									  -- 当出现OOM异常时，说明java虚拟机堆内存不足，原因有二：
 * 									        1.java虚拟机堆内存设置不够，可以通过参数-Xms、-Xmx来调整。
 * 									        2.代码中创建了大量的大对象，并且长时间不能被垃圾收集器收集（即，存在被引用）。
 *
 *
 *      java7永久区、java8元空间
 *      逻辑上，分为3个组成：新生代，老年代，元空间		物理上分为2个组成：新生代、老年代
 *
 *
 *      MinorGC过程：复制->清空->互换
 *      1. eden、from复制到to年龄+1
 *          首先eden满的时候触发第一次GC，把还活着的对象拷贝到from，
 *          当eden再一次触发GC时候，会同时扫描eden和from区域，同时对这两个区域进行垃圾回收，通过这次垃圾回收还存活的对象会被拷贝到to区，年龄+1。
 *      2. 清空eden、from
 *          然后清空eden、from，也即谁空谁是to区。
 *      3. to和from交换
 *          最后to和from交换，原来的to区变成下一个GC时from区，部分对象会在to和from来回复制，交换15次，会存入老年代。
 *
 *      java7，永久代使用的是jvm堆内存，
 *      java8，元空间使用的不再是jvm堆内存，而是使用本机的物理内存。
 *
 *
 *      堆内存调优：
 *          -Xms    设置初始分配大小，默认物理内存的“1/64”。
 *          -Xmx    最大分配内存，默认物理内存的“1/4”。
 */
public class MyObject {

    public static void main(String[] args) {

        MyObject myObject = new MyObject();
        System.out.println(myObject.getClass().getClassLoader());
        System.out.println(myObject.getClass().getClassLoader().getParent());
        System.out.println(myObject.getClass().getClassLoader().getParent().getParent());

        System.out.println();
        System.out.println();
        System.out.println();



        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());
//        System.out.println(object.getClass().getClassLoader().getParent());//这行代码报错，已经是顶级加载器了。
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());


        // 获取本机核数。
        int ii = Runtime.getRuntime().availableProcessors();
        System.out.println(ii);

double i ;
Double j ;
        Long max = Runtime.getRuntime().maxMemory();
        System.out.println(max/1024/1024);
        long total = Runtime.getRuntime().totalMemory();
        System.out.println(total/1024/1024);

    }



}
