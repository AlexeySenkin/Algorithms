package lesson7;

public class HomeWorkApp7 {

    public static void main(String[] args) {

        Graph graph = new Graph(32);

        graph.addVertex("Москва"); //0

        graph.addVertex("Тула");   //1
        graph.addVertex("Рязань"); //2
        graph.addVertex("Калуга"); //3

        graph.addVertex("Липецк"); //4
        graph.addVertex("Тамбов"); //5
        graph.addVertex("Орел");   //6

        graph.addVertex("Саратов");//7
        graph.addVertex("Курск");  //8

        graph.addVertex("Воронеж");//9

        graph.addEdge(0, 1, 30);
        graph.addEdge(0, 2, 15);
        graph.addEdge(0, 3, 10);

        graph.addEdge(1, 4, 20);
        graph.addEdge(2, 5, 15);
        graph.addEdge(3, 6, 10);

        graph.addEdge(4, 9, 50);
        graph.addEdge(5, 7, 25);
        graph.addEdge(6, 8, 30);

        graph.addEdge(7, 9, 15);
        graph.addEdge(8, 9, 30);

        graph.dfsFromAToB(0, 9);


    }
}
