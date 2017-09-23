package org.gorillacorp.linked_list;

public class CustomLinkedList implements I_NodeOperations {

	private ListElement rootElement = null;

	public CustomLinkedList(ListElement rootElement) {
		this.rootElement = rootElement;
	}

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
			// our implementation of compareTo() works on Strings (and their
			// compareTo()
			// logic)
			int comparator = currentElement.compareTo(newElement);
			if (comparator < 0) {
				// newElement data is greater, move it to right if possible
				if (currentElement.nextElement() != null) {
					currentElement = currentElement.nextElement();
				} else {
					// we reached the end of the list: newElement becomes the
					// last element,
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
					// we reached the beginning of the list, the previous
					// element is the root
					newElement.setNext(this.rootElement);
					this.rootElement.setPrevious(newElement);
					this.rootElement = newElement;
				}
				return true;
			} else {
				// elements are equal
				System.out.println(
						newElement.getData() + " is already in the list.");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeListElement(ListElement elementToRemove) {
		if (elementToRemove != null) {
			System.out.println("Deleting element " + elementToRemove.getData());
		}
		// loop through the list starting from the root element, until the
		// element to be
		// removed is found.
		ListElement currentElement = this.rootElement;
		while (currentElement != null) {
			int comparator = currentElement.compareTo(elementToRemove);
			// if the elementToRemove is found:
			if (comparator == 0) {
				// test if it is the root element...
				if (currentElement == this.rootElement) {
					this.rootElement = currentElement.nextElement();
				} else {
					// ...else "connect" the previous element to the next,
					// preparing the current
					// element for deletion...
					currentElement.previousElement()
							.setNext(currentElement.nextElement());
					// ... also check if the next node is actually NOT null
					// (that is, the end of the
					// list)!
					if (currentElement.nextElement() != null) {
						// complement to line 81
						currentElement.nextElement()
								.setPrevious(currentElement.previousElement());
					}
				}
				return true;
			} else if (comparator < 0) {
				// keep on traversing to find the element
				currentElement = currentElement.nextElement();
			} else if (comparator > 0) {
				// if the comparator is greater than 0, it means we are past the
				// string we were
				// looking for and there is no meaning in keep searching...
				return false;
			}
		}
		// we have reached the end of the list without finding the string we
		// were
		// looking for.
		return false;
	}

	@Override
	// traverse and show the content of the linked list
	public void traverseNodes(ListElement rootElement) {
		if (rootElement == null) {
			System.out.println(
					"This list is empty; there is not any root element.");
		} else {
			while (rootElement != null) {
				System.out.println(rootElement.getData());
				rootElement = rootElement.nextElement();
			}

		}

	}
}
