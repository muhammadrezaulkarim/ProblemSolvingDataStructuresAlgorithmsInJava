import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSAdjacencyListAnother {
	GraphOrTree gTree=null;
	Queue<Node> queue=new LinkedList<Node>();
	
	public void BFS(Node rootNode)
	{
		if(rootNode.visited==true)
			return; // already visited. so return
		
		queue.add(rootNode); //add the root node
		//rootNode.visited=true; // visited
		
		while(!queue.isEmpty())
		{		
			int col=0;
		
			Node node=queue.remove();
			System.out.println("node:"+ node.id);
			node.visited=true;

			for(col=0; col<node.children.size(); col++)
			{
				Node childNode=node.children.get(col);
				
				if( childNode.visited==false)
				{
					//childNode.visited=true;
					queue.add(childNode);
				}
			}
		}

	}
	
	public void BFSSearch()
	{
		
		for(int l=0;l<gTree.nodes.length;l++)  
			BFS(gTree.nodes[l]);
		
	}
		
	public void getInput()
	{
			Scanner sc=null;
			
			try 
			{
				sc=new Scanner(System.in);
				
				System.out.println("Enter number of nodes for the graph. Number id starts from 0)");
				System.out.println("Then enter adjaceny list entries, one line for each node.");
				System.out.println("Press enter  for a node if no adacent node exists");
				int numOfNodes=sc.nextInt();
				sc.nextLine();
				
				
				gTree=new GraphOrTree();
				gTree.nodes =new Node[numOfNodes];
				
				// first create entry for all nodes
				for(int l=0;l<numOfNodes;l++)
				{
					gTree.nodes[l] = new Node(l);
				}
				
				for(int l=0;l<numOfNodes;l++)
				{
					String line=sc.nextLine();
					
					
					if(line==null)
						continue;
					
					if(line.trim().isEmpty())
						continue;
				
					
					String [] entry=line.split(" "); // get the adjacent node list
					
					//Node node=new Node(l);
					
					for(int k=0;k<entry.length;k++)
					{
						if(Integer.parseInt(entry[k])==l) 
							continue;
							
						if(!entry[k].isEmpty())
							gTree.nodes[l].AddChildNode(gTree.nodes[Integer.parseInt(entry[k])]);
					}
				
				}
		
			} 
			catch (Exception e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	}
	
	public static void main(String args[])
	{
		BFSAdjacencyListAnother  ob=new BFSAdjacencyListAnother();
		ob.getInput();
		ob.BFSSearch();
	}
	
	
	
	class GraphOrTree
	{
		public Node[] nodes;
		
	}
	
	class Node
	{
		public int id;
		public boolean visited=false;
		public ArrayList<Node> children=new ArrayList<Node>();
		
		public Node(int id)
		{
			this.id=id;
			visited=false;
		}
		
		public void AddChildNode(Node childNode)
		{
			 children.add(childNode);
		}
	}

}
