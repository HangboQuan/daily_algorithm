package com.xiaomi.daily_algorithm.daily02;

/**
 * @author quanhangbo
 * @date 2021/8/1 17:39
 */
public class ArrayMax {


    /**
     * 用递归的方式实现求一个数组的最大值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int maxInArray(int[] arr, int left, int right){
        if(left == right){
            return arr[left];
        }
        int mid = left + ((right - left) >> 1);
        int leftMax = maxInArray(arr, left, mid);
        int rightMax = maxInArray(arr, mid + 1, right);
        return leftMax > rightMax ? leftMax : rightMax;
    }


    public static void main(String[] args){
        int[] arr = {3, 2, 5, 8, 4, 7, 6};
        System.out.println(maxInArray(arr, 0, arr.length - 1));
    }
}
