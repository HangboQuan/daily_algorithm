package com.xiaomi.daily_algorithm.daily01;

import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author quanhangbo
 * @date 2021/7/25 18:24
 */
public class SelectSort {

    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        /**
         * 选择排序思路：
         *  遍历下标0~n-1, 将最小值和arr[0]进行交换
         *  遍历下标1~n-1,           arr[1]
         *  .......
         *  最后即得到升序排序的结果
         */
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
	        swap(arr, i, minIndex);
        }
    }

    public static void printResult(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int maxSize, int maxValue){
    	// 生成长度为maxSize长度大小的数组
    	int[] arr = new int[(int)((maxSize + 1) * Math.random())];
    	for(int i = 0; i < arr.length; i++){
    		arr[i] = (int) ((maxValue + 1) * Math.random() - (int) (maxValue * Math.random()));
	    }
    	return arr;
    }

    public static int[] copyArray(int[] arr){
    	if(arr == null){
    		return null;
	    }
    	int[] res = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			res[i] = arr[i];
		}
		return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2){
    	if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
    		return false;
	    }
    	if(arr1 == null && arr2 == null){
    		return true;
	    }
    	if(arr1.length != arr2.length){
    		return false;
	    }
    	for(int i = 0; i < arr1.length; i++){
    		if(arr1[i] != arr2[i]){
    			return false;
		    }
	    }
    	return true;
    }


    public static void main(String[] args) {
        /*int[] arr = {3, 2, 5, 8, 4, 7, 6, 0};
        selectionSort(arr);
        printResult(arr);*/

        // 使用对数器模拟多台数据进行测试
	    StopWatch stopWatch = new StopWatch();
	    stopWatch.start();
	    int testTime = 500000;
	    int maxSize = 100;
	    int maxValue = 100;
	    boolean succeed = true;
	    for(int i = 0; i < testTime; i++){
	    	int[] arr1 = generateRandomArray(maxSize, maxValue);
	    	int[] arr2 = copyArray(arr1);
	    	selectionSort(arr1);
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
}
