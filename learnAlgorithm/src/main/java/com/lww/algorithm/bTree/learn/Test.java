package com.lww.algorithm.bTree.learn;

import java.util.Random;

/**
 * Created by Lww on 2017/9/27.
 */
public class Test {
    public static void main(String[] args) {
        BalanceBiTree<Integer> tree = new BalanceBiTree<>();
        Random random = new Random();
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
        for (int i = 0; i < 100; i++) {
            tree.insert(random.nextInt(10));
        }
        System.out.println(tree.getSize());
        tree.printTree();
    }
}
