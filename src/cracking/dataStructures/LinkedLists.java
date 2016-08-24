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
				} else {
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

	// Implement an algorithm to find the nth to last element of a singly linked
	// list
	// If the elements are 8->10->5->7->2->1->5->4->10->10 then the result is
	// 7th to last node is 7
	//2.2
	public static int findNthToLastElement(Node node, int n) {
		int count = 1;

		while (node != null && count != n) {
			node = node.next;
			count++;
		}
		System.out.println("*********** n = " + node.data);
		count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}

	//2.3
	//Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
	//EXAMPLE
	//Input: the node ‘c’ from the linked list a->b->c->d->e
	//Result: nothing is returned, but the new linked list looks like a->b->d->e
	public static void deleteMidNode(Node node) {
		Node prev = node;
		while (node.next.next != null) {
			node.data = node.next.data;
			// node.next = node.next.next;
			prev = node;
			node = node.next;
		}
		prev.next = null;
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

		// ******testing remove duplicates

//		List<Integer> al = new ArrayList<Integer>();
//
//		al.add(7);
//		al.add(6);
//		al.add(2);
//		al.add(5);
//		al.add(4);
//		al.add(1);
//		al.add(3);
//		al.add(2);
//		al.add(8);
//		al.add(5);
//		al.add(1);
//
//		Node n = new Node(9);
//
//		Iterator<Integer> it = al.iterator();
//		while (it.hasNext()) {
//			int a = it.next();
//			n.appendToTail(a);
//		}
		//
		// removeDuplicates(n);
		//
		// while (n != null) {
		// System.out.println("***** " + n.data);
		// n = n.next;
		// }

		// ******testing nth to last

		//System.out.println("Nth to last: " + findNthToLastElement(n, 3));
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=null;
		
		deleteMidNode(n4);
		
		Node n = n1;
		
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
