package me.kimyelin.data_structure.nonLinear.balanced_binary_search_tree_AVL;
//AVL tree - 삽입

import java.util.LinkedList;
import java.util.Queue;

import static me.kimyelin.Main.line;

class Node{
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.height = 0;
        this.left = left;
        this.right = right;
    }
}

class AVLTree {
    Node head;

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public Node rightRotate(Node node){
        Node lNode = node.left;

        node.left = lNode.right;
        lNode.right = node;
        //height 업데이트, 둘 중 높은 높이+1
        node.height = Math.max(height(node.left), height(node.right))+1;
        lNode.height = Math.max(height(lNode.left), height(lNode.right))+1;

        return lNode;
    }

    public Node leftRotate(Node node){
        Node rNode = node.right;

        node.right = rNode.left;
        rNode.left = node;

        node.height = Math.max(height(node.right), height(node.left))+1;
        rNode.height = Math.max(height(rNode.right), height(rNode.left))+1;
        return rNode;
    }

    public Node lrRotate(Node node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public Node rlRotate(Node node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public int getBalance(Node node){  //높이차
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public void insert(int key){
        this.head = insert(this.head, key);
    }

    private Node insert(Node node, int key){
        if(node == null){
            return new Node(key, null,null);
        }
        if(key == node.key){
            System.out.println("Already Data: "+key);
            return node;
        }
        if(key < node.key){
            node.left = insert(node.left, key);
        }else{
            node.right = insert(node.right, key);
        }

        node.height = Math.max(height(node.right), height(node.left))+1;
        int balance = getBalance(node);

        //LL
        if(balance > 1 && key < node.left.key){
            return rightRotate(node);
        }
        //RR
        if(balance < -1 && key > node.right.key){
            return leftRotate(node);
        }
        //LR
        if(balance > 1 && key > node.left.key){
            return lrRotate(node);
        }
        //RL
        if(balance < -1 && key < node.right.key){
            return rlRotate(node);
        }
        return node;
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key+" ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}
public class Practice1 {
    public static void main(String[] args){
        AVLTree avl = new AVLTree();

        avl.insert(30);
        avl.insert(20);
        avl.insert(10);
        avl.levelOrder(avl.head);
        line();


        avl.insert(40);
        avl.insert(50);
        avl.levelOrder(avl.head);
        line();

        avl.insert(5);
        avl.insert(7);
        avl.levelOrder(avl.head);
        line();

        avl.insert(60);
        avl.insert(55);
        avl.levelOrder(avl.head);
        line();


    }
}
