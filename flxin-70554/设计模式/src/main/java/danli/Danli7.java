package danli;


/**
 * 单例8种：
 * 	1.饿汉式（静态常量）
 * 	2.饿汉式（静态代码块）
 * 	3.懒汉式（线程不安全）
 * 	4.懒汉式（线程安全，同步方法）
 * 	5.懒汉式（线程安全，同步代码块）
 * 	6.双重检查（Double Check Lock）
 * 	7.静态内部类
 * 	8.枚举(jdk1.5)
 *
 * 推荐使用DCL、静态内部类、枚举、          饿汉式（在单线程下，且保证一定会使用时可以使用）
 */
public class Danli7{
    public static void main(String[] args) {

        Singleton7 s1 = Singleton7.getInstance();
        Singleton7 s2 = Singleton7.getInstance();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}



/**
 * 7.静态内部类
 * 线程安全，懒加载
 *
 * 原理：
 * 	1.外部类加载时，内部类不会加载，保证懒加载
 * 	2.当内部类加载的时候完成初始化，利用类加载的线程安全性（底层原理），保证线程安全
 *
 */
class Singleton7 {


    //1.构造器私有化
    private Singleton7() {

    }

    //2.静态内部类，在外部类加载时不会加载
    private static class Singleton8{
        private static final Singleton7 instance = new Singleton7();
    }

    //3.提供静态共有方法，返回对象
    public static synchronized Singleton7 getInstance() {
        return Singleton8.instance;
    }




}
