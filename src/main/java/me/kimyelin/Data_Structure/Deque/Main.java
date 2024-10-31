package me.kimyelin.Data_Structure.Deque;

//선형자료구조-데크

import java.util.ArrayDeque;
import java.util.Deque;

import static me.kimyelin.Main.line;

public class Main {
    public static void main(String[] args){
        Deque deque = new ArrayDeque();

        //Front 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);
        line();

        //Rear 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);
        line();

        //Front 출력
        System.out.println(deque.removeFirst());
        System.out.println(deque);
        line();

        //Rear 출력
        System.out.println(deque.removeLast());
        System.out.println(deque);
        line();

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);
        line();

        System.out.println(deque.pollLast());
        //System.out.println(deque.removeLast());
    }
}
