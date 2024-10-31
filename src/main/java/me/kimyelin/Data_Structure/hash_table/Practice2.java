package me.kimyelin.Data_Structure.hash_table;

import static me.kimyelin.Main.line;

//해시 충돌 해결 - 개방 주소법(선형 탐사법)
class MyHashTable2 extends MyHashTable{

    MyHashTable2(int size){
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("hash Table is Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {  //충돌 발생
            int newIdx = idx;  //충돌난 지점을 기준으로
            while(true){
                newIdx = (newIdx+1) % this.table.length;  //돌아가며 빈 곳을 찾음
                if(this.table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt ++;
    }
}

public class Practice2 {
    public static void main(String[] args){
        MyHashTable2 ht = new MyHashTable2(5);
        ht.setValue(1,1);
        ht.setValue(3,3);
        ht.printHashTable();
        line();

        ht.setValue(1,10);
        ht.printHashTable();
        line();

        ht.setValue(1,20);
        ht.setValue(1,30);
        ht.setValue(1,40);  //해시 테이블 full
        ht.printHashTable();

    }
}
