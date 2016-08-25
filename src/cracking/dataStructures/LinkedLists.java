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
	// 2.2
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

	// 2.3
	// Implement an algorithm to delete a node in the middle of a single linked
	// list, given only access to that node.
	// EXAMPLE
	// Input: the node ‘c’ from the linked list a->b->c->d->e
	// Result: nothing is returned, but the new linked list looks like
	// a->b->d->e
	public static void deleteMidNode(Node node) {
		Node prev = node;
		while (node.next.next != null) {
			node.data = node.next.data;
			prev = node;
			node = node.next;
		}
		prev.next = null;
	}

	// 2.4
	// You have two numbers represented by a linked list, where each node
	// contains a single digit. The digits are stored in reverse order,
	// such that the 1’s digit is at the head of the list. Write a function that
	// adds the two numbers and returns the sum as a linked list.
	// EXAMPLE
	// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	// Output: 8 -> 0 -> 8
	public static Node listSum(Node n1, Node n2) {
		int a = listToInt(n1);
		int b = listToInt(n2);

		return intToList(a + b);
	}

	public static int listToInt(Node n1) {
		int i = 1;
		int count = 0;
		while (n1 != null) {
			count = n1.data * i + count;
			i = i * 10;
			n1 = n1.next;
		}
		return count;
	}

	public static Node intToList(int i1) {
		Node node = new Node(i1 % 10);
		i1 = i1 / 10;
		while (i1 > 0) {
			node.appendToTail(i1 % 10);
			i1 = i1 / 10;
			System.out.println("i1= " + i1);
		}
		return node;
	}

	public static List<Integer> digits(int i) {
		List<Integer> digits = new ArrayList<Integer>();
		while (i > 0) {
			System.out.println("i % 10 = " + i % 10);
			digits.add(i % 10);
			System.out.println("i / 10 = " + i / 10);
			i /= 10;
		}
		return digits;
	}

	// Given a circular linked list, implement an algorithm which returns node
	// at the beginning of the loop.
	// DEFINITION
	// Circular linked list: A (corrupt) linked list in which a node’s next
	// pointer points to an earlier node, so as to make a loop in the linked
	// list.
	// EXAMPLE
	// input: A -> B -> C -> D -> E -> C [the same C as earlier]
	// output: C
	// 2.5
	public static Node getFirstNodeInCircularLinkedList(Node n1) {
		Node list = n1;

		while (isEarlier(list, n1.next, n1) == false) {
			n1 = n1.next;
		}

		return n1.next;
	}

	public static boolean isEarlier(Node list, Node ne, Node nl) {
		boolean foundEarlier = false;
		boolean foundLast = false;

		while (foundEarlier == false && foundLast == false) {
			if (list == ne && foundLast == false) {
				foundEarlier = true;
			} else if (list == nl && foundLast == false) {
				foundLast = true;
			}
			list = list.next;
		}
		return foundEarlier;
	}

	// method provided in book (adapted to Java version)
	public static Node deleteNode(Node head, int d) {
		Node n = head;
		Node ret = null;

		if (n.data == d) {
			ret = head.next; /* moved head */
		} else {
			while (n.next != null) {
				if (n.next.data == d) {
					n.next = n.next.next;
					ret = head; /* head didn’t change */
				}
				n = n.next;
			}
		}
		return ret;
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

		// List<Integer> al = new ArrayList<Integer>();
		//
		// al.add(7);
		// al.add(6);
		// al.add(2);
		// al.add(5);
		// al.add(4);
		// al.add(1);
		// al.add(3);
		// al.add(2);
		// al.add(8);
		// al.add(5);
		// al.add(1);
		//
		// Node n = new Node(9);
		//
		// Iterator<Integer> it = al.iterator();
		// while (it.hasNext()) {
		// int a = it.next();
		// n.appendToTail(a);
		// }
		//
		// removeDuplicates(n);
		//
		// while (n != null) {
		// System.out.println("***** " + n.data);
		// n = n.next;
		// }

		// ******testing nth to last

		// System.out.println("Nth to last: " + findNthToLastElement(n, 3));

		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		;
		// Node n7 = new Node(7);
		//
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n2;
		// n7.next=null;
		//
		// deleteMidNode(n4);
		//
		// Node n = n1;
		//
		// while (n != null) {
		// System.out.println("***** " + n.data);
		// n = n.next;
		// }

		// List<Integer> l1 = digits(4590);
		// System.out.println(l1.toString());
		// System.out.println(listToInt(n1));

		// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
		// Node n8 = listSum(n1, n4);
		// while (n1 != null) {
		// System.out.println("***** " + n1.data);
		// n1 = n1.next;
		// }

		System.out.println("n1.data = " + getFirstNodeInCircularLinkedList(n1).data);

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
