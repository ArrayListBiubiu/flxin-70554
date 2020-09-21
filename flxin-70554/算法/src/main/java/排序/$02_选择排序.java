package 排序;

import java.util.Arrays;

public class $02_选择排序 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 8, 2, 1};
        method(arr);
    }

    //时间复杂度 O(n^2)
    public static void method(int[] arr) {
        //标志位
        boolean flag = false;

        // 用第i个元素和其他元素比较
        for (int i = 0; i < arr.length - 1; i++) {  // arr.length - 1，遍历出倒数第二个时候，也是确定了最后一个数是最大的，不需要再遍历
            int minIndex = i;
            // 需要和第i个元素比较的其他元素们
            for (int j = i+1; j < arr.length; j++) {  // j = i + 1，每次循环是选择出最小的放在左侧，所以下一次循环不需要再从头开始
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    flag = true;
                }
            }
            if (flag) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }
    }

}
