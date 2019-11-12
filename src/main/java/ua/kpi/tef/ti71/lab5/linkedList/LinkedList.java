package ua.kpi.tef.ti71.lab5.linkedList;

import ua.kpi.tef.ti71.lab5.util.Node;

/**
 * {@link LinkedList} is a list implementation that is based on singly linked generic nodes. A node is implemented as
 * inner static class {@link Node<T>}. In order to keep track on nodes, {@link LinkedList} keeps a reference to a head node.
 *
 * @param <T> generic type parameter
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    public LinkedList(Node<T> head, Integer size) {
        this.head = head;
        this.size = size;
    }

    private Node<T> getNode(int index) {
        int pointing = this.size - 1;
        Node<T> selected = this.head;
        while (pointing != index) {
            if (selected == null) {
                throw new IndexOutOfBoundsException();
            } else {
                selected = selected.getPrevious();
            }
            pointing--;
        }
        return selected;
    }

    /**
     * This method creates a list of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new list of elements the were passed as method parameters
     */
    public static <T> List<T> of(T... elements) {
        Node<T> head = null;
        for (T element : elements) {
            head = new Node<>(head, element);
        }
        return new LinkedList<>(head, elements.length);
    }

    /**
     * Adds an element to the end of the list
     *
     * @param element element to add
     */
    @Override
    public void add(T element) {
        this.head = new Node<>(this.head, element);
        this.size++;
    }

    /**
     * Adds a new element to the specific position in the list. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an index of new element
     * @param element element to add
     */
    @Override
    public void add(int index, T element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == this.size) {
            this.head = new Node<>(this.head, element);
        } else {
            Node<T> selected = getNode(index);
            new Node<>(selected.getPrevious(), element, selected);
        }
        this.size++;
    }

    /**
     * Changes the value of an list element at specific position. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index   an position of element to change
     * @param element a new element value
     */
    @Override
    public void set(int index, T element) {
        getNode(index).setValue(element);
    }

    /**
     * Retrieves an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     * @return an element value
     */
    @Override
    public T get(int index) {
        Node<T> selected = getNode(index);
        if (selected == null) {
            throw new IndexOutOfBoundsException();
        }
        return selected.getValue();
    }

    /**
     * Removes an elements by its position index. In case provided index in out of the list bounds it
     * throws {@link IndexOutOfBoundsException}
     *
     * @param index element index
     */
    @Override
    public void remove(int index) {
        Node<T> selected = getNode(index);
        selected.unlink();
        if (selected == this.head) {
            this.head = this.head.getPrevious();
        }
        this.size--;
    }


    /**
     * Checks if a specific exists in he list
     *
     * @return {@code true} if element exist, {@code false} otherwise
     */
    @Override
    public boolean contains(T element) {
        Node<T> selected = this.head;
        while (selected != null) {
            if (selected.getValue().equals(element)) {
                return true;
            }
            selected = selected.getPrevious();
        }
        return false;
    }

    /**
     * Checks if a list is empty
     *
     * @return {@code true} if list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns the number of elements in the list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Removes all list elements
     */
    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }
}
