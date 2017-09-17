package org.gorillacorp.linked_list;

public abstract class ListElement {

	protected Object data;

	protected ListElement leftElement = null;
	protected ListElement rightElement = null;

	// public constructor
	public ListElement(Object data) {
		this.data = data;
	}

	// abstract methods, implemented by the Node element
	public abstract ListElement previousElement();

	public abstract ListElement nextElement();

	public abstract ListElement setPrevious(ListElement element);

	public abstract ListElement setNext(ListElement element);

	public abstract int compareTo(ListElement otherElement);

	// getters and setters
	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
