package me.kimyelin.Math.factor_log;

import static me.kimyelin.Main.line;

public class Practice {

    static double pow(int a, double b) {
        int result = 1;
        boolean isMinus = false;

        if (b == 0) {
            return 1;
        } else if (b < 0) {
            b *= -1;
            isMinus = true;
        }

        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return isMinus ? 1 / result : result;  //지수가 음수일 경우 나눈 값이 들어감
    }

    static double sqrt(int a){
        double result = 1;
        //바빌로니아 방법
        for (int i = 0; i < 10; i++) {  //반복 횟수가 늘수록 근사값
            result = (result +(a/result))/2;
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("== Math pow ==");
        System.out.println(Math.pow(2,3));
        System.out.println(Math.pow(2,-3));
        System.out.println(Math.pow(-2,-3));
        line();
        System.out.println("== My pow ==");
        System.out.println(pow(2,3));
        System.out.println(pow(2,-3));
        System.out.println(pow(-2,-3));
        line();

        System.out.println("== Math sqrt ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));
        line();
        System.out.println("== My sqrt == ");
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));
        line();
    }
}
