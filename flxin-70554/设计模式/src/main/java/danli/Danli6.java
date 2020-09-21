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
 *
 */
public class Danli6{
    public static void main(String[] args) {

        Singleton6 s1 = Singleton6.getInstance();
        Singleton6 s2 = Singleton6.getInstance();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}



/**
 * 6.双重检查（DCL）
 * 优点：既有线程安全，又能保证效率
 * 2个if 、 volatile 都必不可少
 *
 * 为什么只有在DCL模式下需要有volatile修饰？
 * 因为第一个if，由于指令重排有可能会造成数据异常，而这时if(instance == null) 判断返回false，
 * 由于其他加锁的方案，都没有第一个if判断，所以不用担心由于指令重排而造成数据异常
 */
class Singleton6 {

    //1.提供内部创建对象的实例、生命
    private static volatile Singleton6 instance;

    //2.构造器私有化
    private Singleton6() {

    }

    //3.双重检查
    public static Singleton6 getInstance() {
        //同步代码块需要排队，提前进行if判断，提高效率
        if(instance == null) {
            synchronized (Singleton6.class) {
                if(instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }

}