package me.kimyelin.set;

import java.util.Arrays;
import java.util.HashSet;

//기초 수학 - 집합
public class Main {
    public static void main(String[] args){
        hashSetPractice1();
        line();
        hashSetPractice2();
        line();
        hashSetPractice3();
        line();
        hashSetPractice4();
        line();
    }

    //1. 자바에서 집합사용 - HashSet
    private static void hashSetPractice1(){
        System.out.println("== HashSet ==");
        HashSet set1 = new HashSet();
        set1.add(1);
        set1.add(1);
        set1.add(1);
        System.out.printf("set1 = %s\n", set1);  //HashSet은 중복값을 허용하지 않음
        set1.add(2);
        set1.add(3);
        System.out.printf("set1 = %s\n", set1);
        set1.remove(1);  //data 삭제: 인덱스가 아닌 값으로 삭제
        System.out.printf("set1 = %s\n", set1);
        System.out.println(set1.size());
        System.out.println(set1.contains(2));
    }


    //2-1. 교집합
    private static void hashSetPractice2(){
        HashSet a = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet b = new HashSet(Arrays.asList(2,4,6,8,10));
        a.retainAll(b); //교집합 연산: 공통 원소만 추출
        System.out.printf("교집합: %s\n", a);
    }

    //2-2. 합집합
    private static void hashSetPractice3(){
        HashSet a = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet b = new HashSet(Arrays.asList(2,4,6,8,10));
        a.addAll(b);
        System.out.printf("합집합: %s\n", a);
    }

    //2-3. 차집합
    private static void hashSetPractice4(){
        HashSet a = new HashSet(Arrays.asList(1,2,3,4,5));
        HashSet b = new HashSet(Arrays.asList(2,4,6,8,10));
        a.removeAll(b);
        System.out.printf("차집합: %s\n", a);
    }
    private static void line(){
        System.out.println("-------------------------------");
    }
}
