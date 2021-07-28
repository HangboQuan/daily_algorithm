package com.xiaomi.daily_algorithm.daily01;

/**
 * @author quanhangbo
 * @date 2021/7/28 13:46
 */
public class FindTwoDifferentNum {

    /**
     * 给定一个数组，除了2个数出现了奇数次，其余数组元素都出现了偶数次，求出现奇数次的数组元素
     * @param arr
     * @return
     */
    public static int[] findTwoNum(int[] arr){
        int eor = 0;
        // 使用循环得到两个不同数的异或结果 a^b
        for(int i = 0; i < arr.length; i++){
            eor = eor ^ arr[i];
        }
        // 然后找出a^b结果中最右边出现1的位置
        int index = ((~eor) + 1) & eor;
        int eor2 = 0;
        for(int i = 0; i < arr.length; i++){
            if((index & arr[i]) > 0){
                // 说明这是最右边包含一位置的所有数
                eor2 ^= arr[i];
            }
        }
        // 此时就得到了其中一个值---> eor2;
        int other = eor ^ eor2;
        arr[0] = eor2;
        arr[1] = other;
        return arr;

    }
    public static void main(String[] args) {
        int[] arr =  {3, 2, 2, 2, 2, 4, 4, 9};
        int[] num = findTwoNum(arr);
        System.out.println(num[0] + " " + num[1]);
    }
}
