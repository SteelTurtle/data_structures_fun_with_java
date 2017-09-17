package org.gorillacorp.linked_list;

public class Node extends ListElement {

	public Node(Object data) {
		super(data);
	}

	@Override
	public ListElement previousElement() {
		return this.leftElement;
	}

	@Override
	public ListElement nextElement() {
		return this.rightElement;
	}

	@Override
	public ListElement setPrevious(ListElement element) {
		this.leftElement = element;
		return this.leftElement;
	}

	@Override
	public ListElement setNext(ListElement element) {
		this.rightElement = element;
		return this.rightElement;
	}

	@Override
	public int compareTo(ListElement otherElement) {
		if(otherElement != null) {
			return ((String) super.getData()).compareTo((String) otherElement.getData());
		} else {
			return -1;
		}
	}

}
