package me.kimyelin.Data_Structure.linkedList;

import static me.kimyelin.Main.line;

//양방향 연결 리스트 (Doubly Linked List)
class NodeBi{
    int data;
    NodeBi next, prev;

    NodeBi(int data, NodeBi next, NodeBi prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList{
    NodeBi head;
    NodeBi tail;

    DoublyLinkedList(NodeBi node){  //처음 생성시에는 head와 tail이 같은 노드를 가리킴
        this.head = node;
        this.tail = node;
    }

    //head의 타입이 변경되었으므로 새로 오버라이드
    @Override
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }


    public void addData(int data, Integer beforeData){
        if(this.head == null){  //head에 데이터가 없을 경우 -> head 생성 후 추가
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;  //tail도 같은 노드를 가리킬 수 있도록 할당
        } else if(beforeData == null){  //가장 끝에 추가
            this.tail.next = new NodeBi(data, null, this.tail);  //기존의 끝 노드 next에 새로운 노드를 만들고
            this.tail = this.tail.next;  //끝이 추가되었으므로 링크리스트의 tail은 새로 생긴 노드를 가리킴
        } else {  //값을 찾아 넣을경우(중간)
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while(cur != null){
                if(cur.data == beforeData){  //해당 노드 앞에 추가할것
                    if(cur == this.head){  //기존의 head앞에 넣을 경우
                        this.head = new NodeBi(data, this.head, null);  //기존의 head는 새로운 노드를 가리키며
                        this.head.next.prev = this.head;  //밀려난 예전의 head의 next prev에 현재 새로 생긴 head를 가리킴
                    } else {
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }


    public void removeData(int data) {
        if(this.isEmpty()){
            System.out.println("list is empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = this.tail;

        while(cur != null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){ //지우고자 하는 노드가 하나인 경우
                    this.head = null;
                    this.tail = null;
                }else if(cur == this.head){  //head인 경우
                    this.head = cur.next;  //head를 다음으로 가리키고
                    this.head.prev = null;  //바뀐 head의 prev는 지움
                }else if(cur == this.tail){  //tail인 경우
                    this.tail = this.tail.prev;  //tail은 이전을 가리키고
                    this.tail.next = null;  //바뀐 tail의 next는 지움
                }else {  //가운데인 경우
                    pre.next = cur.next;  //이전의 next: 현재 --> 이전의 next: 현재의 next
                    cur.next.prev = pre;  //현재의 next의 prev(노드): 이전
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    @Override
    public void showData(){
        if(this.isEmpty()){
            System.out.println("list is mpty");
            return;
        }

        NodeBi cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void showDataTail(){
        if(this.isEmpty()){
            System.out.println("list is mpty");
            return;
        }

        NodeBi cur = this.tail;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args){
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();
        line();


        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();
        myList.showDataTail();
        line();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();
        myList.showDataTail();
        line();

        myList.removeData(100);
        myList.removeData(200);
        myList.removeData(300);
        myList.removeData(400);
        myList.removeData(500);
        myList.showData();
        myList.showDataTail();
        line();

        myList.removeData(1);
        myList.removeData(2);
        myList.removeData(3);
        myList.removeData(4);
        myList.removeData(5);
        myList.showData();
        myList.showDataTail();
        line();
    }
}
