package lesson4;

public class Queue<E> {

    protected final LinkedList<E> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void insert(E value){
        queue.insertLast(value);
    }

    public E delete(){
        return queue.delete();
    }


    public void display(){
        queue.display();
    }
}
