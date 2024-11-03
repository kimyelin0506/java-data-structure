package me.kimyelin.data_structure.nonLinear.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

import static me.kimyelin.Main.line;

//앞의 BST 삽입, 삭제 코드를 제귀형태로 구현
class BinarySearchTree2{
    Node head;

    public BinarySearchTree2(int key) {
        this.head = new Node(key, null,null);
    }

    public Node searchNode(int key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(this.head);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.key == key){
                return cur;
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
        return null;
    }
    //재귀 함수
    public Node addNodeRecursive(Node cur, int key){
        if(this.searchNode(key) != null){
            System.out.println("same key: "+ key);
            return this.head;
        }
        if(cur == null){
            return new Node(key, null,null);
        }

        if(key < cur.key){
            cur.left = addNodeRecursive(cur.left, key);
        }else{
            cur.right = addNodeRecursive(cur.right, key);
        }
        return cur;
    }

    //재귀 함수
    public Node removeNodeRecursive(Node cur, int key){
        if(this.searchNode(key) == null){
            System.out.println("Not found key: "+ key);
            return this.head;
        }
        if(cur == null){
            return null;
        }
        if(key < cur.key){
            cur.left = removeNodeRecursive(cur.left, key);
        }else if(key > cur.key){
            cur.right = removeNodeRecursive(cur.right, key);
        }else{
            if(cur.left == null){  //삭제하려는 노드의 왼쪽 자식이 없는 경우
                return cur.right;
            }else if(cur.right == null){ //삭제하려는 노드의 오른쪽 자식이 없는 경우
                return cur.left;
            }else{
                Node predecessor = cur;
                Node successor = cur.left;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }

                predecessor.right = successor.left;
                cur.key = successor.key;  //링크로직 대신 해당 노드 자리 위치에 데이터만 바꿈
            }
        }
        return cur;
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

public class Practice1 {
    public static void main(String[] args){
        BinarySearchTree2 bst = new BinarySearchTree2(20);
        bst.head = bst.addNodeRecursive(bst.head, 10);
        bst.head = bst.addNodeRecursive(bst.head, 30);
        bst.head = bst.addNodeRecursive(bst.head, 1);
        bst.head = bst.addNodeRecursive(bst.head, 15);
        bst.head = bst.addNodeRecursive(bst.head, 25);
        bst.head = bst.addNodeRecursive(bst.head, 13);
        bst.head = bst.addNodeRecursive(bst.head, 35);
        bst.head = bst.addNodeRecursive(bst.head, 27);
        bst.head = bst.addNodeRecursive(bst.head, 40);
        bst.head = bst.addNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);
        line();

        bst.head = bst.removeNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);
        line();
        bst.head = bst.removeNodeRecursive(bst.head, 25);
        bst.levelOrder(bst.head);
        line();
        bst.head = bst.removeNodeRecursive(bst.head, 20);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head, 10000);

    }
}
