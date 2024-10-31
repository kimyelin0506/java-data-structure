package me.kimyelin.Data_Structure.hash_table;
//해시 충돌 해결-개방주소법(이중 해싱)

import static me.kimyelin.Main.line;

class MyHashTable4 extends MyHashTable{
    int c;
    MyHashTable4(int size){
        super(size);
        this.c = this.getHashC(size); //생성 시 미리 구해둠
    }

    public int getHashC(int size){
        int c = 0;
        if(size <= 2){
            return size;
        }
        //원래 사이즈보다 조금 작은 소수를 구하는 것
        for (int i = size-1; i >2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                c = i;
                break;
            }
        }
        return c;
    }

    //기본적인 이중 해싱: 1 + (key % (c))
    //c ==> 기본 사이즈보다 작은 소수
    public int getHash2(int key){
        int hash = 1 + key % this.c;
        return hash;
    }

    public void setValue(int key, int data){
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("Hash Table is Full");
            return;
        }else if( this.table[idx] == null){
            this.table[idx] = data;
        }else{
            int newIdx = idx;
            int cnt = 0;
            while (true){
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
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
public class Practice4 {
    public static void main(String[] args){
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1,10);
        ht.setValue(2,20);
        ht.setValue(3,30);
        ht.printHashTable();
        line();

        ht.setValue(1,100);
        ht.setValue(1,200);
        ht.setValue(1,300);  //해시 테이블 full
        ht.printHashTable();
    }
}
