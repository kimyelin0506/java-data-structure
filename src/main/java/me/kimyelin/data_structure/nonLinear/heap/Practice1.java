package me.kimyelin.data_structure.nonLinear.heap;

import java.util.ArrayList;

import static me.kimyelin.Main.line;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0);  //Idx 기준으로 1번부터 시작
    }

    public void insert(int data){
        heap.add(data);

        //key 값 비교
        int cur = heap.size()-1;  //방금 넣은 데이터이 인덱스 위치
        while (cur > 1 && heap.get(cur/2) < heap.get(cur)){  //지금 값보다 부모쪽 값이 더 큰 경우
            int parentVal = heap.get(cur/2);
            heap.set(cur/2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete(){
        if(this.heap.size() == 1){
            System.out.println("empty");
            return null;
        }
        int target = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));  //마지막 데이터 가져와 위로 올리고
        heap.remove(heap.size()-1);  //마지막 데이터 삭제

        int cur = 1;
        while(true){
            int leftIdx = cur*2;
            int rightIdx = cur*2+1;
            int targetIdx;

            if(rightIdx < heap.size()){  //자식이 둘 다 있는 경우
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()){  //자식이 한개(left)만 있는 경우
                targetIdx = leftIdx;
            } else{  //자식 노드가 없는 상황
                break;
            }

            if(heap.get(cur) > heap.get(targetIdx)){
                break;
            }else{
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }

    public void printTree(){
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i)+" ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap();
        System.out.println("== insert data ==");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        line();

        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        line();

        maxHeap.insert(20);
        maxHeap.printTree();
        line();

        maxHeap.insert(30);
        maxHeap.printTree();
        line();

        System.out.println("== delete data ==");
        System.out.println("delete: "+ maxHeap.delete());
        maxHeap.printTree();
        line();

        System.out.println("delete: "+ maxHeap.delete());
        maxHeap.printTree();
        line();

        System.out.println("delete: "+ maxHeap.delete());
        maxHeap.printTree();
        line();
    }
}
