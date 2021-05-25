
public class TreeCheckBalancedorNot 
{
	boolean isBalanced = true;
	
	boolean isSumFound = false;
	
	
	public static void main(String args[])
	{
  
		TreeCheckBalancedorNot  ob = new TreeCheckBalancedorNot();
		ob.checkBalanced();
  	}
	
	public void checkBalanced()
	{
		Tree tree = new Tree();
		
		Node root =new Node();
		root.value=5;
		root.depth =0;
		tree.setRoot(root);
		
		
		
		Node node1 = new Node();
		node1.value = 4;
		node1.depth = root.depth +1;
		root.leftChild = node1;
		
		Node node2 = new Node();
		node2.value = 8;
		node2.depth = root.depth +1;
		root.rightChild = node2;
		
	// if you add this node, the tree becomes balanced	
/*		Node node3 = new Node();
		node3.value = 11;
		node3.depth = node1.depth +1;
		node1.leftChild = node3;*/
		
		
		Node node4 = new Node();
		node4.value = 13;
		node4.depth = node2.depth +1;
		node2.leftChild = node4 ;
		
		Node node5 = new Node();
		node5.value = 4;
		node5.depth = node2.depth +1;
		node2.rightChild = node5;
		
		
		Node node6 = new Node();
		node6.value = 1;
		node6.depth = node5.depth +1;
		node5.rightChild = node6;
		
		
/*      isBalanced = true;
		int result = dfsTraversalCheckBalanced(tree.getRoot());
		
		if (result == -1)
			System.out.println("Unbalanced Binary Tree");
		else
		    System.out.println("Balanced Binary Tree");*/
			
		//dfsTraversalSimple(tree.getRoot());
		isSumFound = false;
		//dfsTraversalCompareNodeToLeafPathSum(tree.getRoot(),0,18);
		//dfsTraversalCompareNodeToLeafPathSum(tree.getRoot(),0,9);
		dfsTraversalCompareNodeToLeafPathSum(tree.getRoot(),0,100);
		
		if (isSumFound)
			System.out.println("Sum found in the path");
		else
		    System.out.println("Sum not found in the path");
		
	}
	
	public int dfsTraversalCheckBalanced(Node currentNode)
	{
		// for leaf node check
		if (currentNode.leftChild==null && currentNode.rightChild==null)
			return currentNode.depth;
		
		// in case any descendent node found that the sub trees are not balanced
		if (isBalanced = false)
			return -1;
		
				
		int depthLeft = 0, depthRight = 0,heightDiff=0;
		
		if (currentNode.leftChild!=null)
		{
			depthLeft = dfsTraversalCheckBalanced(currentNode.leftChild);
		    
			if (isBalanced = false)  // prune the search space
				return -1;
		}
		
		//System.out.println("Value: "+ currentNode.value + "  Depth: " + currentNode.depth);
		
		
		if (currentNode.rightChild!=null)
		{
			depthRight = dfsTraversalCheckBalanced(currentNode.rightChild);
		    
			if (isBalanced = false)   // prune the search space
				return -1;
		}
			
		
		if (currentNode.leftChild!=null && currentNode.rightChild!=null)
		{
			heightDiff = Math.abs(depthLeft-depthRight);
			
			if (heightDiff > 1)
			{
				isBalanced = false;
				return -1;
			}
			
			if (depthLeft > depthRight)
				return depthLeft;
			else
				return depthRight;
		}
		
		else if (currentNode.leftChild!=null && currentNode.rightChild==null)
			return depthLeft;
		else
			return depthRight;
			
	
	}
	
	public void dfsTraversalSimple(Node currentNode)
	{
				
		
		if (currentNode.leftChild!=null)
		{
			dfsTraversalSimple(currentNode.leftChild);
		    
    	}
		
		System.out.println("Value: "+ currentNode.value + "  Depth: " + currentNode.depth);
		
		
		if (currentNode.rightChild!=null)
		{
			dfsTraversalSimple(currentNode.rightChild);
		    
		}
			

	}
	
	public void dfsTraversalCompareNodeToLeafPathSum(Node currentNode, int sumSoFar, int valueToCompare)
	{
		if (isSumFound)
			return;
		
		// for leaf node check
		if (currentNode.leftChild==null && currentNode.rightChild==null)
		{
			if (sumSoFar + currentNode.value == valueToCompare)
			{
				isSumFound = true;
				return;
			}
		}
		
		
		if (currentNode.leftChild!=null)
		{
			dfsTraversalCompareNodeToLeafPathSum(currentNode.leftChild,sumSoFar + currentNode.value,valueToCompare);
			
			if (isSumFound)  // prune the search space
				return;
		    
    	}
		
		
		
		if (currentNode.rightChild!=null)
		{
			dfsTraversalCompareNodeToLeafPathSum(currentNode.rightChild,sumSoFar + currentNode.value,valueToCompare);
			
			if (isSumFound)  // prune the search space
				return;
		    
		}
			

	}
	
	
	
	
	class Tree
	{
		Node root = null;
		
		public Node getRoot()
		{
			 return this.root;
		}
		
		public void setRoot(Node root)
		{
			this.root = root;
		}
		
	}
	
	class Node
	{
		public int value;
		public int depth = 0;
		//public ArrayList<Node> children = new  ArrayList<Node>();
		public Node leftChild;
		public Node rightChild;
	}

}
