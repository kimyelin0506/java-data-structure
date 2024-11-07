package me.kimyelin.algorithm.graph_dijkstra;

import java.util.ArrayList;

//알고리즘 - 최단 경로 알고리즘
//디익스트라 구현
public class Main {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void dijkstra(int v, int[][] data, int start){
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {  //v+1: arr 가 1부터 시작하기 때문에 편의를 위해
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] dist = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0; //자기 자신은 0

        boolean[] visited = new boolean[v+1];
        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE;
            int curIdx = 0;
            for (int j = 1; j < v+1; j++) {
                if(!visited[j] && dist[j] < minDist){
                    minDist = dist[j];
                    curIdx = j;
                }
            }
            visited[curIdx] = true;
            for (int j = 0; j < graph.get(curIdx).size(); j++) {  //인접 노드들의 개수를 구함
                Node adjNode = graph.get(curIdx).get(j);
                //원래 들어있던 값과 거쳐서 가는 값의 비교
                if(dist[adjNode.to] > dist[curIdx] + adjNode.weight){
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;
                }
            }
        }
        //출력
        for (int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            }else{
                System.out.print(dist[i]+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[][] data = {{1,2,2}, {1,3,3}, {2,3,4}, {2,4,5}, {3,4,6}, {5,1,1}};
        dijkstra(5, data, 1);
    }
}
