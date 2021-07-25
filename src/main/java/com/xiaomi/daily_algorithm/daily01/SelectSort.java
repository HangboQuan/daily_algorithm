package com.xiaomi.daily_algorithm.daily01;

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
                swap(arr, i, minIndex);
            }
        }
    }

    public static void printResult(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7, 6, 0};
        selectionSort(arr);
        printResult(arr);
    }
}
