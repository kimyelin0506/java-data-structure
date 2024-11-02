package me.kimyelin.data_structure.linear.queue;

import java.util.ArrayList;

import static me.kimyelin.Main.line;

//ArrayList를 이용한 queue 구현
class MyQueue1{
    ArrayList list;

    MyQueue1(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        if(this.list.size() == 0){
            return true;
        }
        return false;
    }

    public void push(int data){
        this.list.add(data);
    }

    public Integer pop(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return null;
        }

        int data = (int) this.list.get(0);  //generic되어 있지 않으므로
        this.list.remove(0);
        return data;
    }

    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("list is empty");
            return null;
        }

        return (int) this.list.get(0);
    }

    public void printQueue(){
        System.out.println(this.list);
    }
}

public class Practice1 {
    public static void main(String[] args){
        MyQueue1 myQueue = new MyQueue1();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        myQueue.printQueue();
        line();

        System.out.println(myQueue.peek());
        myQueue.printQueue();
        line();

        System.out.println(myQueue.pop());
        myQueue.printQueue();
        line();

        System.out.println(myQueue.pop());
        myQueue.printQueue();
        line();

        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.printQueue();
    }
}
