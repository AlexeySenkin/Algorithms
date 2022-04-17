package lesson4;

public class Link<E> {
    E value;
    Link<E> next;

    public Link(E value, Link<E> next) {
        this.value = value;
        this.next = next;
    }

    public Link(E value) {
        this.value = value;
    }

    public void display() {
        System.out.println("Value: " + this.value);
    }

    public void setNext(Link<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public Link<E> getNext() {
        return next;
    }
}
