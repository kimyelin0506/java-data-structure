package me.kimyelin.data_structure.nonLinear.graph;
//비선형 자료구조-그래프
//인접 행렬을 이용한 그래프 구현

class MyGraphMatrix{
    char[] vertices;
    int[][] adjMAt;
    int elemCnt;

    public MyGraphMatrix(){}
    public MyGraphMatrix(int size){
        this.vertices = new char[size];
        this.adjMAt = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull(){
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data){
        if(isFull()){
            System.out.println("full");
            return;
        }
        this.vertices[this.elemCnt++] = data;
    }

    //무방향
    public void addEdge(int x, int y){
        this.adjMAt[x][y] = 1;
        this.adjMAt[y][x] = 1;
    }

    //방향
    public void addDirectedEdge(int x, int y){
        this.adjMAt[x][y] = 1;
    }

    //무방향
    public void deleteEdge(int x, int y){
        this.adjMAt[x][y] = 0;
        this.adjMAt[y][x] = 0;
    }

    //방향
    public void deleteDirectedEdge(int x, int y){
        this.adjMAt[x][y] = 0;
    }

    public void printAdjacentMatrix(){
        System.out.print("  ");
        for(char item: this.vertices){
            System.out.print(item+" ");
        }
        System.out.println();
        for (int i = 0; i < this.elemCnt; i++) {
            System.out.print(this.vertices[i] + " ");
            for (int j = 0; j < this.elemCnt; j++) {
                System.out.print(this.adjMAt[i][j]+" ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args){
        MyGraphMatrix graph = new MyGraphMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printAdjacentMatrix();
    }
}
