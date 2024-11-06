package me.kimyelin.algorithm.sort_2;

import java.util.Arrays;

public class Main {
    //정렬 하려는 배열을 분할
    public static void mergeSort(int[] arr, int[] tmp, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            //mid를 기준으로 양쪽을 나눔
            mergeSort(arr, tmp, left, mid);  //좌측
            mergeSort(arr, tmp,mid+1, right);  //우측
            merge(arr, tmp, left, right, mid);
        }
    }
    //합병
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid){
        int p =left;
        int q = mid+1;
        int idx = p;

        //유효한 구간
        while (p <= mid || q <= right){
            if(p <= mid && q <= right){
                if(arr[p] <= arr[q]){
                    tmp[idx++] = arr[p++];
                } else{
                    tmp[idx++] = arr[q++];
                }
            }else if(p <= mid && q > right){  //오른쪽에는 데이터가 더이상 없는 경우
                tmp[idx++] = arr[p++];
            }else{
                tmp[idx++] = arr[q++];
            }
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
    public static void main(String[] args){
        int[] arr = {3,5,2,7,1,4,6};
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
        System.out.println("Merge Sort: "+ Arrays.toString(arr));
    }
}
