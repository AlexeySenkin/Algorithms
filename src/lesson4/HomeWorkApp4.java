package lesson4;

public class HomeWorkApp4 {
    public static void main(String[] args) {
//        System.out.println("Queue:");
//        Queue queue = new Queue();
//        queue.insert(1);
//        queue.insert(2);
//        queue.insert(3);
//        queue.insert(4);
//        queue.display();
//        if (!queue.isEmpty()) {
//            System.out.println(queue.delete()+" удален");
//        }
//        if (!queue.isEmpty()) {
//            System.out.println(queue.delete()+" удален");
//        }
//        queue.display();

        //ЗАДАНИЕ1
        System.out.println("\nDeque:");
        Deque<String> deque = new Deque<>();
        System.out.println("Добавление в конец");
        deque.insertRight("1");
        deque.insertRight("2");
        deque.insertRight("3");
        deque.display();
        System.out.println("Добавление в начало");
        deque.insertLeft("4");
        deque.insertLeft("10");
        deque.display();

        // ЗАДАНИЕ 3
        System.out.println("Добавление в середину");
        deque.insertAfterValue("4","5");
        deque.display();
        System.out.println("Удаление в начале");
        if (!deque.isEmpty()) {
            System.out.println(deque.deleteRight()+" удален");
        }
        deque.display();
        System.out.println("Удаление в конце");
        if (!deque.isEmpty()) {
            System.out.println(deque.deleteLeft()+" удален");
        }
        deque.display();

        //ЗАДАНИЕ 2
        System.out.println("ПРОВЕРКА ИТЕРАТОРА:");
        deque.iterDisplay();

    }
}
