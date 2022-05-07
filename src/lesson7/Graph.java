package lesson7;


import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int MAX_VERTS;
    private final Vertex[] vertexList;
    private final int[][] adjMat;
    private int size;

    private final Stack stack;

    private final List<Vertex> bestWay;
    private final List<Vertex> way;


    private int bestDistance = 0;

    public Graph(int maxVertex){
        this.MAX_VERTS = maxVertex;
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
        way = new ArrayList<>();
        bestWay = new ArrayList<>();
    }

    private int[] getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] > 0 && !vertexList[i].wasVisited){
                return new int[]{i, adjMat[ver][i] };
            }
        }
        int[] result;
        result = new int[]{-1, 0};
        return result;
    }



    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek())[0];
            if (v == -1){
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void dfsFromAToB(int A, int B) {
        if (A == B) {
            System.out.println("Начальная и конечная точка маршрута совпадают!");
            return;
        }
        int distance = 0;
        int[] value;
        vertexList[A].wasVisited = true;
        displayVertex(A);
        System.out.println();
        stack.push(A);
        way.add(vertexList[A]);
        while (!stack.isEmpty()) {
            value = getAdjUnvisitedVertex(stack.peek());
            int v = value[0];
            if (v == -1) {
                //System.out.println(stack.toString());
                stack.pop();
                if (stack.peek() == 0) {
                    distance = 0;
                    vertexList[B].wasVisited = false;
                    //displayVertex(A);
                }
            } else {
                vertexList[v].wasVisited = true;
                distance += value[1];
                displayVertex(v);
                stack.push(v);
                way.add(vertexList[v]);

                if (value[0] == B) {
                    System.out.println("расстояние " + distance + " км ");
                    if (bestDistance == 0 || bestDistance > distance)  {
                        bestDistance = distance;
                        bestWay.clear();
                        bestWay.addAll(way);
                    }
                    way.clear();
                    way.add(vertexList[A]);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }

        System.out.println("\nКратчайшие расстояние из " + vertexList[A].getLabel() +
                " в " + vertexList[B].getLabel() + ":" + bestDistance + " км");
        System.out.print("Кратчайший маршрут: " );
        for (Vertex vertex : bestWay) {
            System.out.print(vertex.getLabel());
        }
        System.out.println();
    }

    public void addVertex(String label){
        vertexList[size++] = new Vertex(label);
    }
    public void addEdge(int start, int end, int value){
        adjMat[start][end] = value;
        //adjMat[end][start] = value;
    }
    public void displayVertex(int vertex){
        System.out.print(" {" + vertexList[vertex].label + "} ");
    }

}
