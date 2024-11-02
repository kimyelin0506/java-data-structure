package me.kimyelin.data_structure.nonLinear.binary_tree;

import static me.kimyelin.Main.line;

//Array를 이용한 이진 트리 구현, 순회
class BinaryTree{
    char[] arr;

    BinaryTree(char[] data){
        this.arr = data.clone();
    }

    //DFS-전위 순위: 현재 노드 -> 왼쪽 노드 -> 오른쪽 노드
    public void preOrder(int idx){
        //먼저 현재 노드 실행
        System.out.print(this.arr[idx]+ " ");
        int left = 2*idx+1;
        int right = 2*idx+2;

        //왼쪽 노드부터 실행
        if(left < this.arr.length){  //왼쪽 자식 노드 확인
            this.preOrder(left);  //재귀함수
        }
        //왼쪽 노드가 업으면 오른쪽 노드 실행
        if(right < this.arr.length){  //오른쪽 자식 노드 확인
            this.preOrder(right);
        }
    }

    //DFS-중위 순회: 왼쪽 노드 -> 현재 노드 -> 오른쪽 노드
    public void inOrder(int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length){
            this.inOrder(left);
        }
        System.out.print(this.arr[idx] + " ");
        if(right < this.arr.length){
            this.inOrder(right);
        }
    }

    //DFS-후위 순회: 왼쪽 노드 -> 오른쪽 노드 -> 현재 노드
    public void postOrder(int idx){
        int left = 2*idx+1;
        int right = 2*idx+2;

        if(left < this.arr.length){
            this.postOrder(left);
        }

        if(right < this.arr.length){
            this.postOrder(right);
        }
        System.out.print(this.arr[idx] + " ");
    }

    //BFS-레벨 순회: (위쪽 레벨부터) 왼쪽 노드 -> 오른쪽 노드
    public void levelOrder(int idx){
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }

}

public class Practice1 {
    public static void main(String[] args){
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A'+i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();
        line();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();
        line();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();
        line();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
        line();


    }
}
