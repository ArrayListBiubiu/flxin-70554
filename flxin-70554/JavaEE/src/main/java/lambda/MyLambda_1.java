package lambda;


import javaee.lambda.interfaces.*;


public class MyLambda_1 {

    public static void main(String[] args) {

        // 1.lambda1
        Lambda_1_NoneReturnNoneParameter lambda1 = () -> {
            System.out.println("lambda1...");
        };
        lambda1.test();

        // 内部类形式
        Lambda_1_NoneReturnNoneParameter lambda2 = new Lambda_1_NoneReturnNoneParameter() {
            @Override
            public void test() {
                System.out.println("lambda1...内部类");
            }
        };
        lambda2.test();


        // 2.lambda2
        Lambda_2_NoneReturnOneParameter lambda3 = (int a) -> {
            System.out.println("lambda2...");
        };
        lambda3.test(3);

        // 内部类形式
        Lambda_2_NoneReturnOneParameter lambda4 = new Lambda_2_NoneReturnOneParameter() {
            @Override
            public void test(int a) {
                System.out.println("lambda2...内部类");
            }
        };
        lambda4.test(4);

        // 3.lambda3
        Lambda_3_NoneReturnMutipleParameter lambda5 = (int a, String b) -> {
            System.out.println("lambda3...");
        };
        lambda5.test(5, "zhangsan");

        // 4.lambda4
        Lambda_4_ReturnNoneParameter lambda6 = ()->{
            return "lambda4...";
        };
        String test = lambda6.test();
        System.out.println(test);

        // 5.lambda5
        Lambda_5_ReturnOneParameter lambda7 =(int a)->{
            return "lambda5...";
        };
        String test2 = lambda7.test(10);
        System.out.println(test2);

        // 6.lambda6
        Lambda_6_ReturnMutipleParameter lambda8 = (int a, String b) -> {
            return "lambda6...";
        };
        String test3 = lambda8.test(10, "lisi");
        System.out.println(test3);
    }
}
