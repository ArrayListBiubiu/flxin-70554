package lambda;


import lambda.interfaces.Lambda_1_NoneReturnNoneParameter;
import lambda.interfaces.Lambda_2_NoneReturnOneParameter;
import lambda.interfaces.Lambda_3_NoneReturnMutipleParameter;
import lambda.interfaces.Lambda_5_ReturnOneParameter;

/**
 * lambda表达式的精简方式
 */
public class MyLambda_2 {


    public static void main(String[] args) {
        // 1.参数类型可以不写
        // 但是不允许写一部分，不写另外一部分的情况，由 (int a, String b) => (a, b)
        Lambda_3_NoneReturnMutipleParameter lambda1 = (a, b) -> {
            System.out.println("hello world");
        };

        // 2.小括号
        // 当参数只有一个的时候，小括号可以省略不写，由 (int a) => (a) => a
        Lambda_2_NoneReturnOneParameter lambda2 = a -> {
            System.out.println("hello world2");
        };

        // 3.方法体的大括号
        // 如果方法体中只有一句话，可以省略大括号
        Lambda_1_NoneReturnNoneParameter lambda3 = () ->
                System.out.println("hello world3");

        // 但是如果方法体中是有返回值的，必须把 "return" 也省略掉
        Lambda_5_ReturnOneParameter lambda4 = (a) ->
                "hello world4";

    }
}
