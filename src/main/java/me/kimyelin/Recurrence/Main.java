package me.kimyelin.Recurrence;

import static me.kimyelin.Main.line;

public class Main {

    //== Recurrence/Recursive Function1 ==
    static int recursion1(int n){
        if(n == 1){  //첫 번째 수는 1
            return 1;
        }
        return 3*recursion1(n-1);  //3씩 곱하는 자기 자신을 호출하면서 n을 1씩 감소
    }

    //== Recurrence/Recursive Function2 ==
    static int recursive2(int n) {
        if(n == 1){
            return 1;
        }
        return n + recursive2(n - 1);
    }

    //== Recurrence/Recursive Function3 ==
    static int recursive3(int n){
        if(n < 3){
            return 1;
        }
        return recursive3(n-2)+recursive3(n-1);
    }

    public static void main(String[] args){
        //점화식 -> 반목문, 재귀함수
        System.out.println("== Recurrence/Recursive Function1 ==");
        //1,3,9,27 ...의 n번째 수
        //a(1) = 3*a(0) -> a(n+1) = 3*a(n)
        int n = 4;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result = 1; //i=0일 경우 1
            } else {
                result *= 3;
            }
        }
        System.out.printf("result: %d\n", result);
        line();

        System.out.println("== Recurrence/Recursive Function2 ==");
        //1,2,3,4,5,6... 의 n번째 까지의 합
        n = 5;
        result = 0;
        for (int i = 0; i < n; i++) {
            result += i;
        }
        System.out.printf("result: %d\n", result);
        line();

        System.out.println("== Recurrence/Recursive Function3 ==");
        //1,1,3,5,8,13... 의 n번째 수
        n = 6;
        result = 0;
        int a1 = 1;
        int a2 = 1;

        if(n<3){
            result = 1;
        } else{
            for (int i = 2; i < n; i++) {  //직전 항을 저장하고 쫓아감
                result = a1+ a2;
                a1 = a2;
                a2 = result;
            }
        }
        System.out.printf("result: %d\n", result);
        line();

    }
}
