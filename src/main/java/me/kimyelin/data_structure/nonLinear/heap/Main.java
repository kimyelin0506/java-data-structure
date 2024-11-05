package me.kimyelin.data_structure.nonLinear.heap;
//비선형 자료구조-힙
//ArrayList 로 최소 힙 구현

import java.util.ArrayList;

import static me.kimyelin.Main.line;

class MinHeap{
    ArrayList<Integer> heap;

    public MinHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0);  //Idx 기준으로 1번부터 시작
    }

    public void insert(int data){
        heap.add(data);

        //key 값 비교
        int cur = heap.size()-1;  //방금 넣은 데이터이 인덱스 위치
        while (cur > 1 && heap.get(cur/2) > heap.get(cur)){  //지금 값보다 부모쪽 값이 더 큰 경우
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
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()){  //자식이 한개(left)만 있는 경우
                targetIdx = leftIdx;
            } else{  //자식 노드가 없는 상황
                break;
            }

            if(heap.get(cur) < heap.get(targetIdx)){
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

public class Main {
    public static void main(String[] args){
        MinHeap minHeap = new MinHeap();
        System.out.println("== insert data ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        line();

        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        line();

        minHeap.insert(20);
        minHeap.printTree();
        line();

        minHeap.insert(30);
        minHeap.printTree();
        line();

        System.out.println("== delete data ==");
        System.out.println("delete: "+ minHeap.delete());
        minHeap.printTree();
        line();

        System.out.println("delete: "+ minHeap.delete());
        minHeap.printTree();
        line();

        System.out.println("delete: "+ minHeap.delete());
        minHeap.printTree();
        line();
    }
}
