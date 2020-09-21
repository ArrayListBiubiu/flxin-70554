package juc;


public class LambdaExpressDemo01{

    public static void main(String[] args) {

        // 1.
        Foo foo = new Foo() {
            public void sayHello() {
                System.out.println("hello");}
        };
        foo.sayHello();

        // 1.1. lambda解决匿名内部类冗余问题
        Foo foo2 = () -> {System.out.println("hello,javaee.thread.lambda");};
        foo2.sayHello();

    }

}


/**
 * 函数式接口@FunctionalInterface
 * 1. 必须要有抽象方法。
 * 2. 可以有一个或多个静态方法。
 * 3. 可以有一个或多个默认方法。
 *
 * 拷贝小括号，写死右箭头，落地大括号。
 * 只有函数式接口，才能使用lambda表达式。
 */
//@FunctionalInterface
interface Foo {
    public void sayHello();
//	public int add(int x,int y);
//	public static int mul(int x,int y) {
//		return x*y;
//	}
//	public static int div(int x,int y) {
//		return x/y;
//	}
//	public default int run3(int x,int y) {
//
//	}
//	public default int run4(int x,int y) {
//
//	}
}