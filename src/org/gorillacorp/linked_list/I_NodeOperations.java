package org.gorillacorp.linked_list;

public interface I_NodeOperations {
	ListElement getRootElement();
	boolean addListElement(ListElement newElement);
	boolean removeListElement(ListElement elementToRemove);
	void traverseNodes(ListElement rootElement);
}
