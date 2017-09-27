package com.lww.algorithm.bTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Lww on 2017/9/26.
 */
public class BalanceTree {
    private BalanceNode bTree;

    public boolean insert(Object node) {
        int depth = 0;
        int bf = 0;
        BalanceNode temp = new BalanceNode(node);
        temp.setDepth(depth);
        temp.bf = 0;
        if (bTree == null) {
            bTree = temp;
            return true;
        }
        BalanceNode root = bTree;
        while (root != null) {
            if (root.hashCode() < temp.hashCode()) {
                depth++;
                if (root.right == null) {
                    temp.setDepth(depth);
                    temp.parent = root;
                    root.right = temp;

                    /** 平衡 **/
                    if (root.bf == 0) {
                        root.bf+=1;
                    } else if (root.bf == -1) {
                        root.bf -=1;
                    } else {
                        //需要平衡

                    }





                    return true;
                } else {
                    root = root.right;
                }
            } else {
                depth++;
                if (root.left == null) {
                    temp.setDepth(depth);
                    temp.parent = root;
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
        Queue<BalanceNode> queue = new LinkedList<BalanceNode>();
        BalanceNode root = bTree;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BalanceNode temp = queue.poll();
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
        BalanceTree bTree = new BalanceTree();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
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
class BalanceNode{
    public BalanceNode parent;
    public BalanceNode left;
    public BalanceNode right;
    public Object data;
    public int depth;
    public int bf; //balance factor 平衡因子



    public BalanceNode(Object node) {
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