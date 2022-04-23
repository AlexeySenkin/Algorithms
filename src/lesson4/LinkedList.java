package lesson4;


import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private Link<E> first;
    private Link<E> last;

    public Link<E> getFirst() {
        return first;
    }

    public Link<E> getLast() {
        return last;
    }

    public void setFirst(Link<E> first) {
        this.first = first;
    }

    public void setLast(Link<E> last) {
        this.last = last;
    }

    public LinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insert(E value) {
        Link<E> newLink = new Link<>(value);
        if (this.isEmpty()) {
            last = newLink;
        }
        newLink.setNext(first);
        first = newLink;
    }

    public void insertAfterValue(E afterValue, E value) {
        Link<E> newLink = new Link<>(value);
        Link<E> afterLink = find(afterValue);
        Link<E> temp = afterLink.getNext();
        if (!this.isEmpty() && afterLink != null) {
            afterLink.setNext(newLink);
            newLink.setNext(temp);
        }
    }

    public void insertLast(E value) {
        Link<E> newLink = new Link<>(value);
        if (this.isEmpty())
            first = newLink;
        else
            last.setNext(newLink);
        last = newLink;
    }

    public E delete() {
        Link<E> temp = first;
        if (first.getNext() == null)
            last = null;
        first = first.getNext();
        return temp.getValue();
    }

    public E deleteLast() {
        Link<E> temp = last;
        Link<E> current = first;
        while (current.getNext() != last) {
            current = current.getNext();
        }
        last = current;
        last.setNext(null);
        return temp.getValue();
    }

    public Link<E> delete(E value) {
        Link<E> current = first;
        Link<E> previous = first;
        while (current.getValue() != value) {
            if (current.getNext() == null) {
                return null;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        if (current == first) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
        return current;
    }

    public Link<E> find(E value) {
        Link<E> current = first;
        while (current.getValue() != value) {
            if (current.getNext() == null) {
                return null;
            } else {
                current = current.getNext();
            }
        }
        return current;
    }

    public void display() {
        Link<E> current = first;
        while (current != null) {
            current.display();
            current = current.getNext();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<E> implements Iterator<E> {

        private Link<E> current;

        public ListIterator() {
            this.current = (Link<E>) getFirst();
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E value = current.getValue();
            current = current.next;
            return value;
        }

        public void reset() {
            this.current = (Link<E>) getFirst();
        }


    }


}
