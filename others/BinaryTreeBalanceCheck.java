public class BinaryTreeBalanceCheck {

	Node root;

	// Check height balance
	boolean checkHeightBalance(Node node) {

		// leaf node
		if (node.left == null && node.right == null) {
			node.height = 0;
			return true;
		}

		if (node.left != null && node.right != null) {
			boolean leftBalanced = checkHeightBalance(node.left);
			boolean rightBalanced = checkHeightBalance(node.right);

			int diff = Math.abs(node.left.height - node.right.height);

			if (!leftBalanced || !rightBalanced || diff > 1)
				return false;

			node.height = node.left.height > node.right.height ? (node.left.height + 1) : (node.right.height + 1);
		}

		else if (node.left != null) {
			boolean leftBalanced = checkHeightBalance(node.left);

			// tree not balanced
			if (!leftBalanced || node.left.height > 1)
				return false;

			node.height = node.left.height + 1;
		}

		else if (node.right != null) {
			boolean rightBalanced = checkHeightBalance(node.right);

			// tree not balanced
			if (!rightBalanced || node.right.height > 1)
				return false;

			node.height = node.right.height + 1;
		}

		return true;
	}

	public void run() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		if (checkHeightBalance(root))
			System.out.println("The tree is balanced");
		else
			System.out.println("The tree is not balanced");
	}

	public static void main(String args[]) {

		BinaryTreeBalanceCheck tree = new BinaryTreeBalanceCheck();
		tree.run();
	}

	// Checking if a binary tree is height balanced in Java

	// Node creation
	class Node {

		int data;
		Node left, right;
		int height = -1;

		Node(int d) {
			data = d;
			left = null;
			right = null;
			height = -1;
		}
	}

}

/*
Given a binary tree, write an efficient algorithm to check if it is height-balanced or not.
In a height-balanced tree, the absolute difference between the height of the left and right subtree
 for every node is 0 or 1. */
