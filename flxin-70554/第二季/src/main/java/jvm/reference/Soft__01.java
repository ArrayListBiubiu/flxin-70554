package jvm.reference;


import java.lang.ref.SoftReference;


/**
 * 软引用：当堆内存严重不足时，为防止OOM，会做垃圾回收处理
 *
 * 前提：（-Xms10m -Xmx10m） + （Byte[] bytes = new Byte[1024 * 1024 * 100];）
 */
public class Soft__01 {

    public static void main(String[] args) {
		//当是以这种方式创建字符串时，直接指向的是方法区空间，而OOM发生在堆空间，即最终softReference.get()还是会输出def，并不会被垃圾回收处理
        //String str = "abc";
        String str = new String("abc");
        SoftReference softReference = new SoftReference(str);

        System.out.println(str);	//强引用输出：abc
        System.out.println(softReference.get());	//软引用输出：abc

		//这一步目的：防止一个内存对象被强引用和软引用同时指向，当发生OOM时，软引用的内存对象不能做垃圾回收处理
        str = "def";

        try {
            Byte[] bytes = new Byte[1024 * 1024 * 100];
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            System.out.println(str);	//输出：def
            System.out.println(softReference.get());	//输出：null
        }
    }
}
