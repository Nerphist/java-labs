package ua.kpi.tef.ti71.lab5.linkedQueue;

import ua.kpi.tef.ti71.lab5.util.Node;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 *
 * @param <T> a generic parameter
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    @Override
    public void add(T element) {
        if (size == 0) {
            this.tail = this.head = new Node<>(element);
        } else {
            var newNode = new Node<>(element);
            this.tail.setPrevious(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    @Override
    public T poll() {
        T value;
        if (this.head != null) {
            value = this.head.getValue();
            this.head = this.head.getPrevious();
            this.size--;
        } else {
            value = null;
        }
        return value;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
