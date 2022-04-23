package lesson4;

public class Deque<E> extends Queue<E> {

    public void insertRight(E value) {
        queue.insertLast(value);
    }

    public void insertLeft(E value) {
        queue.insert(value);
    }

    public void insertAfterValue(E afterValue, E value) {
        queue.insertAfterValue(afterValue, value);
    }

    public E deleteLeft() {
        return queue.deleteLast();
    }

    public E deleteRight() {
        return queue.delete();
    }

    public void iterDisplay() {
        for (E item: queue ) {
            System.out.println("Value (iterator): " + item);
        }
    }


}
