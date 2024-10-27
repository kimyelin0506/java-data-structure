package me.kimyelin.permutation;

import java.util.stream.IntStream;

import static me.kimyelin.Main.line;

public class Main {
    public static void main(String[] args){
        //1. 팩토리얼
        System.out.println("== Factorial ==");
        //5!
        int n = 5;
        int result = 1;
        for(int i=1; i<=n; i++){
            result += i;
        }
        System.out.printf("result: %d\n", result);
        System.out.printf("result(stream): %d\n",
                IntStream.range(2,6)
                        .reduce(1,(x, y) -> (x*y)));
        line();

        //2. 순열
        System.out.println("== Permutation ==");
        //5명을 3줄로 세우는 경우의 수
        n = 5;
        int r = 3;
        result = 1;
        for (int i = n; i >=n-r+1 ; i--) {
            result *= i;
        }
        System.out.printf("result: %d\n", result);
        line();

        //3. 중복 순열
        System.out.println("== Duplicate Permutation ==");
        //서로 다른 4개의 수 중 2개를 뽑는 경우의 수 (중복 허용)
        n = 4;
        r = 2;
        result = 1;

        for (int i = 0; i < r; i++) {
            result *= n;
        }
        System.out.printf("result: %d\n", result);
        System.out.printf("result: %f\n", Math.pow(n, r));
        line();

        //4. 원 순열
        System.out.println("== Circle Permutation ==");
        n = 3;
        result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        System.out.printf("result: %d\n", result);
        line();
    }
}
