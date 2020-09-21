package juc;


public class LambdaExpressDemo02{

    public static void main(String[] args) {

        Foo2 foo = new Foo2() {
            public int add(int x,int y) {
                System.out.println("come in");
                return x+y;
            }
        };
        int num = foo.add(1, 2);
        System.out.println(num);



        Foo2 foo2 = (int x,int y) -> {
            System.out.println("come in,javaee.thread.lambda");
            return x+y;
        };
        int number = foo2.add(3, 5);
        System.out.println(number);

    }

}


/**
 * 函数式接口@FunctionalInterface
 * 1. 必须要有抽象方法。
 * 2. 可以有一个或多个静态方法。
 * 3. 可以有一个或多个默认方法。
 *
 * 拷贝小括号，写死右箭头，落地大括号。
 * 只有函数式接口，才能使用lambda表达式s。
 */
//@FunctionalInterface
interface Foo2 {
    //	public void sayHello();
    public int add(int x, int y);

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