package me.kimyelin.Data_Structure.linkedList;
//원형연결 리스트(Circular Linked List) 구현

import static me.kimyelin.Main.line;

class CircularLinkedList{
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node){
        this.head = node;
        this.tail = node;
        //자기 자신으로 순환할 수 있도록 원형 형태
        node.next = this.head;
        node.prev = this.tail;
    }

    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
    //연결리스트에 데이터 추가
    //before_data가 null인 경우, 가장 뒤에 추가
    //before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData){
        if(this.head == null){
            NodeBi newNodeBi = new NodeBi(data, null, null);
            this.head = newNodeBi;
            this.tail = newNodeBi;
            newNodeBi.next = newNodeBi;
            newNodeBi.prev = newNodeBi;
        }else if(beforeData == null){
            NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
            this.tail.next = newNodeBi;
            this.head.prev = newNodeBi;
            this.tail = newNodeBi;
        } else{
            NodeBi cur = this.head;
            NodeBi pre = cur;
            do{
                if(cur.data == beforeData){
                    if(cur == this.head){
                        NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
                        this.tail.next = newNodeBi;
                        this.head.prev = newNodeBi;
                        this.head = newNodeBi;
                    }else{  //node가 중간에 추가
                        NodeBi newNodeBi = new NodeBi(data, cur, pre);
                        pre.next = newNodeBi;
                        cur.prev = newNodeBi;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            } while(cur != this.head);
        }
    }
    //연결리스트에서 특정 값을 가지는 노드 삭제
    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("list is Empty");
            return;
        }
        NodeBi cur = this.head;
        NodeBi pre = cur;

        while(cur!= null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){  //처음이자 마지막-> 한개
                    this.head = null;
                    this.tail = null;
                }else if(cur == this.head){
                    cur.next.prev = this.head.prev;  //tail
                    this.head = cur.next;
                    this.tail.next = this.head;
                }else if(cur == this.tail){
                    pre.next = this.tail.next;
                    this.tail = pre;
                    this.head.prev = this.tail;
                }else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre=cur;
            cur = cur.next;
        }
    }

    public void showData(){
        if(this.isEmpty()){
            System.out.println("list is Empty");
            return;
        }

        NodeBi cur = this.head;
        while(cur.next != this.head){  //주의
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println(cur.data);  //가장 끝은 출력이 안되므로
    }
}
public class Practice3 {
    public static void main(String[] args){
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));
        myList.showData();
        line();


        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();
//        myList.showDataTail();
        line();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();
//        myList.showDataTail();
        line();

        myList.removeData(100);
        myList.removeData(200);
        myList.removeData(300);
        myList.removeData(400);
        myList.removeData(500);
        myList.showData();
//        myList.showDataTail();
        line();

        myList.removeData(1);
        myList.removeData(2);
        myList.removeData(3);
        myList.removeData(4);
        myList.removeData(5);
        myList.showData();
//        myList.showDataTail();
        line();

    }
}
