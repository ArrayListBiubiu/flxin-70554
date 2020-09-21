package juc;


public class LambdaExpressDemo03{

    public static void main(String[] args) {

        Foo3 foo = new Foo3() {
            public void sayHello(int x,int y) {
                System.out.println("come in");
                System.out.println(x + y);
            }
        };
        foo.sayHello(1, 2);

        Foo3 foo2 = (int x,int y) -> {
            System.out.println("come in,javaee.thread.lambda");
            System.out.println(x + y);
        };
        foo2.sayHello(3, 5);

        System.out.println("-----");
        System.out.println(Foo3.add(9, 3));
        System.out.println(Foo3.sub(9, 3));
        System.out.println(foo2.mul(9, 3));
        System.out.println(foo2.div(9, 3));

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
interface Foo3 {
    //	public void sayHello();
    public void sayHello(int x, int y);

    public static int add(int x, int y) {
        return x+y;
    }
    public static int sub(int x, int y) {
        return x-y;
    }

    public default int mul(int x, int y) {
        return x*y;
    }
    public default int div(int x, int y) {
        return x/y;
    }
}