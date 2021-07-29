package com.xiaomi.daily_algorithm.daily02;

/**
 * @author quanhangbo
 * @date 2021/7/28 23:19
 */
public class ReversalLinkList {

    public static class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static class DoubleNode{
        int value;
        DoubleNode prior;
        DoubleNode next;
        public DoubleNode(int value){
            this.value = value;
        }
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static Node reversalLink(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reversalDoubleLink(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.prior = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLink(Node head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLink(DoubleNode head){
        while(head != null){
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        Node head = reversalLink(node);


        DoubleNode doubleNode = new DoubleNode(8);
        doubleNode.next = new DoubleNode(7);
        doubleNode.next.prior = doubleNode;
        doubleNode.next.next = new DoubleNode(6);
        doubleNode.next.next.prior = doubleNode.next;

        DoubleNode doubleHead = reversalDoubleLink(doubleNode);
        printLink(head);
        printDoubleLink(doubleHead);
    }
}
