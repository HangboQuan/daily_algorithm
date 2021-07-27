package com.xiaomi.daily_algorithm.daily01;

/**
 * @author quanhangbo
 * @date 2021/7/26 23:11
 */
public class NearLeftValueBinarySearch {

    // 对于有序数组，找到>=某个数最左侧的位置
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 3, 3, 4};
        System.out.println(findNearNumLeft(arr, 2));
    }

    public static int findNearNumLeft(int[] arr, int num){
        int index = -1;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(arr[mid] >= num){
                index = mid;
                right = mid - 1;

            }else{
                left = mid + 1;
            }
        }
        return index;
    }
}
