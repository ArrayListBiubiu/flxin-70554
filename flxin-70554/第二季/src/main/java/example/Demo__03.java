package example;


/**
 * equals和==（2）
 */
public class Demo__03 {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";
        String s4 = "xxx";
        String s5 = "abc" + "xxx";
        /*
            StringBuilder stringBuilder = new StringBuilder("abc");
            stringBuilder.append("xxx");
            System.out.println(stringBuilder);
         */
        String s6 = s3 + s4;



        System.out.println(s1 == s2);
        System.out.println(s5 == s6);
        /*
            intern()方法：
                优先从常量池寻找是否有已有的能够匹配的字符串，
                所以s5、s6都会指向常量池，==判断，返回true。
         */
        System.out.println(s5 == s6.intern());
        System.out.println(s1 == s2.intern());
        System.out.println(s2 == s2.intern());

    }

}
