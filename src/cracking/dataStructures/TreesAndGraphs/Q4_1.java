package cracking.dataStructures.TreesAndGraphs;

import cracking.dataStructures.helper.TreeNode;

public class Q4_1 {
	// 4.1 Implement a function to check if a tree is balanced. For the purposes
	// of this question, a balanced tree is
	// defined to be a tree such that no two leaf nodes differ in distance from
	// the root by more than one.
	public static boolean isBalanced(TreeNode tree) {
		boolean ret = false;

		if (tree == null) {
			return true;
		}

		ret = (Math.abs(getHeight(tree.left) - getHeight(tree.right)) <= 1)
				&& (Math.abs(getHeight(tree.left) - getHeight(tree.right)) >= 0) && isBalanced(tree.left)
				&& isBalanced(tree.right);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Visiting " + tree.value);
		System.out.println("---Left: " + getHeight(tree.left));
		System.out.println("---Right: " + getHeight(tree.right));
		System.out.println("---" + Math.abs(getHeight(tree.left) - getHeight(tree.right)));

		return ret;
	}

	public static int getHeight(TreeNode treeNode) {
		int ret = 0;
		if (treeNode != null) {
			ret = Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n2.left = n6;
		n2.right = n7;

		System.out.println(isBalanced(n1));
	}
}
