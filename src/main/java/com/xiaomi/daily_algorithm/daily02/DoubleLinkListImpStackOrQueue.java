package com.xiaomi.daily_algorithm.daily02;

/**
 * @author quanhangbo
 * @date 2021/7/31 15:44
 */
public class DoubleLinkListImpStackOrQueue {


    /**
     * 使用双向链表实现栈和队列结构
     * @param args
     */
    public static void main(String[] args){
        MyStack<Integer> stack = new MyStack<Integer>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        int num = stack.pop();
        System.out.println(num);

        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        int result = queue.pop();
        System.out.println(result);

    }

    public static class Node<T>{
        T value;
        Node last;
        Node next;
        public Node(T value){
            this.value = value;
        }
    }


    public static class DoubleEndsQueue<T>{
        Node<T> head;
        Node<T> tail;

        public void addFromHead(T value){
            Node<T> cur = new Node<T>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromBottom(T value){
            Node<T> cur = new Node<T>(value);
            if(head == null){
                head = cur;
                tail = cur;
            }else{
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public T popFromHead(){
            Node<T> cur = head;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        public T popFromTail(){
            Node<T> cur = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty(){
            return head == null;
        }

    }

    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack(){
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue(){
            queue = new DoubleEndsQueue<T>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return queue.popFromTail();
        }
    }



}
