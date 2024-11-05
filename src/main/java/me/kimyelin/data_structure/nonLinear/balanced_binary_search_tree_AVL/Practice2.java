package me.kimyelin.data_structure.nonLinear.balanced_binary_search_tree_AVL;
//AVL Tree 삭제

import static me.kimyelin.Main.line;

class AVLTree2 extends AVLTree{

    public void delete(int key){
        this.head = delete(this.head, key);
    }

    private Node delete(Node node, int key){
        if(node == null){
            return null;
        }
        if(key < node.key){
            node.left = delete(node.left, key);
        }else if(key > node.key){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                Node predecessor = node;
                Node successor = node.left;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }

                predecessor.right = successor.left;
                node.key = successor.key;
            }
        }
        node.height = Math.max(height(node.left), height(node.right))+1;

        int balance = getBalance(node);
        //LL: 현재 노드의 왼쪽 노드의 높이를 확인하여 LL인지 LR인지 구준
        if(balance > 1 && getBalance(node.left) > 0){
            return rightRotate(node);
        }
        //RR
        if(balance < -1 && getBalance(node.right) < 0){
            return leftRotate(node);
        }
        //LR
        if(balance > 1 && getBalance(node.left) < 0){
            return lrRotate(node);
        }
        //RL
        if(balance < -1 && getBalance(node.right) > 0){
            return rlRotate(node);
        }
        return node;
    }
}

public class Practice2 {
    public static void main(String[] args){
        AVLTree2 avl = new AVLTree2();

        avl.insert(30);
        avl.insert(20);
        avl.insert(40);
        avl.insert(10);
        avl.insert(10);
        avl.levelOrder(avl.head);
        line();

        avl.delete(40);
        avl.levelOrder(avl.head);
        line();

        avl.insert(40);
        avl.delete(10);
        avl.levelOrder(avl.head);
        line();

        avl.insert(25);
        avl.delete(40);
        avl.levelOrder(avl.head);
        line();

        avl.insert(27);
        avl.delete(20);
        avl.levelOrder(avl.head);
    }
}
