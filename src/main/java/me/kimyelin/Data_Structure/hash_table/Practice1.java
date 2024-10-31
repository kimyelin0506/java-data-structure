package me.kimyelin.Data_Structure.hash_table;

import static me.kimyelin.Main.line;

//배열 이용
class MyHashTable{
    Integer[] table;
    int elemCnt;

    //다음 연습에서 상속받아 사용할것이기 때문에 기본 생성자 생성
    MyHashTable(){}
    MyHashTable(int size){
        this.table = new Integer[size];
        this.elemCnt = 0;
    }

    public int getHash(int key){
        return key % this.table.length;  //테이블의 인덱스가 빙글빙글 돔 -> 원형
    }

    public void setValue(int key,int data){
        int idx = this.getHash(key);
        this.table[idx] = data;
        this.elemCnt++;
    }

    public int getValue(int key){
        int idx = this.getHash(key);
        return this.table[idx];
    }

    public void removeValue(int key){
        int idx = this.getHash(key);
        this.table[idx] = null;
        this.elemCnt--;
    }

    public void printHashTable(){
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.println(i+": "+this.table[i]);
        }
        System.out.println();
    }



}

public class Practice1 {
    public static void main(String[] args){
        MyHashTable ht = new MyHashTable(7);

        ht.setValue(1,1);
        ht.setValue(2,2);
        ht.setValue(3,3);
        ht.setValue(4,4);
        ht.setValue(5,5);
        ht.printHashTable();
        line();

        ht.setValue(8,6);  //해시 충돌
        ht.printHashTable();
    }
}
