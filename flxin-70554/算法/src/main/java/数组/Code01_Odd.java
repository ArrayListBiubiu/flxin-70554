package 数组;

import javax.xml.soap.Node;

/**
 * Question1：在一个数组中，数值n出现了奇数次，   其他所有的数值都出现了偶数次，求n？
 * Question2：在一个数组中，数值n和m出现了奇数次，其他所有的数值都出现了偶数次，求n和m？
 */
public class Code01_Odd {

    // Question1：在一个数组中，数值n出现了奇数次，其他所有的数值都出现了偶数次，求n？
    public static void printOdd(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum ^= i;
        }
        System.out.println(sum);
    }

    // Question2：在一个数组中，数值n和m出现了奇数次，其他所有的数值都出现了偶数次，求n和m？
    public static void printOdd2(int[] arr) {
        int sum = 0;   // 所有元素的异或运算和
        int rightOne = 0; // 提取sum最右侧的1
        int result = 0;

        for (int i : arr) {
            sum ^= i;
        }
        rightOne = sum & (~sum + 1);

        for (int i : arr) {
            if ((rightOne & i) == 0) {
                result ^= i;
            }
        }
        System.out.println(result);       // 4的二进制 0100
        System.out.println(result ^ sum); // 5的二进制 0101
                                          // 8的二进制 1000，如果arr2中{5,5,5}修改为{8,8,8}，那么就会先输出8，再输出4
    }

    public static void main(String[] args) {
        int[] arr =  {1, 1,   2, 2,   3, 3,    4,};
        printOdd(arr);
        int[] arr2 = {1, 1,   2, 2,   3, 3,    4,   5};
        printOdd2(arr2);
    }

}


