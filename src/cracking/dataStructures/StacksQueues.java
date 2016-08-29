package cracking.dataStructures;

public class StacksQueues {

	public static Object[] threeStacks;

	public static void initializeStacks(int arrSize) {
		threeStacks = new Object[arrSize];

		for (int i = 0; i < threeStacks.length; i++) {
			threeStacks[i] = null;
		}
	}

	public static void printThreStacks() {
		for (int i = 0; i < threeStacks.length; i++) {
			System.out.println(threeStacks[i]);
		}
		System.out.println("************************************************");
	}

	// Describe how you could use a single array to implement three stacks.
	public static void pushThreeStacksInArray(int stackId, Object item) {
		boolean found = false;

		while (stackId < threeStacks.length && found == false) {
			if (threeStacks[stackId] == null) {
				threeStacks[stackId] = item;
				found = true;
			} else {
				stackId = stackId + 3;
			}
		}
	}

	public static Object popThreeStacksInArray(int stackId) {
		boolean found = false;
		Object ret = null;

		while (stackId < threeStacks.length && found == false) {
			if (threeStacks[stackId] != null && threeStacks[stackId + 3] == null) {
				ret = threeStacks[stackId];
				found = true;
				threeStacks[stackId] = null;
			} else {
				stackId = stackId + 3;
			}
		}

		return ret;
	}

	// public static Object popThreeStacksInArray(){
	//
	// }

	public static void main(String[] args) {
		// Stack pila = new Stack();
		// Integer i1 = 1;
		// Integer i2 = 2;
		// Integer i3 = 3;
		// String s1 = "hola";
		// String s2 = "chau";
		//
		// pila.push(i1);
		// pila.push(i2);
		// pila.push(i3);
		// pila.push(s1);
		// pila.push(s2);
		//
		//
		// Object o = pila.pop();
		// while(o != null){
		// System.out.println("*****" + o.toString());
		// o = pila.pop();
		// }

		StacksQueues stacksQueues = new StacksQueues();
		stacksQueues.initializeStacks(24);
		pushThreeStacksInArray(0, "hola");
		pushThreeStacksInArray(0, "chau");
		pushThreeStacksInArray(0, 3);
		pushThreeStacksInArray(1, "hello");
		pushThreeStacksInArray(1, "bye");
		pushThreeStacksInArray(1, "tres");
		pushThreeStacksInArray(2, "ciao");
		pushThreeStacksInArray(2, "arrivederchi");
		pushThreeStacksInArray(2, "tritri");

		printThreStacks();

		popThreeStacksInArray(0);
		popThreeStacksInArray(0);
		popThreeStacksInArray(0);
		popThreeStacksInArray(1);
		popThreeStacksInArray(1);
		popThreeStacksInArray(1);
		popThreeStacksInArray(2);
		popThreeStacksInArray(2);
		
		printThreStacks();
	}

}

// class Queue {
// Node first, last;
//
// void enqueue(Object item) {
// if (!first) {
// back = new Node(item);
// first = back;
// } else {
// back.next = new Node(item);
// back = back.next;
// }
// }
//
// Node dequeue(Node n) {
// if (front != null) {
// Object item = front.data;
// front = front.next;
// return item;
// }
// return null;
// }
// }

class Stack {
	Node1 top;

	public Object pop() {
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
