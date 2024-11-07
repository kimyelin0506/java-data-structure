package me.kimyelin.algorithm.backtracking;
// 백트레킹
public class Main {
    static int n=4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row){
        if(row == n){
            cnt++;
            for (int i = 0; i < n; i++) {
                System.out.print(board[i]+" ");
            }
            System.out.println();
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            //promising
            if(isPormising(row)){
                nQueen(row+1);
            }
        }
        return cnt;
    }


    public static boolean isPormising(int row){
        for (int i = 0; i < row; i++) {
            //같은 열인지 또는 대각선인지
            if(board[row] == board[i] || row-i == Math.abs(board[row]-board[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("경우의 수: "+nQueen(0));
    }
}
