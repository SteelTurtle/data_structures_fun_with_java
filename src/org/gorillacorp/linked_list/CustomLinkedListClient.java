package org.gorillacorp.linked_list;

public class CustomLinkedListClient {

	public static void main(String[] args) {

		CustomLinkedList customLinkedList = new CustomLinkedList(null);
		String rawListData = "elther farenheit gamma hound alpha bravo delta omega tau xenon zelda";
		String[] listData = rawListData.split(" ");
		for (String s : listData) {
			customLinkedList.addListElement(new Node(s));
		}
		customLinkedList.traverseNodes(customLinkedList.getRootElement());

		customLinkedList.removeListElement(new Node("delta"));
		customLinkedList.removeListElement(new Node("hound"));
		customLinkedList.removeListElement(new Node("tau"));
		customLinkedList.removeListElement(new Node("zelda"));

		customLinkedList.traverseNodes(customLinkedList.getRootElement());

		// Let's test a search tree as well
		System.out.println("...Using a Search Tree now...");
		SearchTree searchTree = new SearchTree(null);
		for (String s : listData) {
			searchTree.addListElement(new Node(s));
		}
		searchTree.traverseNodes(searchTree.getRootElement());
		searchTree.removeListElement(new Node("hound"));
		searchTree.traverseNodes(searchTree.getRootElement());
	}

}
