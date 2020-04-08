package com.kealliang.laboratory.test;

/**
 * @author lsr
 * @ClassName TestClass
 * @Date 2020-04-07
 * @Vertion 1.0
 */
public class TestClass {
    public static class Node{
        private Node nextNode;
        private Integer data;
        public Node(Integer data) {
            this.data = data;
        }
        public void setNext(Node node) {
            this.nextNode = node;
        }
        public Node next() {
            return nextNode;
        }
        public Integer getData(){return data;}
    }

    public static Node swap(Node head) {
        if (head == null || head.next() == null) {
            return head;
        }
        Node newNode = head.next();
        head.setNext(swap(head.next().next()));
        newNode.setNext(head);
        return newNode;
    }

    public static void main(String[] args){
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        Node a3 = new Node(3);
        Node a4 = new Node(4);
        Node a5 = new Node(5);
        a1.setNext(a2);
        a2.setNext(a3);
        a3.setNext(a4);
        a4.setNext(a5);

        Node result = swap(a1);
        while(result != null) {
            System.out.println(result.getData());
            result = result.next();
        }

    }
}
