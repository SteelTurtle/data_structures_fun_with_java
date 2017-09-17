package org.gorillacorp.stack;

//A super simple Stack. No, seriously...
public class Stack<T> {

	private T[] stack;
	private int maxCapacity;
	private int currentTopIndex;
	
	
	@SuppressWarnings("unchecked")
	public Stack(final int initialCapacity) {
		this.maxCapacity = initialCapacity;
		this.stack = (T[]) new Object[initialCapacity];
		this.currentTopIndex = -1;
	}

	public void push(T element) {
		if (this.isFull()) {
			System.out.println("The stack is already full; cannot add new elements.");
		} else {
			this.currentTopIndex++;
			stack[currentTopIndex] = element;
		}

	}

	public T pop() {
		if (this.isEmpty()) {
			System.out.println("The stack is empty; there are no elements to extract.");
			return null;
		} else {
			int oldTopIndex = currentTopIndex;
			currentTopIndex--;
			return stack[oldTopIndex];
		}
	}

	public T peak() {
		return stack[currentTopIndex];
	}

	public boolean isEmpty() {
		return (currentTopIndex == -1);
	}

	public boolean isFull() {
		return (maxCapacity - 1 == currentTopIndex);
	}
}
