package ua.kpi.tef.ti71.lab5.linkedStack;

import ua.kpi.tef.ti71.lab5.util.Node;

/**
 *
 * Stack is a data structure that follows "last in, first out" rule (LIFO).
 */
public interface Stack<T> {
    /**
     * Adds an element to the begining of the linkedStack.
     *
     * @param element the element to add
     */
    void push(T element);

    /**
     * Retrieves and removes linkedStack head.
     *
     * @return an element that was retrieved from the head or null if linkedStack is empty
     */
    T pop();

    /**
     * Returns a size of the linkedStack.
     *
     * @return an integer value that is a size of linkedStack
     */
    int size();

    /**
     * Checks if the linkedStack is empty.
     *
     * @return {@code true} if the linkedStack is empty, returns {@code false} if it's not
     */
    boolean isEmpty();
}
