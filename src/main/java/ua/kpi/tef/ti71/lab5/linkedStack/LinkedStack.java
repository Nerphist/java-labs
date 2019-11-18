package ua.kpi.tef.ti71.lab5.linkedStack;


import ua.kpi.tef.ti71.lab5.util.Node;

public class LinkedStack<T> implements Stack<T> {
	private Node<T> tail;
	private int size;

	public LinkedStack() {
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void push(T element) {
		this.tail = new Node<>(this.tail, element);
		this.size++;
	}

	@Override
	public T pop() {
		if (this.size > 0) {
			T value = this.tail.getValue();
			this.tail = this.tail.getPrevious();
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
