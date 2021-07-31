package com.xiaomi.daily_algorithm.daily02;

/**
 * @author quanhangbo
 * @date 2021/7/31 17:36
 */
public class ArrayImpStackOrQueue {

    /**
     * 使用固定长度的数组实现固定长度的栈和队列
     *
     * 数组实现队列思路：
     *      用两个变量(或者也可以叫指针)pushIndex,popIndex分别代表添加元素和移除元素的指针
     *  初始情况下两个指针都指向数组0位置，当要添加元素时pushIndex++,当要移除元素时popIndex++
     *  用size来表示当前队列的长度，完全解耦pushIndex和popIndex两个变量，当pushIndex或者popIndex
     *  到达数组的末尾时，让指针又重新指回数组首位。
     *
     *  数组实现栈思路：
     *      用一个变量index即可，添加元素的时候，index++,移除元素的时候，--index即可
     */
    public static class MyQueue{

        private int[] arr;
        private int pushIndex;
        private int popIndex;
        private int size;
        private final int limit  = 7;

        public MyQueue(){
            arr = new int[limit];
            pushIndex = 0;
            popIndex = 0;
            size = 0;
        }

        public void push(int value) throws Exception{

            if(size == limit){
                throw new Exception("队列已满,无法继续push元素");
            }
            arr[pushIndex] = value;
            size++;
            pushIndex = (pushIndex < limit - 1) ? pushIndex + 1 : 0;
        }

        public int pop() throws Exception{

            if(size == 0){
                throw new Exception("队列为空，无法pop元素");
            }
            int ans = arr[popIndex];
            size--;
            popIndex = (popIndex < limit - 1) ? popIndex + 1 : 0;
            return ans;
        }



        public boolean isEmpty(){
            return size == 0;
        }
    }


    public static class MyStack{
        private int[] arr;
        private int index;
        private final int limit = 7;
        public MyStack(){
            arr = new int[limit];
            index = 0;
        }

        public void push(int value){
            if(index == limit){
                System.out.println("栈已满，无法添加元素");
            }
            arr[index++] = value;
        }

        public int pop(){
            if(index < 0){
                System.out.println("栈已空，无法弹出元素");
            }
            return arr[--index];
        }

    }
    public static void main(String[] args){
        try{

            MyQueue myQueue = new MyQueue();
            myQueue.push(1);
            myQueue.push(2);
            myQueue.push(3);
            myQueue.push(4);
            myQueue.pop();
            myQueue.pop();
            myQueue.push(5);
            myQueue.push(6);
            myQueue.push(7);
            myQueue.push(8);
            myQueue.push(9);
            int[] num = new int[7];
            int index = 0;
            while(!myQueue.isEmpty()){
                num[index++] = myQueue.pop();
            }
            for(int s : num){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        int num = stack.pop();
        stack.push(3);
        stack.push(4);
        int num1 = stack.pop();
        int num2 = stack.pop();
        int num3 = stack.pop();
        System.out.println(num);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

    }
}
