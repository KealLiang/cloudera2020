package com.kealliang.laboratory.algorithm.datastructure;

import com.kealliang.laboratory.algorithm.data.Node;
import com.kealliang.laboratory.algorithm.data.Tree;

import java.util.function.Consumer;

/**
 * @author lsr
 * @ClassName Link
 * @Date 2021-03-19
 * @Vertion 1.0
 */
public class Link {
    public static void main(String[] args) {
        Node head = Node.build("1", "2", "3", "3", "4");
        traverse(head, p -> System.out.println(p.data));
//        traverseRecursion(head, p -> System.out.println(p.data));
    }

    /**
     * 前序递归二叉树
     * @author lsr
     * @description traverse
     * @Date 2021/3/21
     */
    static void traverse(Tree root, Consumer<? super Tree> func) {
        func.accept(root);
        traverse(root.left, func);
        traverse(root.right, func);
    }

    /**
     * 遍历node
     * @author lsr
     * @description traverse
     * @Date 2021/3/19
     */
    static void traverse(Node head, Consumer<? super Node> func) {
        for (Node p = head; p != null; p = p.next) {
            func.accept(p);
        }
    }

    /**
     * 递归遍历node
     * @author lsr
     * @description traverseRecursion
     * @Date 2021/3/19
     */
    static void traverseRecursion(Node head, Consumer<? super Node> func) {
        if (head == null) {
            return;
        }
        func.accept(head);
        traverseRecursion(head.next, func);
    }
}
