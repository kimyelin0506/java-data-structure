package me.kimyelin.data_structure.linear.queue;
//Array를 이용한 큐 구현(원형 큐)
import static me.kimyelin.Main.line;

class MyQueue2{
    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size){
       arr = new int[size+1];
    }

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public boolean isFull(){
        return (this.rear +1)%this.arr.length == this.front;
    }

    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is full");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;  //원형으로 관리하기 위해
        this.arr[this.rear] = data;
    }

    public Integer dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue(){
        int start = (this.front+1)%this.arr.length;
        int end = (this.rear+1)% this.arr.length;

        for (int i = start; i != end; i=(i+1)%this.arr.length) {
            System.out.print(this.arr[i]+ " ");
        }
        System.out.println();
    }
}

public class Practice2 {
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
