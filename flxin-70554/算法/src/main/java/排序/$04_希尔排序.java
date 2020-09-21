package 排序;

import java.util.Arrays;

public class $04_希尔排序 {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 8, 2, 1};
        arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        method(arr);
    }

    public static void method(int[] arr){
        int step = arr.length / 2; // 初始步长
        while (step >= 1){
            for(int i = 0 ; i < step; i++){
                for(int j = step; j < arr.length; j += step){
                    int k = j;
                    while (k > 0){
                        if(arr[k] < arr[k - step]){
                            int temp = arr[k];
                            arr[k] = arr[k - step];
                            arr[k - step] = temp;
                        }
                        k -= step;
                    }
                }
            }
            step /= 2;
            System.out.println( Arrays.toString(arr));
        }
    }
}
