package org.gorillacorp.linked_list;

public class CustomLinkedList implements I_NodeOperations {

	private ListElement rootElement = null;

	@Override
	public ListElement getRootElement() {
		return this.rootElement;
	}

	@Override
	public boolean addListElement(ListElement newElement) {
		if (this.rootElement == null) {
			// the list is empty, so this item will be the first
			this.rootElement = newElement;
			return true;
		}
		// else, cycle through the list until the end to insert a new element
		ListElement currentElement = this.rootElement;
		while (currentElement != null) {
			// our implementation of compareTo() works on Strings (and their compareTo()
			// logic)
			int comparator = currentElement.compareTo(newElement);
			if (comparator < 0) {
				// newElement data is greater, move it to right if possible
				if (currentElement.nextElement() != null) {
					currentElement = currentElement.nextElement();
				} else {
					// we reached the end of the list: newElement becomes the last element,
					// currentElement the element before last...
					currentElement.setNext(newElement);
					newElement.setPrevious(currentElement);
					return true;
				}
			} else if (comparator > 0) {
				// newElement data is smaller, move it to left if possible
				if (currentElement.previousElement() != null) {
					currentElement.setPrevious(newElement);
					newElement.setPrevious(currentElement.previousElement());
					newElement.setNext(currentElement);
					currentElement.setPrevious(newElement);
				} else {
					// we reached the beginning of the list, the previous element is the root
					newElement.setNext(this.rootElement);
					this.rootElement.setPrevious(newElement);
					this.rootElement = newElement;
				}
				return true;
			} else {
				// elements are equal
				System.out.println(newElement.getData() + " is already in the list.");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeListElement(ListElement elementToRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void traverseNode(ListElement rootElement) {
		// TODO Auto-generated method stub

	}
}
