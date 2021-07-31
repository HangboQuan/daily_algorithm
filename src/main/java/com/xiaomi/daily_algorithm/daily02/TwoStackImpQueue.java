package com.xiaomi.daily_algorithm.daily02;

import java.util.Stack;

/**
 * @author quanhangbo
 * @date 2021/7/31 20:45
 */
public class TwoStackImpQueue {

    /**
     * 两个栈实现队列的必要条件是：
     * 首先push栈作为辅助栈，pop栈作为主栈
     *  1.pop栈必须为空，才能push数据
     *  2.push栈pop数据的时候必须一次性pop完，使push栈为空
     */
    public static class MyQueue{
        Stack<Integer> push;
        Stack<Integer> pop;

        public MyQueue(){
            push = new Stack<Integer>();
            pop = new Stack<Integer>();
        }

        public void pushToPop(){
            if(pop.isEmpty()){
                while(!push.isEmpty()){
                    pop.push(push.pop());
                }
            }
        }

        public void add(int value){
            push.push(value);
            pushToPop();
        }

        public int poll(){
            if(push.empty() && pop.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return pop.pop();
        }

        public int peek(){
            if(push.empty() && pop.empty()){
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return pop.peek();
        }
    }
    public static void main(String[] args){

        /**
         * 这样的要求就不能实现，因为不满足必要条件
         */
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.poll();
        myQueue.add(3);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

    }
}
