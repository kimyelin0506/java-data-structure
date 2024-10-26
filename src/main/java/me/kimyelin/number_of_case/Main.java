package me.kimyelin.number_of_case;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

import static me.kimyelin.Main.line;

public class Main {
    public static void main(String[] args){

        //1. 합의 법칙
        System.out.println("== 합의 법칙 ==");

        //두 개의 주사위를 던졌을 때 합이 3 또는 4의 배수일 경우의 수
        int[] dice1 = IntStream.range(1,7).toArray();
        int[] dice2 = IntStream.range(1,7).toArray();

        int nA = 0;  //a의 경우의 수
        int nB = 0;  //b의 경우의 수
        int nAndB = 0;

        //기본 풀이
        for(int item1 : dice1){
            for(int item2 : dice2){
                if((item1 + item2) % 3 == 0){
                    nA ++;
                }
            }
        }

        for(int item1 : dice1){
            for(int item2 : dice2){
                if((item1 + item2) % 4 == 0){
                    nB ++;
                }
            }
        }

        for(int item1 : dice1){
            for(int item2 : dice2){
                if((item1 + item2) % (3*4) == 0){
                    nAndB ++;
                }
            }
        }
        System.out.printf("result: %d\n", nA + nB - nAndB);
        line();

        //HashSet 이용: ArrayList를 이용하여 경우의 수 출력
        HashSet<ArrayList> allCase = new HashSet<>();
        for(int item1: dice1){
            for(int item2 : dice2){
                if((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0){
                    ArrayList ls = new ArrayList(Arrays.asList(item1, item2));
                    allCase.add(ls);
                }
            }
        }
        System.out.printf("result: %d\n", allCase.size());
        line();

        //2. 곱의 법칙
        System.out.println("== 곱의 법칙 ==");

        //두 개의 주사위를 던졌을 경우, a는 3의 배수, b는 4의 배수일 경우의 수
        nA = 0;
        nB = 0;
        for(int item1 : dice1){
            if(item1 % 3 == 0){
                nA ++;
            }
        }

        for(int item2 : dice2){
            if(item2 % 4 == 0){
                nB ++;
            }
        }

        System.out.printf("result: %d\n", nA * nB);
        line();

    }
}
