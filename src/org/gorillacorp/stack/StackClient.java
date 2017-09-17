package org.gorillacorp.stack;

public class StackClient {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>(10);
		stack.push(2);
		stack.push(6);
		stack.push(622);
		stack.push(245);
		stack.push(99);
		stack.push(848434);
		stack.push(23232332);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
