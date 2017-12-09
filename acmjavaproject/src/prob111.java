
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class prob111
{



	public void prob()
	{
		Scanner sc=new Scanner(System.in);
/*	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		int testcase=0,count;
		int i=0,j=0;
		int y,z;

		String x=null;
		//	   Sieve(20000000);

			count=sc.nextInt();
			//count=Integer.parseInt(sc.next());
			
		     i=0;
		 	String [] splittedArray=null;
		 	sc.nextLine();
		  
		 	String	original=sc.nextLine();
		 	
		 	int [] orgNumber=new int[count+1];
		 	splittedArray=original.split(" ");
		 	
			for(j=0;j<splittedArray.length;j++)
			{
				int val=Integer.parseInt(splittedArray[j]) ;
				orgNumber[j+1]=val;
		
			}
		 	
		 	int [] newNumber=new int[count+1];
		 	
			while(sc.hasNext())
			{
				x=sc.nextLine();
				splittedArray=x.split(" ");
						
				for(j=0;j<splittedArray.length;j++)
				{
				   int val=Integer.parseInt(splittedArray[j]) ;
				 //  newNumber[val]=orgNumber[j+1];
				   
				  newNumber[orgNumber[j+1]]=val;
					
			
				}
		     
			i++;
			
			 LIS(orgNumber,newNumber);
			// LCS(orgNumber,newNumber);
		}
		
	   

	}
	
	public void LIS(int [] org,int [] newNum)
	{
	     int i, j, max;
         int largest = 0;
        
         int []sum=new int[newNum.length];
         sum[1]=1;
         
     for(i = 2; i< newNum.length; i ++) 
    {
         sum[i] =1;
         max=1;
        
         for(j = 1; j <= i; j ++) 
        {
             if(newNum[i]>newNum[j])
               if(sum[j]+1> max)
                  max = sum[j]+1;
         }
         if(max>sum[i])
         sum[i] = max;
         
         if(max>largest)
          largest = max;
      }
     System.out.println(largest);
	}
	
		
	public void LCS(int [] org,int [] newNum)
	{
		int a[][]=new int[org.length][org.length];
		
		for(int i=1;i<org.length;i++)
		{
			
			for(int j=1;j<newNum.length;j++)
			{
			
				if(org[i]==newNum[j])
					a[i][j]=a[i-1][j-1]+1;
				else
					a[i][j]=Math.max(a[i-1][j],a[j-1][i]);
			}
	
		}
		
		System.out.println(a[a.length-1][a.length-1]);
	}
	
	
	public static void main(String args[])
	{
		prob111 ob=new prob111();
         ob.prob();
      //   ob.SortList();
        
	}

	

}


