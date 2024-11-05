package me.kimyelin.data_structure.nonLinear.priority_queue;
//자바 기본 PriorityQueue 응용
//나이 순으로 오름차순 또는 내림차순 출력

import java.util.PriorityQueue;
class Person{
//class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //객체의 필드가 여러개일 때, 우선순위의 기준을 정해주기 위해 인터페이스 구현
//    @Override
//    public int compareTo(Person o) {
//        //1: 변경 안함
//        //-1: 변경함
//
//        //새롭게 추가하는 데이터가 더 적을 때 변경(적은 값이 위로 올라감, 오름차순)
////        return this.age >= o.age ? 1 : -1;
//        //새롭게 추가하는 데이터가 더 클 떄 변경(큰 값이 위로 올라감, 내림차순)
//        return this.age >= o.age ? -1 : 1;
//    }
}

public class Practice1 {
    public static void solution(String[] names, int[] age){
        PriorityQueue<Person> pq = new PriorityQueue<>();

//        for (int i = 0; i < names.length; i++) {
//            pq.offer(new Person(names[i], age[i]));
//        }
//
//        System.out.println("== 실제 출력 순서 ==");
//        while(!pq.isEmpty()){
//            Person p = pq.poll();
//            System.out.println(p.name + ": "+ p.age);
//        }
    }

    public static void main(String[] args){
        String[] names = {"A", "B", "C", "D", "E"};
        int[] age = {30,20,45,62,35};

        solution(names, age);

        //상속 없이 구현 -> 비교 조건을 람다식으로 전달
        PriorityQueue<Person> pq2 = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.age <= p2.age ? 1 : -1);

        for (int i = 0; i < names.length; i++) {
            pq2.offer(new Person(names[i], age[i]));
        }
        while(!pq2.isEmpty()){
            Person p = pq2.poll();
            System.out.println(p.name + ": "+ p.age);
        }

    }
}
