package example;


import java.util.HashSet;


/**
 * equals和==（1）
 *
 * equals是比较内容，==是比较地址，这样的说法是错误的！！！
 * 准确的讲，应该是：
 *      （1）equals：被重写了，是比较内容，没有被重写就完全等同于==。
 *      （2）==：可以比较引用类型和基本类型，在比较基本类型时是在比较值的大小，在比较引用类型时是在比较内存地址。
 */
public class Demo__02 {

    public static void main(String[] args) {

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        /*
            为什么对于String类、BB类，set.size()结果不同？
                对于HashSet底层是通过HashMap的key插入数据，而key根本上比较的是hashcode值，
                String重写了hashcode方法，s1、s2的值相同，
                BB没有重写hashcode方法，比较的就是内存地址，肯定不同，
            明确一点：
                HashMap插入时，本质上不是比较内容，而是比较hashcode值，为什么String类时，值相同就出现替换操作，
                那是因为String重写了hashcode方法，只要内容相同，hashcode结果就相同。
         */
        HashSet set = new HashSet();
        set.add(s1);
        set.add(s2);
        System.out.println(set.size());

        BB b1 = new BB("abc");
        BB b2 = new BB("abc");
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
        set.clear();
        set.add(b1);
        set.add(b2);
        System.out.println(set.size());

    }
}

class BB {
    String name;
    public BB(String name) {
        this.name = name;
    }
}