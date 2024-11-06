package me.kimyelin.algorithm.two_pointers;

import java.util.Arrays;

import static me.kimyelin.Main.line;

public class Main {
    public static int[] forLoop(int[] arr, int target){
        int[] res = {-1,-1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(sum == target){
                    res[0] = i;
                    res[1] = j-1;
                    break;
                }
                sum += arr[j];
            }
            if(sum == target){
                break;
            }
        }
        return res;
    }
    public static int[] twoPointers(int[] arr, int target){
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] res = {-1,-1};
        while (true){
            if(sum > target){
                sum -= arr[p1++];
            }else if(p2 == arr.length){
                break;
            }else{
                sum += arr[p2++];
            }

            if(sum == target){
                res[0] = p1;
                res[1] = p2-1;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {1,2,5,3,7,2,4,3,2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        line();

        System.out.println(Arrays.toString(twoPointers(arr,9)));
        System.out.println(Arrays.toString(twoPointers(arr,14)));
        line();
    }
}
