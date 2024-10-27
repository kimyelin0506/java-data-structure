package me.kimyelin.Math.complexity;


import static me.kimyelin.Main.line;

public class Main {

    static int fibonacci(int n){
        if(n<3){
            return 1;
        }
        return fibonacci(n-2)+fibonacci(n-1);
    }

    static int factorial(int n){
        if(n < 1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args){

        //1. 시간 복잡도(Time Complexity)
        System.out.println("== Time Complexity ==");
        //O(1): 인덱싱 또는 출력
        System.out.println("== O(1) ==");
        System.out.println("hello");

        line();
        //O(logN): 입력값(16)에 비해 출력(4)
        System.out.println("== O(logN) ==");
        for (int i = 1; i < 16; i*=2) {
            System.out.println("hello");
        }
        line();

        //O(N): N번에 대해 N번만큼 이루어짐
        System.out.println("== O(N) ==");
        for (int i = 0; i < 2; i++) {
            System.out.println("hello");
        }
        line();

        //O(NlogN): 이중 for문
        System.out.println("== O(NlogN) ==");
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 8; j*=2){
                System.out.println("hello");
            }
        }
        line();

        //O(N^2): N번만큼 이뤄지는 for문이 2중으로 존재
        System.out.println("== O(N^2) ==");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++){
                System.out.print("hello");
            }
            System.out.println();
        }
        line();

        //O(2^N): 입력값에 비해 2^N만큼 늘어남
        System.out.println("== O(2^N) ==");
        System.out.println(fibonacci(6));
        line();

        //2. 공간복잡도(Space Complexity)
        System.out.println("== 공간복잡도(Spase Complexity) ==");

        //O(N)
        System.out.println("== O(N) ==");
        int n = 3;
        System.out.println(factorial(n));
        line();

        //O(1)
        System.out.println("== O(1) ==");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
