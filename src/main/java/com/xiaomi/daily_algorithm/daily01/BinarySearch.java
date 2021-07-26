package com.xiaomi.daily_algorithm.daily01;

import static com.xiaomi.daily_algorithm.daily01.SelectSort.copyArray;

/**
 * @author quanhangbo
 * @date 2021/7/26 13:22
 */
public class BinarySearch {

    // 使用二分法，判断有序数组中是否存在一个数
    public static boolean isExist(int[] sortArr, int num){
        if(sortArr == null){
            return false;
        }
        int left = 0;
        int right = sortArr.length - 1;
        int mid = 0;
        while(left < right){
            mid = left + ((right - left) >> 1);

            if(sortArr[mid] == num){
                return true;
            }else if(sortArr[mid] < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return sortArr[mid] == num;
    }

    // 写一个对数器批量测试案例是否正确
    public static int[] testCase(int maxSize, int maxValue){
        // 生成一个随机长度为[1, maxSize]大小的数组

        int[] arr = new int[(int)(maxSize * Math.random() + 1)];
        arr[0] = (int)(((maxSize + 1) * Math.random()) - (maxSize * Math.random()));

        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1]++;
        }
        return arr;
    }

    public static boolean findNum(int[] sortArr, int num){

        for(int i = 0; i < sortArr.length; i++){
            if(sortArr[i] == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        //System.out.println(isExist(arr, 6));

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = false;

        for(int i = 0; i < testTime; i++){
            int[] arr1 = testCase(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            // 随机生成[arr[0], arr[0] + arr.length]的值
            int num = (int)((arr1[0] + 1) * Math.random()) + arr1.length;

            // 随机生成随机数
            int randomNum = (int)((maxValue + 1) * Math.random());
            if(isExist(arr1, num) && findNum(arr2, num)){
                succeed = false;
            }
            succeed = true;


        }
        System.out.println(succeed ? "Accept":"Not Accept");
    }
}
