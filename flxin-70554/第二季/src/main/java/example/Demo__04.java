package example;


/**
 * 代码块执行顺序（1）
 *      静态代码块 > 构造代码块 > 构造方法
 */
public class Demo__04 {

    public Demo__04() {
        System.out.println("11111");
    }
    {
        System.out.println("22222");
    }
    static {
        System.out.println("33333");
    }

    public static void main(String[] args) {
        System.out.println("================");
        new CC();
        System.out.println("----------------");
        new CC();
        System.out.println("----------------");
        new Demo__04();
    }

}

class CC {
    public CC() {
        System.out.println("44444");
    }
    {
        System.out.println("55555");
    }
    static {
        System.out.println("66666");
    }
}