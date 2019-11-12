package ua.kpi.tef.ti71.lab5.util;

public class Node<T> {
    private Node<T> previous;
    private T value;

    public Node() {
    }

    public Node(Node<T> previous, T value) {
        setPrevious(previous);
        this.value = value;
    }

    public Node(T value) {
        this(null, value);
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}