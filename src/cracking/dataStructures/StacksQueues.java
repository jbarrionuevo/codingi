package cracking.dataStructures;

public class StacksQueues {

}

//class Queue {
//	Node first, last;
//
//	void enqueue(Object item) {
//		if (!first) {
//			back = new Node(item);
//			first = back;
//		} else {
//			back.next = new Node(item);
//			back = back.next;
//		}
//	}
//
//	Node dequeue(Node n) {
//		if (front != null) {
//			Object item = front.data;
//			front = front.next;
//			return item;
//		}
//		return null;
//	}
//}

class Stack {
	Node1 top;

	public Node1 pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}

	void push(Object item) {
		Node1 t = new Node1(item);
		t.next = top;
		top = t;
	}
}

class Node1 {
	Node1 next = null;
	Object data;

	public Node1(Object d) {
		data = d;
	}

	void appendToTail(int d) {
		Node1 end = new Node1(d);
		Node1 n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
