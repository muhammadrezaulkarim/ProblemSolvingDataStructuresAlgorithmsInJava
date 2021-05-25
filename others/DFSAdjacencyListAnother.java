import java.util.ArrayList;
import java.util.Scanner;


public class DFSAdjacencyListAnother {
	GraphOrTree gTree=null;
	
	
	public void DFS(Node node)
	{
		if(node.visited==true)
			return; // already visited. so return
		
		int col=0;
	
		node.visited=true;  // visited
		System.out.println("node:"+ node.id);
		
		for(col=0; col<node.children.size(); col++)
		{
			Node childNode=node.children.get(col);
			
			if( childNode.visited==false)
			{
				DFS(childNode);
			}
		}

	}
	
	public void DFSSearch()
	{
		
		for(int l=0;l<gTree.nodes.length;l++)  
			DFS(gTree.nodes[l]);
		
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
					
					if(line.trim().isEmpty())
						continue;
					
					if(line==null)
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
		DFSAdjacencyListAnother ob=new DFSAdjacencyListAnother();
		ob.getInput();
		ob.DFSSearch();
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
