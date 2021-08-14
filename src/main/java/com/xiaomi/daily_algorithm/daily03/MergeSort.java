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
		    mergeSort(arr1, 0, arr1.length - 1);
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
