package me.kimyelin.algorithm.binary_search;
//자바 기본 제공 binarySearch
import java.util.Arrays;
import java.util.stream.IntStream;

import static me.kimyelin.Main.line;

public class Main2 {

    public static void main(String[] args){
        int[] arr = IntStream.range(0,60).toArray();
        System.out.println("== data 존재 ==");
        System.out.println(Arrays.binarySearch(arr,1));
        System.out.println(Arrays.binarySearch(arr,10));
        System.out.println(Arrays.binarySearch(arr,30));
        line();
        System.out.println("== data 존재하지 않음 ==");
        System.out.println(Arrays.binarySearch(arr,61)); // return -(존재 해야 하는 idx 자리)-1
    }
}
