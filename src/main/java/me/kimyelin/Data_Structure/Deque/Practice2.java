package me.kimyelin.Data_Structure.Deque;
//Array를 이용한 구현
import com.sun.security.jgss.GSSUtil;

import static me.kimyelin.Main.line;

class MyDeque2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyDeque2(int size){
        arr = new int[size+1]; //원형
    }

    public boolean isEmpty(){
        return this.front == this.rear;
    }

    public boolean isFull(){
        return (this.rear+1)%this.arr.length == this.front;
    }

    public void addFirst(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.arr[this.front] = data;
        this.front = (this.front-1 + this.arr.length) % this.arr.length;
        //front가 앞에 0을 가리키고 있을 때, 원형으로 다음을 가리키기 위한 계산
    }

    public void addLast(int data){
        if(this.isFull()){
            System.out.println("Deque is full");
            return;
        }
        this.rear = (this.rear+1)%this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }

        this.front = (this.front+1)%this.arr.length;
        return this.arr[this.front];
    }

    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        int data = this.arr[this.rear];
        this.rear = (this.rear-1 +this.arr.length)%this.arr.length;
        return data;
    }

    public void printDeque(){
        int start = (this.front+1)%this.arr.length;
        int end = (this.rear+1)%this.arr.length;

        for (int i = start; i != end ; i = (i+1)%this.arr.length) {
            System.out.print(this.arr[i]+ " ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args){
        MyDeque2 deque = new MyDeque2(5);

        //Front 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.printDeque();
        line();

        //Rear 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        deque.printDeque();
        line();

        //Front 출력
        System.out.println(deque.removeFirst());
        deque.printDeque();
        line();

        //Rear 출력
        System.out.println(deque.removeLast());
        deque.printDeque();
        line();

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        deque.printDeque();
        line();

    }
}
