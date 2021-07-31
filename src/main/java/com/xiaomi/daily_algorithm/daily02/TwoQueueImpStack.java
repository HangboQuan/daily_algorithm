package com.xiaomi.daily_algorithm.daily02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author quanhangbo
 * @date 2021/7/31 20:04
 */
public class TwoQueueImpStack {

    /**
     * 两个队列实现栈的思路：
     *  用两个栈：queue和help队列，push数据的时候直接将数据push进queue中去
     *  pop数据的时候：
     *      首先将queue中除过队尾的元素，剩余所有的元素全部add进help中去，剩下队尾的元素就是
     *      需要pop的数据，然后将help中的数据全部add进queue队列中去，再重新创建一个新的没有任何元素
     *      的help队列即可
     */
    private static class MyStack{
        Queue<Integer> queue;
        Queue<Integer> help;

        public MyStack(){
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int value){
            queue.add(value);
        }

        public int pop(){
            int num = 0;
            while(num < queue.size() - 1){
                num++;
                help.add(queue.poll());
            }
            int result = queue.poll();
            while(!help.isEmpty()){
                queue.add(help.poll());
            }
            help = new LinkedList<Integer>();
            return result;
        }

    }

    public static void main(String[] args){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
