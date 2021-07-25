package com.xiaomi.daily_algorithm.daily01;

import org.springframework.util.StopWatch;

import static com.xiaomi.daily_algorithm.daily01.SelectSort.*;

/**
 * @author quanhangbo
 * @date 2021/7/25 22:33
 */
public class BubbleSort {

    public static void bubbletionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }

        /**
         * 冒泡排序的思路为：相邻两个元素之间进行交换，每遍历一次数组，就能确定一个数的位置
         */
        for(int i = arr.length - 1; i >= 0; i--){

            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            bubbletionSort(arr1);
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
        System.out.println(succeed ? "Accept" : "Not Accept");    }
}
