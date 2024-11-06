package me.kimyelin.algorithm.sort_1;

import java.util.Arrays;

import static me.kimyelin.Main.line;

public class Main {
    //Bubble Sort: 오름 차순 정렬
    public static void bubbleSort(int[] arr){
//        for (int i = 1; i < arr.length-1; i++) {
//            for (int j = 0; j < arr.length-i; j++) {
//                if(arr[j] > arr[j+1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//            }
//        }

        //or
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
    //insertion Sort
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else{
                    break;
                }
            }
        }
    }
    //selection Sort
    public static void selectionSort(int[] arr){
//        for (int i = 0; i < arr.length-1; i++) {
//            int min = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[j] < arr[min]){
//                    min = j;
//                }
//            }
//            int tmp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = tmp;
//        }
        for (int i = 0; i < arr.length-1; i++) {
            int max = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }

    }

    public static void main(String[] args){
        int[] arr = {3,5,2,7,1,4};
        bubbleSort(arr);
        System.out.println("bubble sort: "+ Arrays.toString(arr));
        line();

        arr = new int[]{3,5,2,7,1,4};
        insertionSort(arr);
        System.out.println("insertion sort: "+Arrays.toString(arr));
        line();

        arr = new int[]{3,5,2,7,1,4};
        selectionSort(arr);
        System.out.println("selection sort: "+ Arrays.toString(arr));
        line();
    }
}
