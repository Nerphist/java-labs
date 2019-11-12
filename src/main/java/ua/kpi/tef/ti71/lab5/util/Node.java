package ua.kpi.tef.ti71.lab5.util;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T value;

    public Node() {
    }

    public Node(Node<T> previous, T value, Node<T> next) {
        setPrevious(previous);
        this.value = value;
        setNext(next);
    }

    public Node(Node<T> previous, T value) {
        this(previous, value, null);
    }

    public Node(T value, Node<T> next) {
        this(null, value, next);
    }

    public Node(T value) {
        this(null, value, null);
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
        if (previous != null) {
            previous.next = this;
        }
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
        if (next != null) {
            next.previous = this;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void unlink() {
        if (this.getPrevious() != null) {
            this.getPrevious().setNext(this.getNext());
        }
        if (this.getNext() != null) {
            this.getNext().setPrevious(this.getPrevious());
        }
    }
}