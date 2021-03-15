package com.kealliang.laboratory.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 合并两个有序的链表
 * @author lsr
 * @ClassName Test
 * @Date 2021-03-11
 * @Vertion 1.0
 */
public class MergeOrderedLink {

    public static void main(String[] args) {
        Node a3 = new Node("9a", null);
        Node a2 = new Node("2a", a3);
        Node a1 = new Node("1a", a2);

        Node b4 = new Node("5b", null);
        Node b3 = new Node("4b", b4);
        Node b2 = new Node("3b", b3);
        Node b1 = new Node("2b", b2);

        Node head = mergeOrderedLink(a1, b1);

        while(head!=null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static Node mergeOrderedLink(Node a, Node b) {
        // 总共4个指针，head, tail, a, b
        Node head = new Node("head", null), tail;
        tail = head;
        while(a!=null && b!=null) {
            if(a.data.compareTo(b.data)<=0) { // 小的在前
                tail.next = a; // 取a接上，然后a往后移
                a = a.next;
            }else {
                tail.next = b; // 取b接上，然后b往后移
                b = b.next;
            }
            tail = tail.next;
        }
        if(a==null) {
            tail.next = b;
        }
        if (b==null) {
            tail.next = a;
        }
        return head;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Node {
        private String data;
        private Node next;
    }
}
