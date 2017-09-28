package com.lww.algorithm.bTree.lww;

/**
 * Created by Lww on 2017/9/28.
 */
public class TestBalance {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            
        }
//        for (int j = 0; j < 10; j++) {
            BalancedBinaryTree binaryTree = new BalancedBinaryTree();
            long begin = System.currentTimeMillis();
            for (int i = 0; i < Integer.MAX_VALUE >> 7; i++) {
                binaryTree.insert(i);
            }
            long end = System.currentTimeMillis();
            System.out.println(end - begin+"\nSize:"+binaryTree.getSize());
//            binaryTree.setRoot(null);
//        }
//        long begin = System.currentTimeMillis();
//
//        HashMap map = new HashMap();
//        for (int i = 0; i < Integer.MAX_VALUE >> 7; i++) {
//            map.put(i,i);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - begin+"\nSize:"+map.size());

    }
}
