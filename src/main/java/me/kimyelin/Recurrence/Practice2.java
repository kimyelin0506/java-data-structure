package me.kimyelin.Recurrence;
//최대 공약수를 재귀함수로 구현하기
public class Practice2 {
    static int gcd(int a, int b){
            if(a % b == 0){
                return b;
            }
            return gcd(b, a%b);  //주어진 두 수를 나누는 것을 반복하면서 나오는 나머지가 0이 될 경우 그 수가 최대 공약수임
    }

    public static void main(String[] args){
        System.out.printf("GCD(3,5): %d\n", gcd(3,5));
        System.out.printf("GCD(2,6): %d\n", gcd(2,6));
        System.out.printf("GCD(8,12): %d\n", gcd(8,12));
    }
}
