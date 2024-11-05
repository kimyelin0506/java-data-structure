package me.kimyelin.data_structure.nonLinear.priority_queue;
// 연결리스트를 이용한 우선 순위 큐
// 자바 기본 제공 PriorityQueue

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

import static me.kimyelin.Main.line;

public class Main {
    public static void enqueue(LinkedList<Integer> list, int data){
        int idx = list.size();  //가장 끝
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > data){  //숫자가 작을수록 앞에 위치
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list){
        if(list.isEmpty()){
            return null;
        }
        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args){
        System.out.println("== 연결리스트 방식의 우선 순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList<>();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);
        line();

        System.out.println("dequeue: "+dequeue(pqList));
        System.out.println("dequeue: "+dequeue(pqList));
        System.out.println(pqList);
        line();

        //JAVA default PriorityQueue
        System.out.println("== JAVA default PriorityQueue ==");
        //우선 순위 큐: 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //낮은 숫자 순

        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(Arrays.toString(pq.toArray()));
        line();
        //우선 순위 큐: 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());  //낮은 숫자 순

        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(Arrays.toString(pq2.toArray()));
        line();
    }
}
