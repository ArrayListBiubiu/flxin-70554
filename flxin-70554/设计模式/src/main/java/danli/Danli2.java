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
public class Danli2{
    public static void main(String[] args) {

        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}



/**
 * 2.饿汉式（静态代码块）
 * 优点：类装载的时候执行静态代码块，完成初始化
 * 缺点：没有懒加载效果，是会造成内存浪费。
 */
class Singleton2 {

    //1.声明实例，静态的，私有化的
    private static Singleton2 instance;

    //2.构造器私有化
    private Singleton2() {

    }

    //3.完成初始化
    static {
        instance = new Singleton2();
    }

    //4.提供一个共有的静态方法，返回实例对象
    public static Singleton2 getInstance() {
        return instance;
    }
}
