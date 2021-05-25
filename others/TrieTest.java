import java.util.ArrayList;
import java.util.Scanner;


public class TrieTest 
{
	Trie trie = null;
	ArrayList<String> wordsWithPrefixMatch = new ArrayList<String>();
	public static int maxDepth = -1;
	public static String maxDepthMatchedWord = null;
	
	public void BuildTrie()
	{
			Scanner sc=null;
		
			try 
			{
				sc=new Scanner(System.in);
				
			    // create a Trie class object
				trie =new Trie();
			    
/*				System.out.println("Enter 5 words in seperate lines to insert in a trie");
				for(int l=0;l<5;l++)
				{
					String word = sc.nextLine();
					trie.insert(word);
				}*/
				
				trie.insert("hackerearth");
				trie.insert("hackerrank");
				trie.insert("hacker");
				
				trie.insert("man");
				trie.insert("many");
				trie.insert("my");
				trie.insert("lie");
				trie.insert("a");
				
    		} 
			catch (Exception e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	}
	
	public void SearchWordInTrie()
	{
			Scanner sc=null;
			
			try 
			{
				sc = new Scanner(System.in);
				
				System.out.println("Enter a string for searching in the trie )");
				String searchWord = sc.nextLine();
			    boolean found = trie.search(searchWord);
			    
			    if (found)
			    {
			    	System.out.println("Word found in the dictionary.");
			    }
			    else
			    {
			    	System.out.println("Word not found in the dictionary.");
			    }
			    
			    System.out.println();
			     
		
			    // list all words that starts with the word as prefix
			    trie.startsWithPrefix(searchWord);
			    
			
			    System.out.println("List of words in the dictionary that starts with the search word as prefix:");
			    for(int i=0; i<wordsWithPrefixMatch.size();i++)
			       System.out.println(wordsWithPrefixMatch.get(i));
			    	
				} 
			catch (Exception e)
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
	}
	
	
	public static void main(String args[])
	{
		TrieTest ob=new TrieTest();
		ob.BuildTrie();
		ob.SearchWordInTrie();
	}
	
	
	class Trie
	{
		Node root = null;
		
		public Trie()
		{
		    root = new  Node();
			root.value = '-';
			root.isWord = false;
			root.depth=0;
		}
		
		public Node getRoot()
		{
			 return root;
		}
		
		public void insert (String word)
		{
			// initialize with the current node
			Node currentNode = getRoot();
			
			int i = 0;
			
			for (i=0; i<word.length(); i++)
			{
				char currentWordChar = word.charAt(i);
				
				boolean found = false;
				
				// check whether the character exists in any node
				for(int j=0; j<currentNode.children.size();j++)
				{
					if (currentNode.children.get(j).value == currentWordChar)
					{
						// reinitialize the current node
						currentNode = currentNode.children.get(j);
						found = true;
						break;
					}
					
				}
				
				// if the character not found in any child node, insert a new child node with the character as the value
				if (found == false)
				{
					Node newChildNode = new Node();
					newChildNode.value = currentWordChar;
					newChildNode.isWord = false;
					newChildNode.depth = currentNode.depth + 1;
					
					// add the new node as the children of the current node
					currentNode.children.add(newChildNode);
					
					// reinitialize the current node
					currentNode = newChildNode;
				}
				
			}
			
             // reset the last visited node isWord filed value to true (as the last visited node ends up in a word)
			 currentNode.isWord = true;

		}
		
		
		// return the last node upto which the entire word or word prefix matched
		public Node searchHelper(String word)
		{
			// initialize with the current node
			Node currentNode = getRoot();
			
			for (int i=0; i<word.length(); i++)
			{
				char currentWordChar = word.charAt(i);
				
				boolean found = false;
				for(int j=0; j<currentNode.children.size();j++)
				{
					if (currentNode.children.get(j).value == currentWordChar)
					{
						// reinitialize the current node
						currentNode = currentNode.children.get(j);
						found = true;
						break;
					}
					
				}
				
				// No need to search further as no word exists in the dictionary with the prefix encountered so far
				if (found == false)
				{
					return null;
				}

			}
			
			return currentNode;
		}
		
		// check whether a string exists in the dictionary
		public boolean search(String word)
		{
			Node lastVisitedNode = searchHelper(word);
			
		    // null returned if no prefix or full word found with the search word
			if (lastVisitedNode == null)
				 return false;
			
			// is any word ended in the returned node of the tree
			if (lastVisitedNode.isWord == true)
			  return true;
			else
			  return false;
			
		}
		
	   	// list all the words that have the word as prefix
		
		public void startsWithPrefix(String word)
		{
			Node lastVisitedNode = searchHelper(word);
			
			if (lastVisitedNode == null)
				 return;
			
			// now perform a DFS search to find out more words
			dfsTraversal(lastVisitedNode,word.substring(0,word.length()-1));
			
			System.out.println();
			System.out.println();
			
			System.out.println("Max depth matched word with the given  prefix: " + maxDepthMatchedWord);
			System.out.println("Max depth of the matched word : " + maxDepth);
			
			System.out.println();
			System.out.println();
			
		}
		
		public void dfsTraversal(Node currentNode, String prefix)
		{
			String currentPrefix = prefix + currentNode.value;
			
			if (currentNode.isWord == true)
			{
				wordsWithPrefixMatch.add(currentPrefix);
			    
				if (currentNode.depth > maxDepth)
				{
				   maxDepth = currentNode.depth;
				   maxDepthMatchedWord =  currentPrefix;
				}
			}

			for(int j=0; j<currentNode.children.size();j++)
			{
				Node childNode = currentNode.children.get(j);
				
				dfsTraversal(childNode, currentPrefix);
				
			}

		}
		
	}
	
	class Node
	{
		public char value;
		public boolean isWord = false;
		public int depth = 0;
		public ArrayList<Node> children = new  ArrayList<Node>();
	}

}
