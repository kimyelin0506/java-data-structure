package me.kimyelin.permutation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Practice2 {
    //visited를 이용해 해당 자리를 방문했는지 확인을 하며 출력
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out){
        if(depth == r){
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i] != true){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth+1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int n =4;
        int r=3;
        int[] arr = IntStream.range(1,5).toArray();
        boolean[] visited = new boolean[n];
        int[] out = new int[r];

        Practice2 p2 = new Practice2();
        p2.permutation(arr, 0, n, r, visited, out);
    }
}
