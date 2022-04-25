package lesson7;

public class Graph {
    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Stack bestVay;

    public Graph(){
        stack = new Stack(MAX_VERTS);
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }
    private int[] getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] > 0 && vertexList[i].wasVisited == false){
                int[] value = {i, adjMat[ver][i] };
                return value;
            }
        }
        int[] result = {-1, 0};
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
        int distance = 0;
        int[] value;
        vertexList[A].wasVisited = true;
        displayVertex(A);
        stack.push(A);
        while (!stack.isEmpty()) {
            value = getAdjUnvisitedVertex(stack.peek());
            int v = value[0];
            if (v == -1) {
                System.out.println(stack.toString());
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

                if (value[0] == B) {
                    System.out.println("расстояние " + distance + " км ");
                }
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }

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
