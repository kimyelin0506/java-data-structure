package me.kimyelin.data_structure.linear.linkedList;
// 선형 자료구조 - 연결리스트
// 단순 연결 리스트(simple ver.) 기본 구조 구현

import static me.kimyelin.Main.line;

//노드
class Node{
    int data;
    Node next;  //다음 노드를 가르킬 때 사용

    Node(){}
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList{
    Node head;  //head 역할

    LinkedList(){}
    LinkedList(Node node){
        this.head = node;
    }

    //연결리스트 비어있는지 확인
    public boolean isEmpty(){
        if (this.head == null){
            return true;
        }
        return false;
    }

    //연결리스트의 맨 뒤에 데이터 추가
    public void addData(int data){
        if (this.head == null){  //앞에 아무런 노드가 없을 경우, 맨처음 head로 잡아줌
            this.head = new Node(data, null);  //마지막에 들어오면 후의 노드는 없으므로 null
        } else {  //노드들이 있다면
            Node cur = this.head;
            while(cur.next != null){  //head부터 끝까지 순회하면서 돌음
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    //연결리스트의 맨 뒤의 데이터 삭제
    public void removeData(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return;
        }
        Node cur = this.head; //끝까지 돌려서 얻을 노드
        Node prev = cur;  //끝-1에서 얻을 노드

        while(cur.next != null){
            prev = cur;  //cur보다 하나 이전을 prev가 쫓아다님
            cur = cur.next;
        }

        if(cur == this.head){  //만약 cur의 뒤에 아무것도 없다면
            this.head = null;  //자동적으로 자바가 메모리를 관리하기 때문에(null) 링크부분만 관리
        }else{
            prev.next = null;
        }
    }

    //연결리스트에서 데이터 찾기
    public void findData(int data){
        if (this.isEmpty()){
            System.out.println(" list is empty");
            return;
        }

        Node cur = this.head;
        while(cur != null){
            if(cur.data == data){
                System.out.println("data exist: "+ cur.data);
                return;
            }
            cur = cur.next;
        }
        System.out.println("data not found: "+ data);
    }

    //연결리스트의 모든 데이터 출력
    public void showData(){
        if (this.isEmpty()){
            System.out.println(" list is empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args){
        LinkedList myList = new LinkedList(new Node(1, null));

        myList.showData();
        line();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();
        line();

        myList.findData(3);
        myList.findData(100);
        line();

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();
        line();

        myList.removeData();
        myList.removeData();
        myList.removeData();
    }
}
