package me.kimyelin.data_structure.linear.queue;

import java.util.LinkedList;
import java.util.Queue;

import static me.kimyelin.Main.line;

//선형 자료구조-큐
public class Main {
    public static void main(String[] args){
        Queue queue = new LinkedList();  //queue가 인터페이스로 구현되어 있음

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue);
        line();

        System.out.println(queue.poll());
        System.out.println(queue);
        line();

        System.out.println(queue.poll());
        System.out.println(queue);
        line();

        System.out.println(queue.peek());
        System.out.println(queue);
        line();

        System.out.println(queue.contains(1));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        line();

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll());
    }
}
