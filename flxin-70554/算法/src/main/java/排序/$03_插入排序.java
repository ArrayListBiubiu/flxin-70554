package 排序;

import java.util.Arrays;

public class $03_插入排序 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 8, 2, 1};
        method(arr);
    }

    // 使用场景：小规模数据、基本有序的数组
    // 插入排序的缺点：如果数组是 {1,2,3,4,5,-1} ，前4次循环比较就毫无意义，浪费时间
    // 插入排序（小 -> 大）
    public static void method(int[] arr) {
        // 用第i个元素和其他元素比较
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            // 需要用第i个元素和这些已经排好序的元素比较
            for (int j = 0; j < i; j++) {
                if (temp < arr[j]) {
                    //System.arraycopy()
                    System.arraycopy(arr, j, arr, j + 1, i - j);
                    arr[j] = temp;
                    break;
                }
            }
            System.out.println("第" + (i) + "次排序：" + Arrays.toString(arr));
        }
    }
}
