package danli;


import org.springframework.web.bind.annotation.ResponseBody;

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
public class Danli5{
    public static void main(String[] args) {

        Singleton5 s1 = Singleton5.getInstance();
        Singleton5 s2 = Singleton5.getInstance();
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}



/**
 * 5.懒汉式（线程安全，同步代码块，是一种错误写法）
 * 缺点：***是在if判断之后增加synchronized锁，最基本的同步效果也无法实现。
 * 		是一种完全错误的写法
 *
 * 若要实现同步效果，synchronized锁要在判断语句之前
 */
class Singleton5 {

    //1.提供内部创建对象的实例、生命
    private static Singleton5 instance;

    //2.构造器私有化
    private Singleton5() {

    }

    //3.创建静态的共有方法，当使用该方法时，再去创建实例，加锁
    public static Singleton5 getInstance() {
        synchronized (Singleton5.class) {
            if(instance == null) {
                instance = new Singleton5();
            }

        }
        return instance;
    }




}
