import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;



public class knights {
	//BitSet flag=new BitSet();
	int M,N;
	int [][] pos;
	int count=0;
	HashMap mp=new HashMap();
	int cpos[]=null;
	StringBuilder res=new StringBuilder();
	public void knights()
	{
		//Scanner sc=new Scanner(System.in);
		
		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	//	int M,N;
		
		while(sc.hasNext())
		{
			M=sc.nextInt();
			N=sc.nextInt();
			mp.clear();
			res.delete(0, res.length());
			
			pos=new int[N+1][2];
			cpos=new int[N+1];
			count=0;
			//for(int i=0;i<M;i++)
			//	for(int j=0;j<M;j++)
			backtrack(1);
			
			System.out.println(count);
		}
		
	}
	
/*	public ArrayList<Move> validMoves(int kn)
	{
		int []addrow={0,-1,1 ,2  ,2 ,1, -1,-2, -2};
		int []addcol={0,-2,2 ,-1 ,1 ,-2, 2, 1, -1};
		
		ArrayList<Move> list=new ArrayList<Move>();
	  int nextrow, nextcol;
	  boolean flag=false;
	   for(int x=1;x<=M;x++)
	   {
		   for(int y=1;y<=M;y++)
		   {
			   flag=false;
			   for(int k=1;k<kn;k++)
			   {
				   for(int l=0;l<9;l++)
				   {
					   nextrow=pos[k][0]+addrow[l];
					   nextcol=pos[k][1]+addcol[l];
					   
					   if(nextrow==x && nextcol==y )
					   {
						   flag=true;
						   break;
					   }
				   }
					if(flag)
						break;
			   }
		   if(!flag)
		   {
			   Move m=new Move(x,y);
			   list.add(m);
			   
		   }
			   
	   }
		   
	   }
	   
	   return list;
	   
	}*/
	
	public void backtrack(int kn )
	{
				
		if(kn==N+1)
		{
			
		//	int cpos[]=new int [kn];
			for(int l=1;l<kn;l++)
			{
				cpos[l]=(pos[l][0]-1)*M+pos[l][1];
				
			}
			//Collections.sort(cpos);
			Arrays.sort(cpos);
			res.delete(0,res.length());
			
			for(int l=1;l<kn;l++)
			{
				res.append(cpos[l]);
				//res.append(" ");
				
			}
	
			String p=res.toString();
			if(!mp.containsKey(p))
			{
				mp.put(p, 1);
				
		
			count++;
			
			}
			return;
		}
		
	
		
/*		ArrayList<Move> list=validMoves(kn);
		
		if(list.size()==0)
			return;
		
		for(int k=0;k<list.size();k++)
		{
			x=list.get(k).x;
			y=list.get(k).y;
			pos[kn][0]=x;
			pos[kn][1]=y;
	   
			backtrack(kn+1);
		}
		*/
		
		int []addrow={0,-1,1 ,2  ,2 ,1, -1,-2, -2};
		int []addcol={0,-2,2 ,-1 ,1 ,-2, 2, 1, -1};
	  int nextrow, nextcol;
	  boolean flag=false;
	   for(int i=1;i<=M;i++)
	   {
		   for(int j=1;j<=M;j++)
		   {
			   flag=false;
			   for(int k=1;k<kn;k++)
			   {
				   for(int l=0;l<9;l++)
				   {
					   nextrow=pos[k][0]+addrow[l];
					   nextcol=pos[k][1]+addcol[l];
					   
					   if(nextrow==i && nextcol==j )
					   {
						   flag=true;
						   break;
					   }
				   }
					if(flag)
						break;
			   }
		   if(!flag)
		   {
			   pos[kn][0]=i;
			   pos[kn][1]=j;
		   
				backtrack(kn+1);
			   
		   }
			   
	   }
		   
	   }
	   
	
			
		
	}
	
	public static void main(String args[] )
	{
		
		knights ob=new knights();
		ob.knights();
		
	}
	
	
	

}
