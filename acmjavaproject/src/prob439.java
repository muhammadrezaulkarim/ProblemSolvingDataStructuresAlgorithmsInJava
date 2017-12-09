import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class prob439{
	//BitSet flag=new BitSet();
	int count=0;
	int destX=0, destY=0;
	String source,dest;
	boolean flag[][]=null;
	public void knights()
	{
		Scanner sc=new Scanner(System.in);
		
/*		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		int x1,y1;
			 Move ob;
		 
		while(sc.hasNext())
		{
			source=sc.next();
			dest=sc.next();

			y1=(int)source.charAt(0)-'a';
			x1=(int)source.charAt(1)-'0';
			
			 destY=(int)dest.charAt(0)-'a';
			 destX=(int)dest.charAt(1)-'0';
			 
		//	 y1--;
			 x1--;
			 destX--;
		//	 destY--;
			 
			// if(x1==0)
			//	 break;
				
			flag=new boolean[8][8];

			count=0;
			for(int i=0;i<8;i++)
			 for(int j=0;j<8;j++)
				 flag[i][j]=false;
			
		    ob=new Move(x1,y1,0);
		    
			BFS(ob,0);
			
		//	System.out.println(CurrentMin);
		}
		
	}

	public void BFS(Move ob,int level)
	{
			
		Queue<Move> q=new LinkedList<Move>();
		
		int []addrow={-1,1 ,2  ,2 ,1, -1,-2, -2};
		int []addcol={-2,2 ,-1 ,1 ,-2, 2, 1, -1};
		int nextrow,nextcol;
		Move m=null;
		q.add(ob);

	  while(!q.isEmpty())
	  {
		  
		  ob=q.remove();
		  flag[ob.x][ob.y]=true;
		  
			if(ob.x==destX && ob.y==destY)
			{
			
				System.out.printf("To get from %s to %s takes %d knight moves.\n",source,dest,ob.level);
				return;
			}
		
		
		  
				   for(int l=0;l<8;l++)
				   {
					   nextrow=ob.x+addrow[l];
					   nextcol=ob.y+addcol[l];
					   
					   if(nextrow>=0 && nextrow<8 &&  nextcol>=0 && nextcol<8 )
					   {
						   if(flag[nextrow][nextcol]==false )
						   {
						    m=new Move(nextrow,nextcol,ob.level+1);
					   
								q.add(m);
						   }
					   }
				   }
				   
				  // flag[ob.x][ob.y]=true;
	  }
		
			
			
		
	}
	
	public static void main(String args[] )
	{
		
		prob439 ob=new prob439();
		ob.knights();
		
	}
	
	class Move{
		public int x;
		public Move(int x, int y,int level) 
		{
			super();
			this.x = x;
			this.y = y;
			this.level=level;
		}
		public int y;
		public int level;
	}
	
	
	

}
