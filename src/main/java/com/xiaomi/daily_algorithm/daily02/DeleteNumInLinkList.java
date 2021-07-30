package com.xiaomi.daily_algorithm.daily02;

import static com.xiaomi.daily_algorithm.daily02.ReversalLinkList.printLink;

/**
 * @author quanhangbo
 * @date 2021/7/29 23:16
 */
public class DeleteNumInLinkList {

    public static ReversalLinkList.Node deleteNumLinkList(ReversalLinkList.Node head, int num){
        // 处理头部可能是num的情况
        while(head != null){
            if(head.value == num){
                head = head.next;
            }else{
                break;
            }
        }
        // 剩下的情况就是头部不是num的情况
        ReversalLinkList.Node q = head;
        ReversalLinkList.Node p = q.next;
        while(p != null){
            if(p.value == num){
                q.next = p.next;
                p = q.next;
            }else{
                q = p;
                p = p.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ReversalLinkList.Node head = new ReversalLinkList.Node(4);
        head.next = new ReversalLinkList.Node(4);
        head.next.next = new ReversalLinkList.Node(4);
        head.next.next.next = new ReversalLinkList.Node(5);
        head.next.next.next.next = new ReversalLinkList.Node(6);
        ReversalLinkList.Node resultNode = deleteNumLinkList(head, 4);
        printLink(resultNode);
    }
}
