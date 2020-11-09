package 排序;


import java.util.Arrays;


/**
 * 选择排序
 */
public class Code01_SelectionSort {

	public static void selectionSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 0 ~ N-1
		// 1~n-1
		// 2
		for (int i = 0; i < arr.length - 1; i++) { // i ~ N-1
			// 最小值在哪个位置上  i～n-1
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) { // i ~ N-1 上找最小值的下标 
				minIndex = arr[j] < arr[minIndex] ? j : minIndex;
			}
			swap(arr, i, minIndex);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/*
		使用API提供的排序方式
	 */
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
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

	/*
		拷贝一份刚才生成的数组
	 */
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/*
		验证：
		(1)测试使用 "手写的排序" 和 "API排序" 结果是否相同
		(2)相同返回true，不相同返回false
	 */
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	/*
		便利数组，相当于 toString()
	 */
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		// 使用 "对数器" 验证
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			// 使用选择排序
			selectionSort(arr1);
			// 使用API排序
			comparator(arr2);
			// 验证
			// 不一致的话，返回false并取反，进入if
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		// 演示成功的排序结果
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		selectionSort(arr);
		printArray(arr);


		System.out.println((3<<1) | 1);
	}

}
