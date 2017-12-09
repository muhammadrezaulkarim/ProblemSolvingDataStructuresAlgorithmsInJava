
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class prob231
{

ArrayList<Integer> clist=new ArrayList<Integer>();

	public void prob2()
	{
	//	Scanner sc=new Scanner(System.in);
	
		Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i=0,tcase=0;
		int sum=0;
		String x=null;
		//	   Sieve(20000000);

  
		 //	String	original=sc.nextLine();
		 	
		 	int [] orgNumber=null;
		 	int val=0,t=0;	 
		 	
			while(true)
			{
				clist.clear();
				tcase++;
			
	
				t=sc.nextInt();
				
				  if(t==-1)
					  break;
				  
			//		if(tcase>1)
				//		System.out.println();
					
				  
				  clist.add(t); 
				  x=sc.nextLine();
				while(true)
				{
				
					x=sc.nextLine();
		
					val=Integer.parseInt(x.trim()) ;
					 //  newNumber[val]=orgNumber[j+1];
					   
					  if(val==-1)
						  break;
					  
					  clist.add(val);
				}
		  
					  orgNumber=new int[clist.size()];
					  
					  for(i=0;i<clist.size();i++)
						  orgNumber[i]=clist.get(i).intValue();
					  
				
						
					sum=	LDS(orgNumber);
					
					
					if(tcase>1)
					{
						System.out.println();
						//System.out.println();
					}
					
				//	System.out.println("Test #"+tcase+":");
				//	System.out.println(" maximum possible interceptions: "+sum);
					System.out.printf("Test #%d:\n", tcase);
					   
					System.out.printf("  maximum possible interceptions: %d\n", sum);

					
					
							   
				
							
				  
			
			}
		
	
	}
		
	   


	
	public int LDS(int [] newNum)
	{
	     int i, j, max=0;
         int largest = 0;
        
         int []sum=new int[newNum.length];
         sum[0]=1;
         
     for(i = 1; i< newNum.length; i ++) 
    {
         sum[i] =1;
         max=1;
        
         for(j = 0; j <i; j ++) 
        {
             if(newNum[i]<newNum[j])
               if(sum[j]+1> max)
                  max = sum[j]+1;
         }
         if(max>sum[i])
         sum[i] = max;
         
         if(max>largest)
          largest = max;
      }
     return largest;
	}
	

	
	public static void main(String args[])
	{
		prob231 ob=new prob231();
         ob.prob2();
      //   ob.SortList();
        
	}

	

}



