package cracking.dataStructures;

import java.util.ArrayList;
import java.util.List;

import utils.Tuple;

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

	// 3.1 Describe how you could use a single array to implement three stacks.
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

	// 3.3
	// TODO
	// Imagine a (literal) stack of plates. If the stack gets too high, it might
	// topple. Therefore, in real life, we would likely start
	// a new stack when the previous stack exceeds some threshold. Implement a
	// data structure SetOfStacks that mimics this. SetOfStacks
	// should be composed of several stacks, and should create a new stack once
	// the previous one exceeds capacity. SetOfStacks.push() and
	// SetOfStacks.pop() should behave identically to a single stack (that is,
	// pop() should return the same values as it would if there were
	// just a single stack).
	// FOLLOW UP
	// Implement a function popAt(int index) which performs a pop operation on a
	// specific sub-stack.

	public class SetOfStacks {
		// NodeOfStack top;
		int stackThreshold;
		List<NodeOfStack> stacks;

		SetOfStacks(int stackThresholdO) {
			stackThreshold = stackThresholdO;
			stacks = new ArrayList<NodeOfStack>();
		}

		public Object pop() {
			int stackId = getActiveStack();
			try {
				if (stacks.get(stackId) != null) {
					NodeOfStack tempNode = stacks.get(stackId);
					if (tempNode.getOrder() > 1 && tempNode.getOrder() <= stackThreshold) {

						NodeOfStack nodeTemp1 = (NodeOfStack) tempNode.getNextNode();
						tempNode.next = null;
						stacks.set(stackId, nodeTemp1);
					}

					else if (tempNode.getOrder() == 1) {
						stacks.remove(tempNode);
					}

					return tempNode;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("******************Exception captured" + e.getMessage());
			}

			return null;
		}

		public Object peek() {
			int stackId = getActiveStack();
			if (stacks.get(stackId) != null) {
				Object node = stacks.get(stackId);
				return node;
			}
			return null;
		}

		void push(Object item) {
			int stackId = getActiveStack();

			// adding a node to the stack, if the stack is not full
			if (stacks.size() != 0 && stacks.get(stackId) != null && stacks.get(stackId).getOrder() < stackThreshold) {
				NodeOfStack nodeTemp = stacks.get(stackId);
				NodeOfStack nodeTemp1 = new NodeOfStack(item, nodeTemp.getOrder() + 1);
				nodeTemp1.append(nodeTemp);
				stacks.set(stackId, nodeTemp1);
			}
			// creating a new stack and node
			else {
				NodeOfStack nodeTemp2 = new NodeOfStack(item, 1);
				stacks.add(nodeTemp2);
			}
		}

		public int getActiveStack() {
			int ret = 0;
			int i = 0;
			while (i < stacks.size()) {
				if (stacks.get(i) != null) {
					NodeOfStack tempNodeOfStack = stacks.get(i);
					// the following conditions are not necessary
					if (tempNodeOfStack != null && tempNodeOfStack.getOrder() > 0
							&& tempNodeOfStack.getOrder() <= stackThreshold) {
						ret = i;
					}
				}
				i++;
			}
			return ret;
		}

		public Object popAt(int index) {
			Tuple<Integer, Integer> t = mapToStackAndOrder(stackThreshold, index);
			int stackId = t.x;
			int order = t.y;

			try {
				if (stacks.get(stackId) != null) {
					NodeOfStack prevNode = null;
					NodeOfStack tempNode = stacks.get(stackId);
					boolean found = false;
					while (found == false) {
						if (tempNode.getOrder() == order) {
							found = true;
							if (prevNode != null) {
								prevNode.next = tempNode.next;
							}
							tempNode.next = null;
							stacks.remove(tempNode);
						} else {
							prevNode = tempNode;
							tempNode = tempNode.next;
						}
					}
					return tempNode;

				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("******************Exception captured" + e.getMessage());
			}
			return null;
		}

		public String toString() {

			for (int i = 0; i < stacks.size(); i++) {
				System.out.println("**** Stack printed: " + i);
				NodeOfStack n = stacks.get(i);
				String item = (String) n.getItem();
				System.out.println("******** Top Node: " + item);
				System.out.println("******** Order of node: " + n.getOrder());
			}

			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public static Tuple<Integer, Integer> mapToStackAndOrder(int stackThreshold, int absoluteIndex) {
		double stackThresholdD = stackThreshold;
		double absoluteIndexD = absoluteIndex;
		double stackId = Math.ceil(absoluteIndexD / stackThresholdD);
		double order = Math.abs(absoluteIndex - (stackId - 1) * stackThreshold);
		Double stackIdD = stackId;
		Double orderD = order;

		return new Tuple<Integer, Integer>(stackIdD.intValue(), orderD.intValue());
	}

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

		// StacksQueues stacksQueues = new StacksQueues();
		// stacksQueues.initializeStacks(24);
		// pushThreeStacksInArray(0, "hola");
		// pushThreeStacksInArray(0, "chau");
		// pushThreeStacksInArray(0, 3);
		// pushThreeStacksInArray(1, "hello");
		// pushThreeStacksInArray(1, "bye");
		// pushThreeStacksInArray(1, "tres");
		// pushThreeStacksInArray(2, "ciao");
		// pushThreeStacksInArray(2, "arrivederchi");
		// pushThreeStacksInArray(2, "tritri");
		//
		// printThreStacks();
		//
		// popThreeStacksInArray(0);
		// popThreeStacksInArray(0);
		// popThreeStacksInArray(0);
		// popThreeStacksInArray(1);
		// popThreeStacksInArray(1);
		// popThreeStacksInArray(1);
		// popThreeStacksInArray(2);
		// popThreeStacksInArray(2);
		//
		// printThreStacks();

		StacksQueues stacksQueues = new StacksQueues();
		SetOfStacks setOfStacks = stacksQueues.new SetOfStacks(2);

		setOfStacks.push(new String("perro"));
		setOfStacks.push(new String("gato"));
		setOfStacks.push(new String("canario"));
		setOfStacks.push(new String("rinoceronte"));
		setOfStacks.push(new String("hipopotamo"));

		setOfStacks.popAt(3);

		setOfStacks.toString();

		System.out.println("--------------------------------------------------------------------------------------");

		// setOfStacks.pop();
		// setOfStacks.pop();
		// setOfStacks.pop();
		// setOfStacks.pop();
		// setOfStacks.pop();
		// setOfStacks.pop();

		setOfStacks.toString();

		// System.out.println("***************************************************"
		// );
		// Tuple<Integer, Integer> t = mapToStackAndOrder(4,5);
		// System.out.println("mapToStackAndOrder(4,5)" + "stack: " + t.x + " /
		// order: " + t.y);
		// Tuple<Integer, Integer> t1 = mapToStackAndOrder(4,2);
		// System.out.println("mapToStackAndOrder(4,2)" + "stack: " + t1.x + " /
		// order: " + t1.y);
		// Tuple<Integer, Integer> t2 = mapToStackAndOrder(4,11);
		// System.out.println("mapToStackAndOrder(4,11)" + "stack: " + t2.x + "
		// / order: " + t2.y);
		// Tuple<Integer, Integer> t3 = mapToStackAndOrder(4,1);
		// System.out.println("mapToStackAndOrder(4,1)" + "stack: " + t3.x + " /
		// order: " + t3.y);
		// Tuple<Integer, Integer> t4 = mapToStackAndOrder(4,6);
		// System.out.println("mapToStackAndOrder(4,6)" + "stack: " + t4.x + " /
		// order: " + t4.y);
		// Tuple<Integer, Integer> t5 = mapToStackAndOrder(4,2);
		// System.out.println("mapToStackAndOrder(4,2)" + "stack: " + t5.x + " /
		// order: " + t5.y);
		// Tuple<Integer, Integer> t6 = mapToStackAndOrder(4,3);
		// System.out.println("mapToStackAndOrder(4,3)" + "stack: " + t6.x + " /
		// order: " + t6.y);
		//
		// Tuple<Integer, Integer> t7 = mapToStackAndOrder(4,11);
		// System.out.println("mapToStackAndOrder(4,11)" + "stack: " + t7.x + "
		// / order: " + t7.y);
		//
		// Tuple<Integer, Integer> t8 = mapToStackAndOrder(4,10);
		// System.out.println("mapToStackAndOrder(4,10)" + "stack: " + t8.x + "
		// / order: " + t8.y);
		//
		// Tuple<Integer, Integer> t9 = mapToStackAndOrder(4,9);
		// System.out.println("mapToStackAndOrder(4,9)" + "stack: " + t9.x + " /
		// order: " + t9.y);
		//
		// Tuple<Integer, Integer> t10 = mapToStackAndOrder(4,8);
		// System.out.println("mapToStackAndOrder(4,8)" + "stack: " + t10.x + "
		// / order: " + t10.y);
		//
		// Tuple<Integer, Integer> t11 = mapToStackAndOrder(4,12);
		// System.out.println("mapToStackAndOrder(4,12)" + "stack: " + t11.x + "
		// / order: " + t11.y);
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

// 3.2 How would you design a stack which, in addition to push and pop, also has
// a function min which returns the minimum element?
// Push, pop and min should all operate in O(1) time.
// TODO

class StackMin {
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

	// added by Jorge
	public Object peek() {
		if (top != null) {
			Object item = top.data;
			return item;
		}
		return null;
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

class NodeOfStack {
	NodeOfStack next = null;
	Object item;
	int order;

	public NodeOfStack(Object itemO, int orderO) {
		item = itemO;
		order = orderO;
	}

	void append(NodeOfStack nextNode) {
		this.next = nextNode;
	}

	public int increaseOrder() {
		order++;
		return order;
	}

	public int decreaseOrder() {
		order--;
		return order;
	}

	public int getOrder() {
		return order;
	}

	public Object getItem() {
		return item;
	}

	public NodeOfStack getNextNode() {
		return next;
	}
}