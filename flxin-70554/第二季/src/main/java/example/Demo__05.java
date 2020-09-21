package example;


/**
 * 代码块执行顺序（2）
 *      父子类中，静态先行。
 */
public class Demo__05 {
    public static void main(String[] args) {
        System.out.println(7777777);
        System.out.println("-------------");
        /*
            （1）父子类时，静态先行
            （2）子类构造方法，会隐含的有一个super()方法
         */
        new DD();
        System.out.println("-------------");
        new DD();
        System.out.println("-------------");
        new EE();
    }
}


class DD extends EE {
    public DD() {
        System.out.println(1);
    }
    {
        System.out.println(22);
    }
    static {
        System.out.println(333);
    }
}

class EE {
    public EE() {
        System.out.println(4444);
    }
    {
        System.out.println(55555);
    }
    static {
        System.out.println(666666);
    }
}