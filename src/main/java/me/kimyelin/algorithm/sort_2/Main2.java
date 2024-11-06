package me.kimyelin.algorithm.sort_2;

import java.util.Arrays;

public class Main2 {
    public static void heapSort(int[] arr){
        for (int i = arr.length/2-1; i >= 0; i--) {
            heapIfy(arr, i, arr.length);
        }
        //정렬: 가장 앞에 있는 데이터는 maxData, 가장 뒤에 있는 데이터는 minData 이므로
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);
            heapIfy(arr, 0, i);
        }
    }

    public static void heapIfy(int[] arr, int parentIdx, int size){
        int leftIdx = 2*parentIdx+1;
        int rightIdx = 2*parentIdx+2;
        int maxIdx = parentIdx;

        //범위 내에 있고 && 최대 보다 큰 경우
        if(leftIdx < size && arr[maxIdx] < arr[leftIdx]){
            maxIdx = leftIdx;
        }
        if(rightIdx < size && arr[maxIdx] < arr[rightIdx]){
            maxIdx = rightIdx;
        }

        //교체가된 경우
        if(parentIdx != maxIdx){
            swap(arr, maxIdx, parentIdx);
            heapIfy(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {3,5,2,7,1,4,6};
        heapSort(arr);
        System.out.println("heap Sort: "+ Arrays.toString(arr));
    }
}
