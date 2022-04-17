package lesson4;

public class Queue {
    private final LinkedList queue;
    public Queue(){
        queue = new LinkedList();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void insert(String name, int age){
        queue.insert(name, age);
    }
    public String delete(){
        return queue.delete();
    }
    public void display(){
        queue.display();
    }
}
