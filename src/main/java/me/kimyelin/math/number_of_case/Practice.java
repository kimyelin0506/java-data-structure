package me.kimyelin.math.number_of_case;
/* 약수 구하기, 두 수의 최대 공약수와 최소 공배수 구하기
    활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
    활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우
* */

import java.util.*;

import static me.kimyelin.Main.line;

public class Practice {
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(num1);
        ArrayList l2 = p.getDivisor(num2);
        System.out.printf("l1: %s\n" , l1);
        System.out.printf("l2: %s\n", l2);
        line();

        System.out.printf("최대공약수(GCD): %d\n", p.getGCD(num1, num2));
        System.out.printf("최소공배수(LCM): %d\n", p.getLCM(num1, num2));
        line();
    }

    //약수: M를 N로 나눴을 경우, 나머지가 0인 경우는 N이 M의 약수라는 의미(N<=M)
    public ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();

        for(int i=1; i<=(int)num/2; i++){  //자기 수의 절반만 돌림
            if(num%i == 0){
                result.add(i);
            }
        }
        result.add(num);
        return result;
    }

    //최대 공약수: A와 B의 공통 약수이면서 가장 큰 수
    //GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB){
        int gcd = -1;
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for(int itemA : (ArrayList<Integer>)divisorA){
            for(int itemB : (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA > gcd){
                        gcd = itemA;
                    }
                }
            }
        }
        return gcd;
    }

    //최소공배수: A와 B의 공통 약수이면서 가장 작은 수 -> A*B/GCD = LCM
    //LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB){
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);
        if(gcd != -1){
            lcm = numA * numB / gcd;
        }
        return lcm;
    }

}
