/*import java.io.File;
import java.io.FileNotFoundException;*/

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class T9 {
	Queue<tnode> tree=new LinkedList<tnode>();
	String[] str=null;
	String dic[][]=null;
	StringBuilder sb=new StringBuilder();
	String key[]={"","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	  PrefixTree pt =new PrefixTree(); 
	  TrieNode root=null;
	
	public void processInput() throws FileNotFoundException
	{
		Scanner sc=new Scanner(new File("input.txt"));

		int cases=0;
		
		
		cases=sc.nextInt();
		
	  int i=0,j=0;
	  int dicCount=0,numCount=0;
		int  k=0;
		int scen=0;
		  String ks=null;
		  int pr=0;
	  while(i <cases)
	  {
		  j=0;
		  dicCount=sc.nextInt();
		  
		  dic=new String[dicCount][2];
		  str=new String[dicCount];
		  pt =new PrefixTree(); 
		  root=pt.createTree();
	      
		  while(j<dicCount)
		  {
			
			  
			  
			  dic[j][0]=sc.next();
			  str[j]= dic[j][0];
			pr=sc.nextInt();
			  dic[j][1]=String.valueOf(pr);
			  pt.insertWord(root,dic[j][0], pr);
			  j++;
		  }
		 // char[] branch = new char[50];
	     //   pt.printTree(root, 0, branch);
	        
		  numCount=sc.nextInt();
		 k=0;
		scen=i+1;
		  System.out.println("Scenario #"+scen);
		  while(k<numCount)
		  {
			
			  
			  
			  ks=sc.next();
			  ks=ks.substring(0,ks.length()-1);
			
			  DFS(ks);
			  k++;
			  System.out.println();
		  }
		  i++;
			System.out.println();
	  }
		
			
	}
	
	void DFS(String x)
	{
		int index=0;
	    tree.clear();
	   int currentLevel=1;
	   int maxP=Integer.MIN_VALUE;
	   String maxWord=null;
	   int prob=0,i=0;
	   String t=null;
	   int digit=0;
	   tnode ob=null,parent=null;
		while(index<x.length())
		{
			t=null;
			digit=x.charAt(index)-'0';
			maxWord=null;
			 maxP=Integer.MIN_VALUE;
			if(index==0)
			{
				
				for(i=0;i<key[digit].length();i++)
				{
					 t=String.valueOf(key[digit].charAt(i));
					 prob=calProb(t);
					ob=new tnode(t,prob,1);
					tree.add(ob);
					
					if(prob>maxP)
					{
						maxWord=t;
						maxP=prob;
					}
				}
				
			}
			else
			{
				while(!tree.isEmpty())
				{
					
					if(tree.peek().level==currentLevel)
					{
					    parent=tree.remove();
						
						for(i=0;i<key[digit].length();i++)
						{
							
							t=parent.val+String.valueOf(key[digit].charAt(i));
							prob=calProb(t);
							ob=new tnode(t,prob,parent.level+1);
							tree.add(ob);
							if(prob>maxP)
							{
								maxWord=t;
								maxP=prob;
							}
						}
						
					
					}
					else
						break;
					
				}
				
				currentLevel++;
				
			
			 	
			}
			if(maxP==0)
				System.out.println("MANUALLY");
			else
			System.out.println(maxWord);
			index++;
		}
	}
	
/*	public int calProb(String x)
	{
		int prob=0;
		//for(int i=0;i<dic.length;i++)
		//{
		//	if(dic[i][0].charAt(0)>x.charAt(0))
			//	break;
		
		//Arrays.b
		int index=binarySearch(x);
		if(index==-1)
			return 0;
		else
		{
			prob=Integer.parseInt(dic[index][1]);
			int i=index-1;
			int j=index+1;
			while(i>=0 )
			{
			  if(dic[i][0].startsWith(x))
			  {
			  prob+=Integer.parseInt(dic[i][1]);
			  }
			  else
				  break;
			  i--;
			}
			
			while(j<dic.length )
			{
			  if(dic[j][0].startsWith(x))
			  {
			  prob+=Integer.parseInt(dic[j][1]);
			  }
			  else
				  break;
			  j++;
			}
		//}
		
		  return prob;
		}
	}*/
	
	public int calProb(String x)
	{
		//sb.delete(0, sb.length());
		int prob=pt.ReturnProb2(root, 0,x);
		return prob;
	}
	
	
	
	 int binarySearch(String x)
	 {
		 
          int start, end, midPt;
          start = 0;
          int strLength=x.length();
          end = str.length - 1;
          while (start <= end) {
                  midPt = (start + end) / 2;
                  if (str[midPt].startsWith(x)) {
                          return midPt;
                  } else if (str[midPt].substring(0, Math.min(str[midPt].length(),strLength)).compareTo(x)<0) {
                          start = midPt + 1;
                  } else {
                          end = midPt - 1;
                  }
          }
          return -1;
  }
	
//	Collection.sort();

	public static void main(String args[])
	{
	T9  ob =new T9();
		try {
			ob.processInput();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	class tnode
	{
		String val=null;
		int prob=0;
		int level=0;
		public tnode(String val, int prob, int level) {
			super();
			this.val = val;
			this.prob = prob;
			this.level = level;
		}
		
	}
	
	
	public class PrefixTree
	{
	    public TrieNode createTree()
	    {
	        return(new TrieNode(' ', false,0));
	    }
	    
	    public void insertWord(TrieNode root, String word,int prob)
	    {
	        int offset = 97;
	        int l = word.length();
	        char[] letters = word.toCharArray();
	        TrieNode curNode = root;
	        
	        for (int i = 0; i < l; i++)
	        {
	            if (curNode.links[letters[i]-offset] == null)
	                curNode.links[letters[i]-offset] = new TrieNode(letters[i], i == l-1 ? true : false,prob);
	            else
	            	curNode.links[letters[i]-offset].prob=curNode.links[letters[i]-offset].prob+prob;
	            curNode = curNode.links[letters[i]-offset];
	        }
	    }

/*	    public boolean find(TrieNode root, String word)
	    {
	        char[] letters = word.toCharArray();
	        int l = letters.length;
	        int offset = 97;
	        TrieNode curNode = root;
	        
	        int i;
	        for (i = 0; i < l; i++)
	        {
	            if (curNode == null)
	                return false;
	            curNode = curNode.links[letters[i]-offset];
	        }
	        
	        if (i == l && curNode == null)
	            return false;
	        
	        if (curNode != null && !curNode.fullWord)
	            return false;
	        
	        return true;
	    }*/
	    
	    public void printTree(TrieNode root, int level, char[] branch)
	    {
	        if (root == null)
	            return;
	        
	        for (int i = 0; i < root.links.length; i++)
	        {
	            branch[level] = root.letter;
	            printTree(root.links[i], level+1, branch);    
	        }
	        
	        if (root.fullWord)
	        {
	            for (int j = 1; j <= level; j++)
	                System.out.print(branch[j]);
	            System.out.println();
	        }
	    }
	    
	    public int ReturnProb(TrieNode root, int level,String prefix)
	    {
	    	int prob=0;
	        if (root == null)
	            return prob;
	       
	     // if(level>0)
	      sb.append(root.letter);
	     
	    	  
	      
	      if(sb.length()-1==prefix.length())
	      {
	    	  
	        if(sb.toString().substring(1).equals(prefix))
            {
	        	sb.deleteCharAt(sb.length()-1);
            	return root.prob;
            }
	        else
	        {
	        	sb.deleteCharAt(sb.length()-1);
	        	return prob;
	        }
	      }
	        
	    /*    if(sb.toString().length()>prefix.length())
            {
            	return prob;
            }*/
	        
	        for (int i = 0; i < root.links.length; i++)
	        {
	           if(root.links[i]!=null)
	           {
	 	            prob=ReturnProb(root.links[i], level+1, prefix);
	            if(prob>0)
	            	break;
	           }
	        }
	        
	  /*      if (root.fullWord)
	        {
	            for (int j = 1; j <= level; j++)
	                System.out.print(branch[j]);
	            System.out.println();
	        }*/
	    	sb.deleteCharAt(sb.length()-1);
	        return prob;
	    }
	    
	    public int ReturnProb2(TrieNode root, int level,String prefix)
	    {
	    	int prob=0;
	        int offset = 97;
	        int l = prefix.length();
	        char[] letters = prefix.toCharArray();
	        TrieNode curNode = root;
	        
	        for (int i = 0; i < l; i++)
	        {
	            if (curNode.links[letters[i]-offset] == null)
	                return 0;
	            else
	            	prob=curNode.links[letters[i]-offset].prob;
	            curNode = curNode.links[letters[i]-offset];
	        }
	        
	        return prob;
	    }
	    
/*	    public static void main(String[] args)
	    {
	        TrieNode tree = createTree();
	        
	        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be".};
	        for (int i = 0; i < words.length; i++)
	            insertWord(tree, words[i]);
	        
	        char[] branch = new char[50];
	        printTree(tree, 0, branch);
	        
	        String searchWord = "all";
	        if (find(tree, searchWord))
	        {
	            System.out.println("The word was found");
	        }
	        else
	        {
	            System.out.println("The word was NOT found");
	        }
	    }*/
	}

	class TrieNode
	{
	    char letter;
	    int prob=0;
	    TrieNode[] links;
	    boolean fullWord;
	    
	    TrieNode(char letter, boolean fullWord,int prob)
	    {
	        this.letter = letter;
	        links = new TrieNode[26];
	        this.fullWord = fullWord;
	        this.prob=prob;
	    }
	}
}
