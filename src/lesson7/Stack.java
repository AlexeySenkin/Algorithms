package lesson7;

import java.util.Arrays;

public class Stack {
    private final int maxSize;
    private final int[] stackArr;
    private int top;
    public Stack(int size){
        this.maxSize = size;
        this.stackArr = new int[size];
        this.top = -1;
    }
    public void push(int i){
        stackArr[++top] = i;
    }
    public int pop(){
        return stackArr[top--];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public int peek(){
        if (top != -1) {
            return stackArr[top];
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "maxSize=" + maxSize +
                ", stackArr=" + Arrays.toString(stackArr) +
                ", top=" + top +
                '}';
    }
}
