package me.kimyelin.algorithm.sort_3;
// radix Sort
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void radixSort(int[] arr){
        //기수 테이블 만들기
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr);

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j]/div)%10).offer(arr[j]);
            }
            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);
                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }
            idx = 0;
            div *= 10;
        }
    }
    //최대 자릿수 구하기
    public static int getMaxLen(int[] arr){
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i])+1;  //10은 두자리이니까 +1 === arr.length/10+1
            if(maxLen < len){
                maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args){
        int[] arr = {10,32,52,27,48,17,99,56};
        radixSort(arr);
        System.out.println("기수 정렬: "+ Arrays.toString(arr));
    }
}
