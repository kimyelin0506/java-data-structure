package me.kimyelin.algorithm.graph_floyd_warshall;

import static me.kimyelin.Main.line;

public class Main {
    static int[][] dist;
    static final int INF = 100000000;  //오버플로우를 방지하기 위해

    public static void floydWarshall(int v, int e, int[][] data, int start){
        dist = new int[v+1][v+1];  //대각 = 0
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v+1; j++) {
                if(i != j){  //대각이 아닌 경우
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];  //출발지부터 도착지까지의 weight update
        }

        for (int k = 1; k < v+1; k++) {
            //i -> j로 가는데 k 를 거쳐서 가는 경우를 업데이트
            for (int i = 1; i < v+1; i++) {
                for (int j = 1; j < v+1; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF){//i에서 k로 거쳐가는 비용
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        //출력
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if(dist[i][j] >= INF){
                    System.out.printf("%5s ", "INF");
                }else{
                    System.out.printf("%5d ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] data = {
                {1,2,8},{1,3,6},{1,5,5},{2,3,-5},
                {2,4,1},{2,6,4},{3,4,4},{4,7,3},
                {5,6,5},{6,2,0},{6,7,-7}};
        floydWarshall(7,11,data,1);
        line();

        data = new int[][]{
                {1,2,8},{1,3,6},{1,5,5},{2,3,-5},
                {2,4,1},{2,6,4},{3,4,4},{4,7,3},
                {5,6,5},{6,2,-5},{6,7,-7}};
        floydWarshall(7,11,data,1);
        line();
    }
}
