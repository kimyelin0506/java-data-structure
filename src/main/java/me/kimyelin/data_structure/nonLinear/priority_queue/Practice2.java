package me.kimyelin.data_structure.nonLinear.priority_queue;
//문자열을 사전식 오름차순

import java.util.PriorityQueue;

class Person2{
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Practice2 {
    public static void solution(String[] names, int[] age){
        PriorityQueue<Person2> pq = new PriorityQueue<>(
                //compareTo(): 같은 문자열:0,기준 문자열이 큰경우: 0보다 작음, 기준 문자열이 작은 경우:0보다 큼
                (Person2 p1, Person2 p2)-> p1.name.compareTo(p2.name));
        for (int i = 0; i < names.length; i++) {
            pq.offer(new Person2(names[i], age[i]));
        }
        while(!pq.isEmpty()){
            Person2 p = pq.poll();
            System.out.println(p.name+": "+p.age);
        }


    }

    public static void main(String[] args){
        String[] names = {"A", "B", "C", "D", "E"};
        int[] age = {30,20,45,62,35};

        solution(names, age);
    }
}
