package com.kealliang.laboratory.algorithm.data;

/**
 * @author lsr
 * @ClassName Node
 * @Date 2021-03-19
 * @Vertion 1.0
 */
public class Node {
    public String data;
    public Node next;

    /**
     * 构造链表
     * @author lsr
     * @description build
     * @Date 2021/3/19
     */
    public static Node build(String... datas) {
        if (datas == null) {
            return null;
        }
        Node[] nodes = new Node[datas.length + 1];
        for (int i = datas.length - 1; i >= 0; i--) {
            Node node = new Node();
            node.data = datas[i];
            node.next = nodes[i + 1];
            nodes[i] = node;
        }
        return nodes[0];
    }
}
