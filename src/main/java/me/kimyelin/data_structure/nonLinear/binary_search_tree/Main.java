package me.kimyelin.data_structure.nonLinear.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

import static me.kimyelin.Main.line;

class Node{
    int key;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree{
    Node head;

    BinarySearchTree(int key){
        this.head = new Node(key, null, null);
    }

    public boolean searchNode(int key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.key == key){
                return true;
            }
            if(key < cur.key){
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }else{
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return false;
    }

    public void addNode(int key){
        if(this.searchNode(key)){
            System.out.println("same key: "+ key);
            return;
        }

        if(this.head == null){
            this.head = new Node(key, null, null);
        }else{
            Node cur = this.head;
            while(true){
                Node pre = cur;

                if(key < cur.key){  //추가하려는 키값과 기존의 키값을 비교
                    cur = cur.left;
                    if (cur == null) {
                        pre.left = new Node(key, null,null);
                        break;
                    }
                }else {
                    cur = cur.right;
                    if(cur == null){
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }


    }

    public void removeNode(int key){
        Node parent = null;  //부모 노드
        Node successor = null;  //지울려는 노드 대상 대신 넣을 후계자 노드
        Node predecessor = null;  //후계자 노드의 부모 노드
        Node child = null;  //후계자 노드의 자식 노드

        Node cur = this.head;
        while(cur != null){
            if(key == cur.key){
                break;
            }

            parent = cur;
            if(key < cur.key){
                cur = cur.left;
            }else {
                cur = cur.right;
            }
        }
        if(cur == null){
            System.out.println("Not found key: "+key);
            return;
        }
        if(cur.left == null && cur.right == null){  //case1: leaf node
            if(parent == null){
                this.head = null;
            }else{
                if(parent.left == cur){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
        }else if((cur.left != null && cur.right == null)
                || (cur.left == null && cur.right != null)){  //case2: 자식 노드가 하나인 경우
            if(cur.left != null){
                child = cur.left;
            }else{
                child = cur.right;
            }

            if(parent == null){  //root, 자식 노드 1개
                this.head = child;
            }else{
                if(parent.left == cur){
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }
        } else{  //case3: 자식노드가 둘
            predecessor = cur;
            successor = cur.left;  //좌측 노드에서 가장 큰 노드를 찾기 방법
            while(successor.right != null){
                predecessor = successor;
                successor = successor.right;
            }

            predecessor.right = successor.left; //후계자 노드의 부모노드의 오른쪽 노드 = 후계자노드의 왼쪽 노드
            successor.left = cur.left;
            successor.right = cur.right;

            if(parent == null){  //root, 자식 노드 2개
                this.head = successor;
            }else{
                if(parent.left == cur){
                    parent.left = successor;
                }else{
                    parent.right = successor;
                }
            }
        }
    }

    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
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

public class Main {
    public static void main(String[] args){
        //node add
        System.out.println("== add ==");
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.addNode(40);
        bst.levelOrder(bst.head);
        line();
        //node remove
        System.out.println("== remove ==");
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        line();
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        line();
        bst.removeNode(20);
        bst.levelOrder(bst.head);
        line();
        bst.removeNode(1000);
    }
}
