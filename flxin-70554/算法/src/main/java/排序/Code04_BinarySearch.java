package 排序;

import java.util.Arrays;


/**
 * 二分查找
 */
public class Code04_BinarySearch {

	/*
		二分查找
	 */
	public static boolean exist(int[] sortedArr, int num) {
		if (sortedArr == null || sortedArr.length == 0) {
			return false;
		}
		int L = 0;
		int R = sortedArr.length - 1;
		int mid = 0;
		// L..R
		while (L < R) {
			// mid = (L+R) / 2;
			// L 10亿  R 18亿
			// mid = L + (R - L) / 2
			// N / 2    N >> 1
			mid = L + ((R - L) >> 1); // mid = (L + R) / 2
			if (sortedArr[mid] == num) {
				return true;
			} else if (sortedArr[mid] > num) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return sortedArr[L] == num;
	}
	
	/*
		暴力查找，验证 num 是否存在于数组 sortArr，存在的话返回 true，不存在的话返回 false
	 */
	public static boolean test(int[] sortedArr, int num) {
		for(int cur : sortedArr) {
			if(cur == num) {
				return true;
			}
		}
		return false;
	}


	/*
		获取随意的一个 "随机长度"、"随机元素" 的数组
	 */
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// Math.random()			[0,1)
		// Math.random() * N		[0,N)
		// (int)(Math.random() * N)	[0, N-1]
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			// [-? , +?]
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 50;
		int maxValue = 100;
		boolean succeed = true;
		// 使用 "对数器" 验证
		for (int i = 0; i < testTime; i++) {
			// 获取一个随机的数组
			int[] arr = generateRandomArray(maxSize, maxValue);
			// 使用API排序数组
			Arrays.sort(arr);
			int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
			// 验证是否一致
			if (test(arr, value) != exist(arr, value)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
