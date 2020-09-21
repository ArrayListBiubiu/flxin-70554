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
public class Danli8{
    public static void main(String[] args) {

        Singleton8 s1 = Singleton8.instance;
        Singleton8 s2 = Singleton8.instance;
        System.out.println(s1==s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

    }
}



/**
 * 7.枚举(jdk1.5)
 * 避免反序列化，重新创建新对象
 */
enum Singleton8 {

    instance;

}