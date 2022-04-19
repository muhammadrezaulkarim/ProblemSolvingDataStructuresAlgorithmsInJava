// Java program to print all paths with sum k.
import java.util.*;

public class BinaryTreeKSumPathsFromRoot {
	private List<Integer> path = new ArrayList<Integer>();
	private int pathCount = 0;

	// display a path
	public void displayPath()
	{
		for (int j = 0; j < path.size(); j++)
			System.out.print(path.get(j) + " ");
		System.out.println();
	}

	// This function prints all paths that have sum k
	public void generatePath(Node node, int k, int sumSoFar)
	{
		// empty node
		if (node == null)
			return;

		// add current node to the path
		path.add(node.data);

		if (sumSoFar + node.data == k)
		{
			pathCount++;
			displayPath();
		}

		// check if there's any k sum path
		// in the left sub-tree.
		generatePath(node.left, k, sumSoFar + node.data);

		// check if there's any k sum path
		// in the right sub-tree.
		generatePath(node.right, k, sumSoFar + node.data);

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
		generatePath(root, k, 0);
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

		BinaryTreeKSumPathsFromRoot obj = new BinaryTreeKSumPathsFromRoot();
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
A path must start from the root node and negative numbers can also be there in the tree. 

The basic idea to solve the problem is to do a preorder traversal of the given tree. 
We also need a list to keep track of the path that led to that node. 
At each node we check if there are any path that sums to k*/
