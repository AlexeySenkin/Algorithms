package lesson6;

public interface Tree<E extends Comparable<? super E>> {

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER, PRE_ORDER_BALANCE
    }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    boolean traverse(TraversMode mode);

}
