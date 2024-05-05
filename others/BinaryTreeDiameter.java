package interviewpractice;

public class BinaryTreeDiameter {
	int currentMaxPathLength = Integer.MIN_VALUE;

	public static void main(String args[]) {
		BinaryTreeDiameter ob = new BinaryTreeDiameter();
		ob.findDiameter();
	}

	public void findDiameter() {

		Node root = new Node();
		root.value = 5;

		Node node1 = new Node();
		node1.value = 4;
		root.leftChild = node1;

		Node node2 = new Node();
		node2.value = 8;
		root.rightChild = node2;

		Node node4 = new Node();
		node4.value = 13;
		node2.leftChild = node4;

		Node node5 = new Node();
		node5.value = 4;
		node2.rightChild = node5;

		Node node6 = new Node();
		node6.value = 1;
		node5.rightChild = node6;

		/*
		 * The diameter of a tree is the number of nodes on the longest path between two
		 * leaves in the tree
		 */

		/*
		 * diameter of a tree is nothing but maximum value of (left_height +
		 * right_height + 1) among all nodes
		 */

		subtreeheight(root);
		System.out.println(currentMaxPathLength);
	}

	public int subtreeheight(Node node) {

		int leftHeight = 0;
		int rightHeight = 0;

		if (node.leftChild == null && node.rightChild == null) {
			//currentMaxPathLength = Math.max(0, currentMaxPathLength);

			node.height = 0;
			return node.height;
		}

		if (node.leftChild != null) {
			leftHeight = subtreeheight(node.leftChild) + 1;
		}

		if (node.rightChild != null) {
			rightHeight = subtreeheight(node.rightChild) + 1;
		}

		// max path length of the tree rooted at the current node
		int maxPathLength = 1 + leftHeight + rightHeight;
		// update the longest path so far to determine tree diamater
		currentMaxPathLength = Math.max(maxPathLength, currentMaxPathLength);

		// return the max height of the sub trees
		return Math.max(leftHeight, rightHeight);

	}

	class Node {
		int value;
		int height = -1;

		Node leftChild = null;
		Node rightChild = null;
	}
}
