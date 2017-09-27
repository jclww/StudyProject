package com.lww.algorithm.bTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Lww on 2017/9/26.
 */
public class BTree {
    private Node bTree;

    public BTree() {

    }

    public boolean insert(Object node) {
        int depth = 0;
        Node temp = new Node(node);
        temp.setDepth(depth);
        if (bTree == null) {
            bTree = temp;
            return true;
        }
        Node root = bTree;
        while (root != null) {
            if (root.hashCode() < temp.hashCode()) {
                depth++;
                if (root.right == null) {
                    temp.setDepth(depth);
                    root.right = temp;
                    return true;
                } else {
                    root = root.right;
                }
            } else {
                depth++;
                if (root.left == null) {
                    temp.setDepth(depth);
                    root.left = temp;
                    return true;
                } else {
                    root = root.left;
                }
            }
        }
        return true;
    }
    public void print() {
        int backup = 0;
        Queue<Node> queue = new LinkedList<Node>();
        Node root = bTree;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (backup == temp.getDepth()) {
                System.out.print(temp.data+"   ");
            } else {
                backup = temp.getDepth();
                System.out.println();
                System.out.print(temp.data+"   ");
            }
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BTree bTree = new BTree();
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            bTree.insert(random.nextInt(100));
//            bTree.insert(3);
        }

        bTree.print();
        System.out.println("      5");
//        System.out.println("     /");
//        System.out.println("    6");
//        System.out.println("     \\");
//        System.out.println("      9");



    }

}
class Node{
//    public Node parent;
    public Node left;
    public Node right;
    public Object data;
    public int depth;

    public Node(Object node) {
        this.data = node;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }

//    public boolean insert(Node node){
//        if (this == null) {
//            this = node;
//        }
//        return false;
//    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}