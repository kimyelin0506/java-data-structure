package me.kimyelin.algorithm.sort_2;

import java.util.Arrays;

public class Main3 {
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition(arr, left, right);

        quickSort(arr, left,pivot-1);
        quickSort(arr, pivot+1, right);
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j){
            while (arr[j] > pivot && i < j){
                j--;  //좌측으로 이동
            }
            while (arr[i] <= pivot && i < j){
                i++; //우측으로 이동
            }
            swap(arr, i, j);
        }
        swap(arr,left,i);  //기준점과 만난곳을 swap
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        int[] arr = {6,2,7,9,4,5,8};
        quickSort(arr, 0, arr.length-1);
        System.out.println("quick Sort: "+ Arrays.toString(arr));
    }
}
