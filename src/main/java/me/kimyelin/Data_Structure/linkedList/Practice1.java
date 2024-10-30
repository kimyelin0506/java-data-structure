package me.kimyelin.Data_Structure.linkedList;

import static me.kimyelin.Main.line;

//단순 연결리스트 구현 완료
class LinkedList2 extends LinkedList{
    LinkedList2(Node node){
        this.head = node;  //상속받은 부모 클래스의 변수에다 할당 super
    }

    //연결리스트에 데이터 추가
    // before_data가 null인 경우 -> 가장 뒤에 추가
    // before_data에 값이 있는 경우 -> 해당 값을 가진 노드 앞에 추가

    public void addData(int data, Integer beforeData){  //beforeData 앞에 data가 위치함
        if(this.head == null){
            this.head = new Node(data, null);
        } else if (beforeData == null){
            Node cur = this.head;
            while(cur.next != null){  //마지막 노드까지
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else{
            Node cur = this.head;
            Node pre = cur;
            while(cur != null){
                if(cur.data == beforeData){//beforeData를 가진 노드를 찾으면 그 앞에 데이터를 추가하는 경우
                    if(cur == this.head){  //가장 앞이 head였을 경우
                        this.head = new Node(data, this.head); //head에 새로운 노드를 만들고, 그 다음(next)는 헤더였던 것이 들어감
                    }else {  //중간에 들어가는 경우
                        pre.next = new Node(data, cur);  //노드를 새로 만들어서 이전 노드의 다음은 새로운 데이터 노드, 새로운 노드의 다음 노드는 cur임
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data){  //data에 해당되는 것을 지울 것임
        if(this.isEmpty()){
            System.out.println("list is empty");
            return;
        }
        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur.data == data){  //현재 데이터가 지우고자하는 데이터와 같다면
                if(cur == this.head){  //만약 현재 데이터가 head라면
                    this.head = cur.next;  //바뀌는 head는 현재의 next 노드가 되며
                }else{  //head가 아니라면
                    pre.next = cur.next;  //과거의 next노드는 현재의 노드가 아닌 현재의 next노드를 입력받음
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}
public class Practice1 {
    public static void main(String[] args){
        LinkedList2 myList = new LinkedList2(new Node(1, null));

        myList.showData();
        line();

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();
        line();

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();
        line();

        myList.removeData(100);
        myList.removeData(200);
        myList.removeData(300);
        myList.removeData(400);
        myList.removeData(500);
        myList.showData();
        line();

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();

    }
}
