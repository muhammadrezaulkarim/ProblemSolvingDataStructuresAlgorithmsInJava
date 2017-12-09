import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
public class prob469 {
	
	boolean flag[][]=null;
	String num1Str=null,x=null,y=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();
	
	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0,q=0,max=0;
  String[] a=null;
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
		}*/
		

		  int l=0,k=0;
		
		int count=0,testCases=0;
		
          int cas=0;
			
			testCases=	sc.nextInt();
		       sc.nextLine();
	         String x=null;
	         sc.nextLine(); 
	        // x=sc.next();
			while(cas<testCases)
			{
				cas++;
			     sb.delete(0, sb.length());
			       
		
        
			     if(cas>1)
					 System.out.println();
	      			
	     	while(true)
			{
			
	     		 x=sc.nextLine();
	     		 if(x.isEmpty())
	     			 break;
	     		 
				  if(x.charAt(0)!='L' && x.charAt(0)!='W')
					  break;
			  sb.append(x);
			  sb.append(" ");
			 
			}
	     	
	     	int eagleCount=0,level=0;
            int i=0,j=0;
	     
			if(!x.isEmpty())
			{
				a=sb.toString().split(" ");
				
				//if(a)
				p=a.length;
				q=a[0].length();
		     	flag=new boolean[p][q];
		         
		     	
				for(i=0;i<p;i++)
				{
					for(j=0;j<q;j++)
					{
						flag[i][j]=false;
					}
				}
					
					max=0;	
					i=Integer.parseInt(x.split(" ")[0]);
			        j=Integer.parseInt(x.split(" ")[1]);
		          
			}
			else
			{
				x=sc.nextLine();
				
				a=null;
				i=Integer.parseInt(x.split(" ")[0]);
		        j=Integer.parseInt(x.split(" ")[1]);
			}
            
      
            
	          while(true)
	           {
	        	  i=i-1;
	        	  j=j-1;
	        		
					level=0;
					nodecount=0;
					
					if(a!=null)
					{
						for(l=0;l<p;l++)
						{
							for(k=0;k<q;k++)
							{
								flag[l][k]=false;
							}
						}
						
						if(flag[i][j]==false && a[i].charAt(j)=='W')
						{
							DFS(i,j,level);
						}
				
						System.out.println(nodecount);
					}
					else
					{
						System.out.println("0");
					}
					//  x=sc.next();
					if(sc.hasNext())
					  x=sc.nextLine();
					else
						break;
					  if(x.isEmpty() || x==null || x.charAt(0)=='L' || x.charAt(0)=='W' )
						  break;
					  
					   i=Integer.parseInt(x.split(" ")[0]);
			           j=Integer.parseInt(x.split(" ")[1]);
									
				 } 
				
				

			}
		
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		
		flag[row][col]=true;
		level++;
			nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextCol>=0 && nextCol<q && nextRow>=0 && nextRow<p )
			if(flag[nextRow][nextCol]==false && a[nextRow].charAt(nextCol)=='W')
			{
				DFS(nextRow,nextCol,level);
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		prob469 ob=new prob469();
		ob.x();
	}

}
