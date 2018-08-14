package algorithm;

import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] data;
    private int top = -1;
    private int size;

    public Stack(int maxSize) {
        this.data = new Object[maxSize];
        this.size = maxSize;
    }

    public void push(T t) {
        if (top == size - 1) {
            return;
        }
        data[++top] = t;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[top--];
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("hello");
        stringStack.push("world");
        stringStack.push("!!");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }

}
