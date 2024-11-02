package me.kimyelin.data_structure.linear.Deque;

import java.util.ArrayList;

import static me.kimyelin.Main.line;

//ArrayList를 이용한 구현
class MyDeque1{
    ArrayList list;

    MyDeque1(){
        list = new ArrayList();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void addFirst(int data){
        this.list.add(0, data);
    }

    public void addLast(int data){
        this.list.add(data);
    }

    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }
        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }

    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println("Deque is empty");
            return null;
        }

        int data = (int)this.list.get(this.list.size()-1);
        this.list.remove(this.list.size()-1);
        return data;
    }

    public void printDeque(){
        System.out.println(list);
    }
}

public class Practice1 {
    public static void main(String[] args){
        MyDeque1 deque = new MyDeque1();

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
