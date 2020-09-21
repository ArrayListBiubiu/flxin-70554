package jmm;


/**
 * 执行顺序：静态块>构造块>构造方法。
 */
public class Demo {

    public static void main(String[] args) {

        T t1 = new T();
        T t2 = new T();

    }
}

class T {
    public T() {
        System.out.println("构造方法。");
    }

    static{
        System.out.println("静态块。");
    }

    {
        System.out.println("构造块。");
    }


}