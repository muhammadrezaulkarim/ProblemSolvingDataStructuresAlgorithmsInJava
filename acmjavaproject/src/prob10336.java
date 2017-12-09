import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
public class prob10336 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null;
	int nodecount=0;

	int addRow[]={0,0,-1,1};
	int addCol[]={-1,1,0,0};
	int p=0,q=0,max=0;
    String[] a=null;
  
    public ArrayList<language> list=new  ArrayList<language>();
    HashMap has=new  HashMap();
    
	public void x()
	{
	Scanner sc=new Scanner(System.in);

/*	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		int testCases=0;
		int eagleCount=0,level=0;
          int cas=0;
			
			testCases=	sc.nextInt();
		  
			int i=0,j=0;
			  //sc.nextLine();
	         
			while(cas<testCases)
			{
				cas++;
			       
			has.clear();
			list.clear();
	         			  
	        p =sc.nextInt();
	        q =sc.nextInt();
	        
	        sc.nextLine();
	         
	     	flag=new boolean[p][q];
			a=new String[p];
	         
			for(i=0;i<p;i++)
			{
			  a[i]=sc.next();
			}
			
			for(i=0;i<p;i++)
			{
				for(j=0;j<q;j++)
				{
					flag[i][j]=false;
				}
			}
				
				max=0;		
			eagleCount=0;
			level=0;

			for(i=0;i<p;i++)
			{
				for(j=0;j<q;j++)
				{
					level=0;
					nodecount=0;
					if(flag[i][j]==false)
					{
						DFS(i,j,level,a[i].charAt(j));
						if(nodecount>0)
						{
							if(!has.containsKey(a[i].charAt(j)))
							{
								has.put(a[i].charAt(j),1);
							}
							else
							{
								has.put(a[i].charAt(j),((Integer)has.get(a[i].charAt(j)))+1);
							}
					     }
					}
				}
			}

			
	/*		Iterator it=has.entrySet().iterator();
			
			while(it.hasNext())
			{
				Map.Entry entr=(Entry) it.next();
				//entr.
				list.add(new language((Character)entr.getKey(),(Integer)entr.getValue()));
			}*/
			
					
			Object keys[]=has.keySet().toArray();
			for(i=0;i<has.size();i++)
			{
			
				list.add(new language((Character)keys[i],(Integer)has.get(keys[i])));
				
			}
			
			Collections.sort(list, new Comparator()
			{
				public int compare(Object x ,Object y)
				{
					language l1=(language)x;
					language l2=(language)y;
					if(l1.count>l2.count)
							return 0;
					else
					{
						if(l1.count==l2.count)
						{
							if(l1.name<l2.name)
								return 0;
							else
								return 1;
							
						}
						else
						{
							return 1;
						}
						
					}
				}
			});
			
			System.out.printf("World #%d\n",cas);
			
			for(i=0;i<list.size();i++)
			System.out.printf("%c: %d\n",list.get(i).name,list.get(i).count);
			
				
				

			}
		
			
	}
	
	public void DFS(int row,int col,int level,char c)
	{
		int nextCol=0,nextRow=0;
	
		
		flag[row][col]=true;
		level++;
			nodecount++;
			
		for(int i=0;i<4;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<q && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)==c)
			{
				DFS(nextRow,nextCol,level,c);
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		prob10336 ob=new prob10336();
		ob.x();
	}
	
	class language
	{
		public language(char name, int count) {
			super();
			this.name = name;
			this.count = count;
		}
		public char name;
		public int count;
		
	}

}
