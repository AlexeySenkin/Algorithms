package lesson3;

import java.util.Arrays;

public class Queue {

    private final int maxSize;
    private final int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
        items = 0;
    }

    public boolean insert(int i) {
        if(isFull()) {
            return false;
        } else {
            if(rear == maxSize - 1)
                rear = -1;
            queue[++rear] = i;
            items++;
            return true;
        }
    }

    public void remove() {
        int temp = queue[front++];
        if(front == maxSize)
            front = 0;
        items--;
        //return temp;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return (items==0);
    }

    public boolean isFull() {
        return (items==maxSize);
    }

    public int size() {
        return items;
    }

    public void print() {
        System.out.print("\nqueue : ");
        if (size() > 0) {
            if (front <= rear) {
                for (int i = rear; i >= front; i--) {
                    if (i < rear) {
                        System.out.print(", " + queue[i]);
                    } else {
                        System.out.print(queue[i]);
                    }
                }
            } else {
                for (int i = rear ; i >= 0; i--) {
                    System.out.print(queue[i] + ", ");
                }
                for (int i = queue.length - 1; i >= front; i--) {
                    if (i < queue.length - 1) {
                        System.out.print(", " + queue[i]);
                    } else {
                        System.out.print(queue[i]);
                    }
                }
            }
        } else {
            System.out.print("Пусто ");
        }
        System.out.print(" front=" + front + ", rear=" + rear + ", items = " + size());
        System.out.print(" mas: " + Arrays.toString(queue));
    }
}
