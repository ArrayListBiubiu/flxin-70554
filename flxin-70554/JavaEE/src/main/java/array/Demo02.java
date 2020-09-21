package array;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * 要求：给定任意稀疏数组，使之转换成矩阵（等长等宽的二维数组）
 *
 * 注：
 *      由于矩阵的index是从0开始计数，而稀疏数组中 [0][0]、[0][1]代表共有几行，[0][2]代表共有几个，即都是从1开始计数，
 *      需要在整个计算过程中，需要特别注意 +1 或 -1，否则极易出现数组下标越界，或者最后一行没有遍历完全的情况。
 */
public class Demo02 {

    public static void main(String[] args) {
        //稀疏数组的声明
        int[][] sparseArr = new int[3][3];
        //插入元素，由于没有任何规律性，这里采用这种一个一个插入的方式
        sparseArr[0][0] = 6;
        sparseArr[0][1] = 8;
        sparseArr[0][2] = 2;
        sparseArr[1][0] = 2;
        sparseArr[1][1] = 2;
        sparseArr[1][2] = 34;
        sparseArr[2][0] = 3;
        sparseArr[2][1] = 4;
        sparseArr[2][2] = 52;

        Demo02 d = new Demo02();
        int[][] arr = d.spare(sparseArr);
        for (int[] data : arr) {
            for (int number : data) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }

    public int[][] spare(int[][] spareArr) {
        //矩阵的声明，由于每个位置默认值是0，接下来只需要插入非0元素即可
        int[][] arr = new int[spareArr[0][0]][spareArr[0][1]];
        for (int i = 1; i < spareArr[0][2] + 1; i++) {
            arr[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        return arr;
    }

}
