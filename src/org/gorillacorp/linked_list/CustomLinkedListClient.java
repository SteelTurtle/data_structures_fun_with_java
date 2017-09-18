package org.gorillacorp.linked_list;

public class CustomLinkedListClient {

	public static void main(String[] args) {

		CustomLinkedList customLinkedList = new CustomLinkedList(null);
		String rawListData = "alpha bravo delta elther farenheit gamma hound omega tau xenon zelda";
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
		SearchTree searchTree = new SearchTree(null);
		for (String s : listData) {
			searchTree.addListElement(new Node(s));
		}
		searchTree.traverseNodes(searchTree.getRootElement());


	}

}
