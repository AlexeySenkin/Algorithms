package lesson4;

public class HomeWorkApp4 {
    public static void main(String[] args) {
        System.out.println("Z");

        Queue q = new Queue();
        q.insert("Artem", 30);
        q.insert("Viktor", 20);
        q.insert("Sergey", 10);
        q.display();

        while (!q.isEmpty()) {
            System.out.println("Элемент "+ q.delete()+" удален из стека");
        }

    }
}
