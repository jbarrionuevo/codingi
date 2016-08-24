package cracking.dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedLists {
	// 2.1 Write code to remove duplicates from an unsorted linked list.
	// FOLLOW UP
	// How would you solve this problem if a temporary buffer is not allowed?
	//
	public static Node removeDuplicates(Node node) {

		while (node != null) {
			int data = node.data;

			Node nodePrev = node;
			Node nodeNext = node.next;

			while (nodeNext != null) {

				if (nodeNext.data == data) {
					nodePrev.next = nodeNext.next;
					nodeNext = nodeNext.next;
				} 
				else {
					nodeNext = nodeNext.next;
					nodePrev = nodePrev.next;
					nodePrev.next = nodeNext;
				}

				nodeNext = nodePrev.next;
			}

			Node nx = node;
			node = node.next;
		}

		return node;
	}

	public static void main(String[] args) {
		// Node n1 = new Node(5);
		// Node n2 = new Node(1);
		// Node n3 = new Node(6);
		// Node n4 = new Node(5);
		// Node n5 = new Node(2);
		// Node n6 = new Node(5);
		// Node n7 = new Node(7);
		// List<Node> al = new ArrayList<Node>();
		// Iterator<Node> it = al.iterator();

		List<Integer> al = new ArrayList<Integer>();

		al.add(7);
		al.add(6);
		al.add(2);
		al.add(5);
		al.add(4);
		al.add(1);
		al.add(3);
		al.add(2);
		al.add(8);
		al.add(5);
		al.add(1);

		Node n = new Node(9);

		Iterator<Integer> it = al.iterator();
		while (it.hasNext()) {
			int a = it.next();
			n.appendToTail(a);
		}

		removeDuplicates(n);

		while (n != null) {
			System.out.println("***** " + n.data);
			n = n.next;
		}

	}
}

class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
}
