package com.xiaomi.daily_algorithm.daily01;

import static com.xiaomi.daily_algorithm.daily01.SelectSort.copyArray;
import static com.xiaomi.daily_algorithm.daily01.SelectSort.printResult;

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
        /*while(left <= right){
            mid = left + ((right - left) >> 1);

            if(sortArr[mid] == num){
                return true;
            }else if(sortArr[mid] < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return sortArr[mid] == num;*/

        /**
         * 此写法比上次写的少一次循环，所以得注意最后返回值的问题
         */
        while(left < right){
            mid = left + ((right - left) >> 1);
            if(sortArr[mid] == num){
                return true;
            }else if(sortArr[mid] < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            // 注意使用批量数据测试的时候，如果这里写为sortArr[mid]的话，有些测试用例不通过
        }
        return sortArr[left] == num;
    }

    // 写一个对数器批量测试案例是否正确
    public static int[] testCase(int maxSize, int maxValue){
        // 生成一个随机长度为[1, maxSize]大小的数组

        int[] arr = new int[(int)(maxSize * Math.random() + 1)];
        arr[0] = (int)(((maxSize + 1) * Math.random()) - (maxSize * Math.random()));

        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + 1;
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
            succeed = (isExist(arr1, randomNum) + "").equals(findNum(arr2, randomNum) + "");
            if(!succeed){
                printResult(arr1);
                System.out.println(isExist(arr1, randomNum));
                System.out.println(findNum(arr2, randomNum));
                System.out.println(randomNum);
            }

        }
        System.out.println(succeed ? "Accept":"Not Accept");

        /*int[] arr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
        System.out.println(isExist(arr, 55));*/

    }
}
