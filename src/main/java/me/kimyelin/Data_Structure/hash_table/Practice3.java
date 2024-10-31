package me.kimyelin.Data_Structure.hash_table;
//해시 충돌 해결 - 개방 주소법(제곱 탐사법)

import static me.kimyelin.Main.line;

class MyHashTable3 extends MyHashTable{
    MyHashTable3(int size){
        super(size);
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("Hash table is Full");
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else{
            int newIdx = idx;
            int cnt = 0;

            while(true){
                newIdx = (newIdx+ (int)Math.pow(2,cnt)) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}
public class Practice3 {
    public static void main(String[] args){
        MyHashTable3 ht = new MyHashTable3(11);
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
