package com.xiaomi.daily_algorithm.daily03;

import org.springframework.util.StopWatch;

import static com.xiaomi.daily_algorithm.daily01.SelectSort.*;
import static com.xiaomi.daily_algorithm.daily01.SelectSort.printResult;

/**
 * @author quanhangbo
 * @date 2021/8/14 21:24
 */
public class SmallSumNumbers {

	// static int num = 0;

	/**
	 * 求数组的小和，给定一个数组，数组中每个元素为target,从左开始遍历数组，知道当前target，如果比target小
	 * 则累加起来，这就是target元素的小和，遍历完整个数组，也就是整个数组的小和
	 * 例：[3,2,5,8,4,7,6]
	 * 3:0
	 * 2:0
	 * 5:3+2
	 * 8:3+2+5
	 * 4:3+2
	 * 7:3+2+5+4
	 * 6:3+2+5+4
	 * 最后累计起来为48，也即该数组的最小和
	 * 实现思路：传统的做法是使用两层循环来做，时间复杂度为o(n^2)，里面有太多重复的比较判断
	 * 为此可以采用类似归并排序的实现思路，现将数组分解为最小的case，在合并(merge)的时候(merge已经有序了)：
	 *      如果arr[l] < arr[r] ----> 则可以统计出right中有多少个数比它大，就可以计入结果，然后再拷贝，刷回原数组
	 *      如果arr[l] >= arr[r] ----> 则按照正常的归并排序处理，比较大小后，刷新回原数组
	 *
	 */
    public static void main(String[] args) {
    	// 并用500000组数据进行测试
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
		    int result = smallSum(arr1, 0, arr1.length - 1);
		    int result2 = smallSum(arr2);
		    //comparator(arr2);
		    if((result != result2)){
			    // 如果arr1和arr2中的元素不一致，则执行该逻辑
			    succeed = false;
			    printResult(arr1);
                System.out.println(result);
                System.out.println(result2);
                break;
		    }
	    }
	    stopWatch.stop();
	    System.out.println("耗时：" + stopWatch.getTotalTimeMillis() + "ms");
	    System.out.println(succeed ? "Accept" : "Not Accept");
    }

    public static int smallSum(int[] arr, int left, int right){
    	if(arr == null || arr.length < 1){
    		return 0;
	    }
    	if(left == right){
    		return 0;
	    }
    	int mid = left + ((right - left) >> 1);
    	int result = 0;
    	return smallSum(arr, left, mid) + smallSum(arr, mid + 1, right) + merge(arr, left, mid, right, result);
    }

    public static int smallSum(int[] arr){
    	int result = 0;
    	for(int i = 0; i < arr.length; i++){
    		for(int j = 0; j < i; j++){
    			if(arr[j] < arr[i]){
    				result += arr[j];
			    }
		    }
	    }
    	return result;
    }

    public static int merge(int[] arr, int left, int mid, int right, int result){
    	int[] help = new int[right - left + 1];
    	int l = left;
    	int r = mid + 1;
    	int current = 0;
    	while(l <= mid && r <= right){
    		if(arr[l] < arr[r]){
    			help[current++] = arr[l];
    			result += (right - r + 1) * arr[l++];
		    }else{
    			help[current++] = arr[r++];
		    }
	    }

    	while(l <= mid){
    		help[current++] = arr[l++];
	    }
    	while(r <= right){
    		help[current++] = arr[r++];
	    }

    	for(int i = 0; i < help.length; i++){
    		arr[left + i] = help[i];
	    }
    	return result;
    }
}
