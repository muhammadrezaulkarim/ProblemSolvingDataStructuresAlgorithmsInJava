// Java program to print all paths with sum k.
import java.util.*;

public class BinaryTreeKSumPaths {
	private List<Integer> path = new ArrayList<Integer>();
	private int pathCount = 0;

	// display a path
	public void displayPath()
	{
		for (int i = 0; i < path.size(); i++)
			System.out.print(path.get(i) + " ");
		
		System.out.println();
	}

	// This function prints all paths that have sum k
	public void generatePath(Node root, int k)
	{
		// empty node
		if (root == null)
			return;

		// add current node to the path
		path.add(root.data);

		// check if there's any k sum path
		// in the left sub-tree.
		generatePath(root.left, k);

		// check if there's any k sum path
		// in the right sub-tree.
		generatePath(root.right, k);

		// check if there's any k sum path that
		// terminates at this node
		// Traverse the entire path as
		// there can be negative elements too
		/* ######## please note: sum is being performed in reverse order
		*/
		int sum = 0;
		for (int j = path.size() - 1; j >= 0; j--) {
			sum += path.get(j);

			// If path sum is k, increment path count
			if (sum == k)
			{
				pathCount++;
				displayPath();
			}
		}

		// Remove the current element from the path when returning from the recursive call
		path.remove(path.size() - 1);
	}

	public int getPathCount()
	{
		return pathCount;
	}

	// A wrapper over printKPathUtil()
	public void kSumPath(Node root, int k)
	{
		path = new ArrayList<Integer>();
		generatePath(root, k);
	}

	public Node getTreeNode()
	{
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
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
		int k = 5;

		BinaryTreeKSumPaths obj = new BinaryTreeKSumPaths();
		obj.kSumPath(obj.getTreeNode(), k);
		System.out.println(obj.getPathCount());
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
A binary tree and a number k are given. 
Print the number of paths in the tree with sum of the nodes in the path as k. 
A path can start from any node and end at any node and must be downward only, 
i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree. 

The basic idea to solve the problem is to do a preorder traversal of the given tree. 
We also need a container (vector) to keep track of the path that led to that node. 
At each node we check if there are any path that sums to k, 
if any we increment path count */
