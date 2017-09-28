package com.lww.algorithm.bTree.learn;

import java.util.Random;

/**
 * Created by Lww on 2017/9/27.
 */
public class Test {
    public static void main(String[] args) {
        BalanceBiTree<Integer> tree = new BalanceBiTree<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {

        }
//        tree.insert(6);
//        tree.insert(5);
//        tree.printTree();
//
//        tree.insert(4);
//
//        tree.printTree();
//        tree.insert(3);
//
//        tree.printTree();
//        tree.insert(2);
//
//        tree.printTree();
//        tree.insert(1);
//        for (int j = 0; j < 10; j++) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < Integer.MAX_VALUE >> 7; i++) {
                tree.insert(i);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - begin+"\nSize:"+tree.getSize());
//            tree.setRoot(null);
//        }
//        tree.print();
//        System.out.println(tree.getSize());
//        tree.printTree();
//
//        tree.insert(16);
//        tree.insert(23);
//        System.out.println(tree.getSize());
//        tree.printTree();
//        tree.insert(26);
//        System.out.println(tree.getSize());
//        tree.printTree();
//        tree.insert(31);
//        System.out.println(tree.getSize());
//        tree.printTree();
//
//        tree.insert(22);
//        System.out.println(tree.getSize());
//
//        tree.printTree();

    }
}
