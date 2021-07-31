package com.xiaomi.daily_algorithm.daily02;

import java.util.Stack;

/**
 * @author quanhangbo
 * @date 2021/7/31 19:33
 */
public class SpecialStack {

    public static class MySpecialStack{
        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> min = new Stack<Integer>();

        public void push(int value){
            data.push(value);
            if(min.isEmpty()){
                min.push(value);
            }else{
                if(value < data.peek()){
                    min.push(value);
                }
            }
        }

        public int pop(){
            if(data.pop().equals(min.peek())){
                min.pop();
            }
            return data.pop();
        }

        public int getMinNum(){
            return min.peek();
        }

    }


    public static void main(String[] args){
        MySpecialStack specialStack = new MySpecialStack();
        specialStack.push(1);
        specialStack.push(2);
        specialStack.pop();
        System.out.println(specialStack.getMinNum());
    }
}
