package org.gorillacorp.linked_list;

public abstract class ListElement<T> {

	private T data;

	protected ListElement<T> leftElement = null;
	protected ListElement<T> rightElement = null;
	
	// public constructor
	public ListElement(T data) {
		this.data = data;
	}

	// abstract methods, implemented by the Node element
	public abstract ListElement<T> previousElement();

	public abstract ListElement<T> nextElement();

	public abstract ListElement<T> setPrevious(ListElement<T> element);

	public abstract ListElement<T> setNext(ListElement<T> element);

	public abstract int compareTo(ListElement<T> element);

	// getters and setters
	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
