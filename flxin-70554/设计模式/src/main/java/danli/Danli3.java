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
public class Danli3{
	public static void main(String[] args) {
		Singleton3 s1 = Singleton3.getInstance();
		Singleton3 s2 = Singleton3.getInstance();
		System.out.println(s1==s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}
}



/**
 * 3.懒汉式（线程不安全）
 * 优点：懒加载效果
 * 缺点：线程不安全，当一个线程已经开始if判断，另一个线程得到时间线开始进入if判断
 */
class Singleton3 {

	//1.提供内部创建对象的实例、生命
	private static Singleton3 instance;

	//2.构造器私有化
	private Singleton3() {

	}

	//3.当使用该方法时，再去创建实例
	public static Singleton3 getInstance() {
		if(instance == null) {
			instance = new Singleton3();
		}
		return instance;
	}




}
