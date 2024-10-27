package me.kimyelin.Math.combination;

import static me.kimyelin.Main.line;

public class Main {

    static int getCombination(int n, int r){
        int pResult = 1;
        for (int i = n; i >= n-r+1 ; i--) {
            pResult *= i;
        }

        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        return pResult/rResult;
    }

    public static void main(String[] args){
        //1. 조합
        System.out.println("== Combination ==");
        //서로 다른 4명 중 주변 2명을 뽑는 경우의 수
        int n = 4;
        int r = 2;

        //순열 이용
        int pResult = 1;
        for (int i = n; i >= n-r+1 ; i--) {
            pResult *= i;
        }
        //팩토이얼 이용
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        System.out.printf("result: %d\n", pResult/rResult);
        line();

        //2. 중복 조합
        System.out.println("== Duplicate Combination ==");
        //후보 2명, 유권자 3명일 때 무기명 투표 경우의 수
        n = 2;
        r = 3;
        System.out.printf("result: %d\n", getCombination(n+r-1, r));
        line();
    }
}
