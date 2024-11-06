package me.kimyelin.algorithm.binary_search;
//이진 탐색
import java.util.stream.IntStream;

import static me.kimyelin.Main.line;

public class Main {
    //반복문
    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            int mid = (left+right)/2;

            if(target == arr[mid]){
                return mid;
            }else if(target<arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    //재귀 함수 이용
    public static int binarySearch2(int[] arr, int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left+right)/2;
        if(target == arr[mid]){
            return mid;
        }else if(target < arr[mid]){
            return binarySearch2(arr, target, left, mid-1);
        }else{
            return binarySearch2(arr,target,mid+1,right);
        }
    }

    public static void main(String[] args){
        int[] arr = IntStream.range(0,60).toArray();
        System.out.println("idx: "+ binarySearch(arr, 30));
        line();
        System.out.println("idx: "+ binarySearch2(arr, 30,0,arr.length-1));
        line();

    }
}
