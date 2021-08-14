package com.xiaomi.daily_algorithm.daily03;

import org.springframework.util.StopWatch;

import static com.xiaomi.daily_algorithm.daily01.SelectSort.*;
import static com.xiaomi.daily_algorithm.daily01.SelectSort.printResult;

/**
 * @author quanhangbo
 * @date 2021/8/14 19:09
 */
public class MergeSort {
    public static void main(String[] args) {
	    StopWatch stopWatch = new StopWatch();
	    stopWatch.start();
	    int testTime = 500000;
	    int maxSize = 100;
	    int maxValue = 100;
	    boolean succeed = true;
	    for(int i = 0; i < testTime; i++){
		    int[] arr1 = generateRandomArray(maxSize, maxValue);
		    int[] arr2 = copyArray(arr1);
		    // printResult(arr1);
		    // mergeSort(arr1, 0, arr1.length - 1);
		    mergeSort2(arr1);
		    comparator(arr2);
		    if(!isEqual(arr1, arr2)){
			    // 如果arr1和arr2中的元素不一致，则执行该逻辑
			    succeed = false;
			    printResult(arr1);
			    printResult(arr2);
			    break;
		    }
	    }
	    stopWatch.stop();
	    System.out.println("耗时：" + stopWatch.getTotalTimeMillis() + "ms");
	    System.out.println(succeed ? "Accept" : "Not Accept");
    }

    // 使用递归的方式进行归并排序
    public static void mergeSort(int[] arr, int left, int right){
    	// 注意：如果这里不对数组进行判空就会出错，还是要增强代码的健壮性
    	if(arr == null || arr.length <= 0){
    		return ;
	    }
    	if(left == right){
    		return ;
	    }
    	int mid = left + ((right - left) >> 1);
    	mergeSort(arr, left, mid);
    	mergeSort(arr, mid + 1, right);
    	mergeArray(arr, left, mid, right);
    }

    // 使用非递归的方式进行排序

	/**
	 * 思路：类似于归并排序，将数组从下标0开始
	 *  3 2 5 8 4 7 6
	 *
	 *  第一步：2 3 5 8 4 7 6（2,3作为一组）
	 *  第二步：2 3 5 8 4 7 6（2,3,5,8作为一组）
	 *  第三步：2 3 4 5 6 7 8（整个数组作为一组）
	 *
	 *  作为一组让它去merge即可
	 * @param arr
	 */
	public static void mergeSort2(int[] arr){
    	if(arr == null || arr.length < 2){
    		return ;
	    }
    	int N = arr.length;
    	int mergeSize = 1;
    	while(mergeSize < N){
    		int L = 0;
    		while(L < N){
    			// 中点位置
    			int mid = L + mergeSize - 1;
    			if(mid >= N){
    				break;
			    }
    			// 右边界，N-1是处理划分数组不够的情况
    			int R = Math.min(mid + mergeSize, N - 1);
    			mergeArray(arr, L, mid, R);
    			L = R + 1;
		    }

    		if(mergeSize > N / 2){
    			break;
		    }
		    mergeSize <<= 1;
	    }
	}

    public static void mergeArray(int[] arr, int left, int mid, int right){
    	// 申请一个辅助数组
    	int[] help = new int[right - left + 1];
    	int current = 0;
    	int l = left;
    	int r = mid + 1;
    	while(l <= mid && r <= right){
    		help[current++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
	    }
    	while(l <= mid){
    		help[current++] = arr[l++];
	    }
    	while(r <= right){
    		help[current++] = arr[r++];
	    }

    	// 然后将辅助数组的数字重新刷会原数组
	    for(int i = 0; i < help.length; i++){
	    	// 注意这里是left + i,而不是i
	    	arr[left + i] = help[i];
	    }
    }
}
