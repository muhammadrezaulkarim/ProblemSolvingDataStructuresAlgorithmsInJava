public class BinaryTreeBalanceCheck {

	// This function prints all paths that have sum k
	public int heightBalanced(Node node)
	{
		// empty node
		if (node == null)
			return 0; //leaf node has height 0

		int leftSubtreeHeight = heightBalanced(node.left);
		if (leftSubtreeHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;  // left subtree tree unbalanced. return without futher proceeding

		int rightSubtreeHeight = heightBalanced(node.right);
		if (rightSubtreeHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;  // right subtree tree unbalanced. return without futher proceeding

		
		if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1) // unbalanced tree
			return Integer.MIN_VALUE;  // signal tree unbalanced.
		else
			return Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1; // return tree height

	}

	// A wrapper over printKPathUtil()
	public boolean isTreeBalanced(Node root)
	{
		return heightBalanced(root) == Integer.MIN_VALUE? false: true;
	}

	public Node getTreeNode()
	{
		Node root = new Node(1);
		root.left = new Node(3);
		//root.left.left = new Node(2);  // enabling this node makes the tree balanced
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		return root;
	}

	public static void main(String args[])
	{

		BinaryTreeBalanceCheck obj = new BinaryTreeBalanceCheck();
		System.out.println(obj.isTreeBalanced(obj.getTreeNode()));
	}

	// binary tree node
	private class Node {
		int data;
		Node left, right;
		public Node(int data)
		{
			this.data = data;
			left = right = null;
		}
	};
}

/*
Given a binary tree, write an efficient algorithm to check if it is height-balanced or not.
In a height-balanced tree, the absolute difference between the height of the left and right subtree
 for every node is 0 or 1. */
