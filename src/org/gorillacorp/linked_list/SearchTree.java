package org.gorillacorp.linked_list;

// A search tree is an implementation variant of a linked list. 
// But it is a binary search tree. 
// Well, it's complicated...
public class SearchTree implements I_NodeOperations {

	private ListElement rootElement = null;

	// constructor
	public SearchTree(ListElement rootElement) {
		this.rootElement = rootElement;
	}

	@Override
	public ListElement getRootElement() {
		// TODO Auto-generated method stub
		return this.rootElement;
	}

	@Override
	public boolean addListElement(ListElement newElement) {
		// if the tree is empty:
		if (this.rootElement == null) {
			this.rootElement = newElement;
			return true;
		}
		// else:
		ListElement currentElement = this.rootElement;
		while (currentElement != null) {
			int comparator = (currentElement.compareTo(newElement));
			if (comparator < 0) {
				if (currentElement.nextElement() != null) {
					currentElement = currentElement.nextElement();
				} else {
					currentElement.setNext(newElement);
					return true;
				}
			} else if(comparator > 0) {
				
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
	public void traverseNodes(ListElement rootElement) {
		// differently from the same method used in a linked list the search
		// tree version uses recursion to search through the left and right
		// elements of the data structure.
		if (rootElement != null) {
			// left nodes
			traverseNodes(rootElement.previousElement());
			System.out.println(rootElement.getData());
			// right nodes
			traverseNodes(rootElement.nextElement());
		}
	}

}
