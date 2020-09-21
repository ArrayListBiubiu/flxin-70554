package yuanxing;

import java.util.Arrays;

/**
 * 原型设计模式
 * 使用Object类的clone方法，实体类必须实现Cloneable接口
 *
 */
public class Yuanxing {
	public static void main(String[] args) throws CloneNotSupportedException {
		int[] arr = {1,2,3};
		Sheep s = new Sheep("多利",2,arr);
		Sheep s2 = (Sheep) s.clone();
		System.out.println("s==s2:"+(s==s2));
		System.out.println("s.name==s2.name:     "+(s.name==s2.name));
		System.out.println("s.age==s2.age:     "+(s.age==s2.age));
		System.out.println("s.arr==s2.arr:     "+(s.arr==s2.arr));
		s2.arr[0] = 100;
		System.out.println(s);
		System.out.println(s2);

	}
}

/**
 * 深拷贝介绍：
 * 1.对所有属性进行复制，包括引用类型、基本类型。
 * 
 * 2.实现方式一：重写clone()方法，实现深拷贝。
 * 3.实现方式二：通过对象序列化实现深拷贝。
 */


/**
 * 浅拷贝介绍：
 * 1.对于基本数据类型的成员变量，浅拷贝进行值传递，也就是将属性值复制一份给新对象。
 * 2.对于引用数据类型的成员变量，比如是某个数组、某个类对象，浅拷贝进行引用传递，也就是将内存地址复制一份给新对象
 * 3.浅拷贝默认使用的是clone()方法来实现。super.clone()。
 * 4.克隆羊案例使用的是浅拷贝。
 *
 */

class Sheep implements Cloneable{
	public String name;
	public int age;
	public int[] arr;
	public Sheep(String name, int age, int[] arr) {
		super();
		this.name = name;
		this.age = age;
		this.arr = arr;
	}
	public String toString() {
		return "Sheep [name=" + name + ", age=" + age + ", arr=" + Arrays.toString(arr) + "]";
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}