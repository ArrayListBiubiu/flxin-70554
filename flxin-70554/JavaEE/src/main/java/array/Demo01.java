package array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * 要求：给定任意长度的矩阵（等长等宽的二维数组），将它转变成稀疏数组。
 *
 * 注：
 *      由于矩阵的index是从0开始计数，而稀疏数组中 [0][0]、[0][1]代表共有几行，[0][2]代表共有几个，即都是从1开始计数，
 *      需要在整个计算过程中，需要特别注意 +1 或 -1，否则极易出现数组下标越界，或者最后一行没有遍历完全的情况。
 */
public class Demo01 {

    public static void main(String[] args) throws Exception {
        int[][] arr = new int[6][8];
        arr[2][2] = 34;
        arr[3][4] = 52;
        for (int[] data : arr) {
            for (int number : data) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }

        System.out.println("-------------------------------------");

        Demo01 d = new Demo01();
        int[][] sparseArr = d.sparse(arr);
        for (int[] data : sparseArr) {
            for (int number : data) {
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }

    public int[][] sparse(int[][] arr) throws Exception {
        //健壮性判断
        if (arr == null) {
            throw new Exception("原二维数组为空，无法变成稀疏数组！！！");
        }

        //计数器，记录原矩阵中有多少个非0元素
        int count = 0;
        //在遍历原矩阵时，将非0元素的行数和列数缓存起来
        HashMap<Integer, Integer> hashMap = new HashMap();
        //非0元素缓存起来之后，通过index定位i
        ArrayList<Integer> arrayList = new ArrayList();

        //遍历原矩阵
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    hashMap.put(i, j);
                    arrayList.add(i);
                }
            }
        }

        //稀疏数组声明
        int[][] sparseArr = new int[count + 1][3];

        //只插入第一行
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = count;

        //从第二行开始插入剩下的
        for (int i = 0; i < sparseArr.length - 1; i++) {
            for (int j = 0; j < 3; j++) {
                sparseArr[i + 1][0] = arrayList.get(i);
                sparseArr[i + 1][1] = hashMap.get(arrayList.get(i));
                sparseArr[i + 1][2] = arr[sparseArr[i + 1][0]][sparseArr[i + 1][1]];
            }
        }
        return sparseArr;
    }

}
