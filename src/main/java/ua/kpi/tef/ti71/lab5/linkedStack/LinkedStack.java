package ua.kpi.tef.ti71.lab5.linkedStack;


import ua.kpi.tef.ti71.lab5.util.Node;

public class LinkedStack<T> implements Stack<T> {
	private Node<T> head;
	private int size;

	public LinkedStack() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public void push(T element) {
		this.head = new Node<>(this.head, element);
		this.size++;
	}

	@Override
	public T pop() {
		if (this.size > 0) {
			T value = this.head.getValue();
			this.head = this.head.getPrevious();
			this.size--;
			return value;
		} else {
			throw new EmptyStackException();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
}
