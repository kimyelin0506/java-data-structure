package me.kimyelin.Combination;

import java.util.stream.IntStream;
/*1,2,3,4를 이용하여 세자리 자연수를 만드는 방법(순서X,중복X)의 각 결과 출력하기
* */
public class Practice {
    void combination(int[] arr, boolean[] visited, int depth, int n, int r) {

        //return 조건
        if(r == 0){
            for (int i = 0; i < n; i++) {
                if(visited[i]){
                    System.out.printf("%d ", arr[i]);
                }
            }
            System.out.println();
            return;
        }

        //끝까지 다 돌았을 경우
        if(depth == n){
            return;
        }

        visited[depth] = true;  //현재 자릿수의 방문을 true로 변경
        combination(arr, visited, depth + 1, n, r - 1);  //재귀호출

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);

    }

    public static void main(String[] args){
        int[] arr = IntStream.range(1,5).toArray();
        boolean[] visited = {false,false,false,false};

        Practice p = new Practice();
        p.combination(arr, visited, 0, 4, 3);
    }
}
