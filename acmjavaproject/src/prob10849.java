import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class prob10849{
	//BitSet flag=new BitSet();
	int count=0,N;
	int destX=0, destY=0;
	String source,dest;
	boolean flag[][]=null;
	String[] cord=null;
	public void Bishop()
	{
		Scanner sc=new Scanner(System.in);
		
/*		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		int x1,y1,i=0,j=0;
			 Move ob;
			 int p=sc.nextInt();
			 sc.nextLine();
		int t=0,l=0;
		int cases=0;
		while(t<p)
		{
			sc.nextLine();
		//	cases=Integer.parseInt(sc.nextLine());
		//	N=Integer.parseInt(sc.nextLine());
			
			cases=sc.nextInt();
				N=sc.nextInt();
			
			
			//flag=new boolean[N][N];

			
		
			l=0;
			  int diff1,diff2;
	      
			while(l<cases)
	        {
				count=0;
	     /*   	cord=sc.nextLine().split(" ");
	        	x1=Integer.parseInt(cord[0]);
	        	y1=Integer.parseInt(cord[1]);
	        	destX=Integer.parseInt(cord[2]);
				destY=Integer.parseInt(cord[3]);
	   		 */
				
				x1=sc.nextInt();
	        	y1=sc.nextInt();
	        	destX=sc.nextInt();
				destY=sc.nextInt();
				
				x1=N-x1+1;
			//	y1=N-y1+1;
				destX=N-destX+1;
			//	destY=N-destY+1;
				
	    		y1--;
	    		x1--;
				destX--;
				destY--;
				
				/*		for(i=0;i<N;i++)
					 for(j=0;j<N;j++)
						 flag[i][j]=false;
			
				if(x1==destX && y1==destY)
					{
						System.out.println("0");
					}
					else
					{
				    ob=new Move(x1,y1,0);
				    
					BFS(ob,0);
					if(count>0)
					{
					
					 System.out.println(count);
					}
					else
					{
						System.out.println("no move");
					}
				}*/
				
					
				              
				 
				             diff1 = Math.abs (x1 - destX );
				 
				             diff2 = Math.abs (y1 -destY);
				 
				  
				 
				             if ( x1==destX && y1==destY ) System.out.println("0");
				 
				             else if ( diff1 == diff2  ) System.out.println("1");
				         				 
				             else 
				             {
				            	 if((diff1+diff2) % 2 == 0 )
				            		 System.out.println("2");
				            	 else
				            		 System.out.println("no move");
								 
				            		 
				             }
				 
				           //  else if ( diff1 % 2 == 1 && diff2 % 2 == 1 ) System.out.println("2");
				 
				           //  else System.out.println("no move");
				 
				         

				
				l++;
	        }

				

			
		//	System.out.println(CurrentMin);
			t++;
		}
		
	}

	public void BFS(Move ob,int level)
	{
			
		Queue<Move> q=new LinkedList<Move>();
		
		int []addrow={-1,-1,1,1};
		int []addcol={-1,1,-1,1};
		int nextrow,nextcol;
		Move m=null;
		q.add(ob);

	  while(!q.isEmpty())
	  {
		  
		  ob=q.remove();
		  flag[ob.x][ob.y]=true;
		  
			if(Math.abs(ob.x-destX)==Math.abs(ob.y-destY))
			{
			
			    count=ob.level+1;
				return;
			}
		
		         int maxDistance=Math.max(ob.x-0,N-ob.x);
		  
		         int p=1;
		         
		         while(p<=maxDistance)
		         {
				   for(int l=0;l<4;l++)
				   {
					   nextrow=ob.x+addrow[l]*p;
					   nextcol=ob.y+addcol[l]*p;
					   
					   if(nextrow>=0 && nextrow<N &&  nextcol>=0 && nextcol<N )
					   {
						   if(flag[nextrow][nextcol]==false )
						   {
						    m=new Move(nextrow,nextcol,ob.level+1);
					   
								q.add(m);
						   }
					   }
				   }
				   p++;
		         }
				   
				  // flag[ob.x][ob.y]=true;
	  }
		
			
			
		
	}
	
	public static void main(String args[] )
	{
		
		prob10849 ob=new prob10849();
		ob.Bishop();
		
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
