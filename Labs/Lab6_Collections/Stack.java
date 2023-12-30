package Labs.Lab6_Collections;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = -1;
    }
    public void push(T element) {
        if (size == data.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        size++;
        data[size] = element;
    }
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = data[size];
        data[size] = null;
        size--;
        return element;
    }
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return data[size];
    }
    public boolean isEmpty() {
        return size == -1;
    }
}
