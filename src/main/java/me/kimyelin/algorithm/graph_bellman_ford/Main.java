package me.kimyelin.algorithm.graph_bellman_ford;

import static me.kimyelin.Main.line;

// 최단 경로 알고리즘 -벨만 포드
public class Main {
    //간선 정보를 관리하기 위한 클래스 생성
    static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellmanFord(int v, int e, int[][] data, int start){
        Edge[] edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }
        int[] dist = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean isMInusCycle = false;
        for (int i = 0; i < v+1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edge[j];

                //현재 엣지가 무한인경우는 의미가 없으므로 다음으로 넘어감
                if(dist[cur.from] == Integer.MAX_VALUE){
                    continue;
                }

                if(dist[cur.to] > dist[cur.from] + cur.weight){
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    if(i == v){
                        isMInusCycle = true;
                    }
                }
            }
        }

        System.out.println("음수 사이클 발생: "+ isMInusCycle);
        for (int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            }else{
                System.out.print(dist[i]+ " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[][] data = {
                {1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5},
                {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3},
                {5,6,5}, {6,2,0}, {6,7,-7}};
        bellmanFord(7,11,data,1);
        line();

        data = new int[][]{
                {1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5},
                {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3},
                {5,6,5}, {6,2,-5}, {6,7,-7}};
        bellmanFord(7,11,data,1);
        line();

    }
}
