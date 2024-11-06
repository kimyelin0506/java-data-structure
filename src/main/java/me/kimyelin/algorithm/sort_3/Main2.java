package me.kimyelin.algorithm.sort_3;
//계수 정렬

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main2 {

    public static void countingSort(int[] arr){
        //계수 테이블 생성
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max+1];

        for (int j : arr) {
            cntArr[j]++;
        }
        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while(cntArr[i] > 0){
                arr[idx++] = i;
                cntArr[i] -=1;
            }
        }
        
        //hashMap: data가 큰 경우
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            // == int[] cntArr = new int[max+1];
            map.put(item, map.getOrDefault(item, 0)+1);
        }

        int idx2 = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while (cnt > 0){
                arr[idx2++] = list.get(i);
                cnt--;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {10,32,10,27,48,17,99,56,32};
        countingSort(arr);
        System.out.println("계수 정렬: "+ Arrays.toString(arr));
    }
}
