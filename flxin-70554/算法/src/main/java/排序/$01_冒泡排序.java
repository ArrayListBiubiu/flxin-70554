package 排序;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class $01_冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 8, 2, 1};
        method(arr);
    }

    public static void method(int[] arr) {
        //标志位，冒泡排序的一次优化，如果某一次排序过程中没有任何数值移动，说明已经排序完毕了，不需要继续进行比较
        boolean flag = false;

        //比如一共5个元素，第一次比较5个元素（4次），第二次比较4个元素（3次），第三次比较3个元素（2次），第四次比较2个元素（1次）
        //最多会执行 arr.length-1 次排序
        for (int i = 0; i < arr.length - 1; i++) {
            //每一次比较时，最多需要比较 arr.length-1 个元素，之后会逐渐减少比较的元素个数，所以需要 -i
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "次排序：" + Arrays.toString(arr));
        }



    }

}
