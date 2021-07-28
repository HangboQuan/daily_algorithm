package com.xiaomi.daily_algorithm.daily01;

/**
 * @author quanhangbo
 * @date 2021/7/27 23:10
 */
public class LocalMinimum {
    /**
     * 给定一个无序，相邻数组元素不等的数组，使用二分法，返回一个局部最小值
     * 局部最小值的定义：
     * 1. arr[0] < arr[1]:则arr[0]为一个局部最小值，可直接返回
     * 2. arr[N-2] > arr[N-1]:则arr[N-1]为一个局部最小值，可直接返回
     * 3. arr[x-1] > arr[x] < arr[x+1]:则arr[x]为一个局部最小值，可直接返回
     * @param args
     * 思路：
     * 如果第一种或者第二种符合要求的话，直接返回即可,
     * 如果第一种和第二种情况都不符合要求的话，则说明在中间必回出现局部最小值
     * （因为开头是从大到小，结尾是从小到大）
     * 这样即直接去mid，如果arr[mid]是局部最小，则直接返回；
     *                  如果arr[mid]不是局部最小，则选择任何一次arr[mid]>相邻数据的一边
     *                  这样的话就可以按照二分的思路直接砍一半数据
     */
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7, 8};
        System.out.println(localSmallest(arr));
    }

    public static int localSmallest(int[] arr){
        if(arr == null || arr.length < 0){
            return -1;
        }
        if(arr.length == 1 && arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length - 2] > arr[arr.length - 1]){
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > arr[mid - 1]){
                right = mid - 1;
            }else if(arr[mid] > arr[mid + 1]){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return left;
    }

}
