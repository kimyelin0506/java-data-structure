package me.kimyelin.data_structure.linear.hash_table;

import java.util.Hashtable;
import java.util.Map;

import static me.kimyelin.Main.line;

// 선형자료구조-해시
public class Main {
    // 기본 해시 함수
    public static int getHash(int key){
        return key % 5;  //나눗셈은 해시테이블의 사이즈를 넣어줌
    }


    public static void main(String[] args){
        //기본 해시 테이블 사용 방법
        Hashtable<String, Integer> ht = new Hashtable();

        ht.put("k1", 10);
        ht.put("k2", 20);
        ht.put("k3", 30);
        //key-value를 통해 만든 것이므로 충돌을 만들어보자면
        ht.put("k3", 100);  //마지막에 들어온 데이터로 바뀌어버림

        //key값 대응되는 entry들을 뽑아줌
        //hashtable은 amp을 통해 만들어졌으므로 Map.entry로 설정
        for(Map.Entry<String, Integer> item : ht.entrySet()){
            System.out.println(item.getKey()+" : "+item.getValue());
        }
        line();

        //해시 충돌 케이스(해시 함수 사용)
        Hashtable<Integer, Integer> ht2 = new Hashtable<>();
        // 해시 함수를 이용하여 반환되는 값을 키값에 넣어줌
        ht2.put(getHash(1), 10);
        ht2.put(getHash(2), 20);
        ht2.put(getHash(3), 30);
        ht2.put(getHash(4), 40);
        ht2.put(getHash(5), 50);

        System.out.println("== 충돌 전 ==");
        for(Map.Entry<Integer, Integer> item : ht2.entrySet()){
            System.out.println(item.getKey()+" : "+item.getValue());
        }
        line();

        System.out.println("== 충돌 후 ==");
        ht2.put(getHash(6), 60);
        for(Map.Entry<Integer, Integer> item : ht2.entrySet()){
            System.out.println(item.getKey()+" : "+item.getValue());
        }
        line();


    }
}
