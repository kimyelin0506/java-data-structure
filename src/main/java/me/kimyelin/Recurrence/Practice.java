package me.kimyelin.Recurrence;
//factorial을 재귀함수로 구현하기
public class Practice {

    static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static void main(String[] args){
        System.out.printf("factorial1: %d\n", factorial(1));
        System.out.printf("factorial2: %d\n", factorial(2));
        System.out.printf("factorial3: %d\n", factorial(3));
        System.out.printf("factorial4: %d\n", factorial(4));
        System.out.printf("factorial5: %d\n", factorial(5));
    }
}
