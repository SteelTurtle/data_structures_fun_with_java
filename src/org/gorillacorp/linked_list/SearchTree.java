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
		// else, let's look for the first feasible place to create a new
		// element. We start counting from the root element:
		ListElement currentElement = this.rootElement;
		while (currentElement != null) {
			int comparator = (currentElement.compareTo(newElement));
			if (comparator < 0) {
				// newElement data have a greater value; try to add newElement
				// node on the right
				if (currentElement.nextElement() != null) {
					currentElement = currentElement.nextElement();
				} else {
					currentElement.setNext(newElement);
					return true;
				}
			} else if (comparator > 0) {
				// newElement data have a lesser value; try to add newElement
				// node on the left
				if (currentElement.previousElement() != null) {
					currentElement = currentElement.previousElement();
				} else {
					currentElement.setPrevious(newElement);
					return true;
				}
			} else {
				// else, newElement and currentElement data vales are equal. Do
				// not add a duplicate.
				System.out.println(newElement.getData()
						+ " is already present in the search tree");
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean removeListElement(ListElement elementToRemove) {
		if (elementToRemove != null) {
			System.out.println("Deleting element data from the tree: "
					+ elementToRemove.getData());
		}
		ListElement currentElement = this.rootElement;
		// initially set the parent element (of the element to delete) to
		// currentElement
		ListElement parentElement = currentElement;
		while (currentElement != null) {
			int comparator = currentElement.compareTo(elementToRemove);
			if (comparator < 0) {
				parentElement = currentElement;
				currentElement = currentElement.nextElement();
			} else if (comparator > 0) {
				parentElement = currentElement;
				currentElement = currentElement.previousElement();
			} else {
				// we have found the element to remove (currentElement and
				// elementToRemove are the same object)
				removeElementStructure(currentElement, parentElement);
				return true;
			}
		}
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

	private void removeElementStructure(ListElement currentElement,
			ListElement parentElement) {
		// remove the current element from the tree
		if (currentElement.nextElement() == null) {
			// no right tree, so make parent point to left tree (which may be
			// null)
			if (parentElement.nextElement() == currentElement) {
				// the current element is right child of its parent
				parentElement.setNext(currentElement.previousElement());
			} else if (parentElement.previousElement() == currentElement) {
				// the current element is left child of its parent
				parentElement.setPrevious(currentElement.previousElement());
			} else {
				// parent must be the current element, which means we were looking at the root
				// of the tree
				this.rootElement = currentElement.previousElement();
			}
		} else if (currentElement.previousElement() == null) {
			// no left tree, so make parent point to right tree (which may be
			// null)
			if (parentElement.nextElement() == currentElement) {
				// the current element is right child of its parent
				parentElement.setNext(currentElement.nextElement());
			} else if (parentElement.previousElement() == currentElement) {
				// the current element is left child of its parent
				parentElement.setPrevious(currentElement.nextElement());
			} else {
				// again, we are deleting the root
				this.rootElement = currentElement.nextElement();
			}
		} else {
			// neither left nor right are null, deletion is now a lot trickier!
			// From the right sub-tree, find the smallest value (i.e., the
			// leftmost).
			ListElement current = currentElement.nextElement();
			ListElement leftmostParent = currentElement;
			while (current.previousElement() != null) {
				leftmostParent = current;
				current = current.previousElement();
			}
			// Now put the smallest value into our node to be deleted
			currentElement.setData(current.getData());
			// and delete the smallest
			if (leftmostParent == currentElement) {
				// there was no leftmost node, so 'current' points to the
				// smallest
				// node (the one that must now be deleted).
				currentElement.setNext(current.nextElement());
			} else {
				// set the smallest node's parent to point to
				// the smallest node's right child (which may be null).
				leftmostParent.setPrevious(current.nextElement());
			}
		}
	}

}
