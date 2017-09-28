package com.lww.algorithm.bTree.lww;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Lww on 2017/9/28.
 */
public class BalancedBinaryTree {
    public void setRoot(Node root) {
        this.root = root;
    }

    private Node root;
    private int size;

    BalancedBinaryTree() {
        this.size = 0;
    }

    public void insert(Object date) {
        if(this.root==null){
            this.root = new Node(date);
            this.size++;
        } else {
            addNode(root,date);
        }
    }

    private boolean addNode(Node root, Object date) {
        boolean statu;
        if (date.hashCode() < root.data.hashCode()) {
            if (root.left != null) {
                statu = addNode(root.left,date);
                if (statu) {
                    if (compare(root.left, root.right) == 2) {
                        if (date.hashCode() < root.left.data.hashCode()) {
                            //LL型
                            rotateWithLeftChild(root);
                        } else {
                            //LR型
                            doubleWithLeftChild(root);
                        }
                    }
                    return false;
                }
            } else {
                Node node= new Node(date,root);
                root.left = node;
                this.size++;
            }
        } else if (date.hashCode() > root.data.hashCode()) {
            if (root.right != null) {
                statu = addNode(root.right,date);
                if (statu) {
                    if (compare(root.right, root.left) == 2) {
                        if (date.hashCode() > root.right.data.hashCode()) {
                            //RR型
                            rotateWithRightChild(root);
                        } else {
                            //RL型
                            doubleWithRightChild(root);
                        }
                    }
                    return false;
                }
            } else {
                Node node= new Node(date,root);
                root.right = node;
                this.size++;
            }
        } else {
            if (date == root.data) {
                return false;
            } else {
                root.data = date;
                return false;
            }
        }
        root.height=getMaxHeight(root);
        return true;
    }
    /** 比较左右子树 **/
    private int compare(Node height, Node height1) {
        int num1 = height == null ? 0 : height.height;
        int num2 = height1 == null ? 0 : height1.height;
        return num1-num2;

    }

    private void rotateWithRightChild(Node nd) {
        Node top = nd.right;
        nd.right = top.left;
        if(top.left!=null)
            top.left.parent = nd;
        top.left = nd;
        top.parent = nd.parent;
        if(nd.parent!=null){
            if(nd.parent.left == nd)
                nd.parent.left = top;
            else
                nd.parent.right = top;
        }else{
            this.root = top;
        }
        nd.height = getMaxHeight(nd);
        top.height = getMaxHeight(top);
        nd.parent = top;
    }

    private void rotateWithLeftChild(Node nd) {
        Node top = nd.left;
        nd.left = top.right;
        if(top.right!=null)
            top.right.parent = nd;
        top.right = nd;
        top.parent = nd.parent;
        if(nd.parent!=null){
            if(nd.parent.left == nd)
                nd.parent.left = top;
            else
                nd.parent.right = top;
        }else{
            this.root = top;
        }
        nd.height = getMaxHeight(nd);
        top.height = getMaxHeight(top);
        nd.parent = top;

    }

    private void doubleWithRightChild(Node nd) {
        rotateWithRightChild(nd.right);
        rotateWithLeftChild(nd);
    }

    private void doubleWithLeftChild(Node nd) {
        rotateWithLeftChild(nd.left);
        rotateWithRightChild(nd);
    }

    /** 获取左右子树中最大值 **/
    private int getMaxHeight(Node nd) {
        return Math.max((nd.left == null) ? 0 : nd.left.height, (nd.right == null) ? 0 : nd.right.height)+1;
    }

    public void print() {
        int backup = 0;
        Queue<Node> queue = new LinkedList<Node>();
        Node root = this.root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
//            if (backup == temp.getDepth()) {
//                System.out.print(temp.data+"   ");
//            } else {
//                backup = temp.getDepth();
//                System.out.println();
//                System.out.print(temp.data+"   ");
//            }
            System.out.print(temp.data+"   ");

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    /** Node **/
    private final class Node {
        public Node parent;
        public Node left;
        public Node right;


        public Object data;
        public int height;

        Node(Object data){
            this(data,null);
        }

        public Node(Object date, Node parent) {
            this(parent,null,null,date,1);
        }

        public Node(Node parent, Node left, Node right, Object data, int height) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.data = data;
            this.height = height;
        }
    }
}
