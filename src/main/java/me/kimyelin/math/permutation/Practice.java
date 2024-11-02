package me.kimyelin.math.permutation;

import java.util.stream.IntStream;

/* 1,2,3,4를 이용하여 세자리 자연수를 만드는 방법(순서O, 중복X)의 각 결과를 출력하시오
* */
public class Practice {
    //n: 주어진 개수, r: 뽑을 개수, depth: 각 자릿수 의미
    //자릿수를 바꿔나가면서 앞의 뽑는 개수만큼만 확인하며 추출
    void permutation(int[] arr, int depth, int n, int r){

        //재귀함수 : 탈출 조건이 존재해야함
        if(depth == r){  //자릿수만큼 다 만들어진 상태라면
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n ; i++) {
            swap(arr,depth,i);  //자릿수를 바꾸고 재귀함수 호출
            permutation(arr, depth+1, n, r);  //재귀 함수: 반복할 때마다 depth를 늘려 자릿수 변경
            swap(arr,depth,i);  //다시 원래 자리로 바꿈
        }

    }

    //자리를 바꾸는 함수, depth: 몇번째 자리수, idx: 어디랑 위치를 바꿀 것인지
    void swap(int[] arr, int depth, int idx){
        int tmp = arr[depth];
        arr[depth] = arr[idx]; //바꿀 데이터에 입력
        arr[idx] = tmp;  //바뀐 데이터에 입력
    }

    public static void main(String[] args){
        int[] arr = IntStream.range(1,5).toArray();

        Practice p = new Practice();
        p.permutation(arr, 0, 4, 3);
    }

}
