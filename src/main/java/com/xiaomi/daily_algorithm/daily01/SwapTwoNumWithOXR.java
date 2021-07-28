package com.xiaomi.daily_algorithm.daily01;

/**
 * @author quanhangbo
 * @date 2021/7/28 13:15
 */
public class SwapTwoNumWithOXR {

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        //swap(a, b);

        // 这种方法是在两个变量的内存不同的进行交换
        // 如果两个值的内存相同，如交换arr[0]和arr[0],他两内存相同，这样异或的结果就是0了
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ", b = " + b);
    }

    // 注意：因为这里传递是形参，所以交换不起作用；
    public static void swap(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        /*int temp = a;
        a = b;
        b = temp;*/
    }
}
