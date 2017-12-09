import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;



public class prob10684
{
   
	/*public void MaxRectangleInput()
     {
    	// Scanner sc=new Scanner(System.in);
			Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 while(sc.hasNext())
    	 {
	    	 int total=sc.nextInt();
	    	 if(total==0)
	    		 break;
	    	 
	    	 int Height[]=new int[total+1],x;
	    	
	    	 for(int i=1;i<=total;i++)
	    	 {
	    		x=sc.nextInt();
	    		Height[i]=x;
	    		
	    	 }
	    	 
	    	System.out.println(largestArea(Height, total));
    	 }
    	 
     }*/
	public void x()
    {
      Scanner sc=new Scanner(System.in);
/*			Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
   	 int val=0;
   	 int a[]=null,m,n,max=0,temp;
   	 
   	 int count=0;
   	int l=0,i=0,t=0, r1,r2,c1,c2,j=0;
   	
	   	while(true)
	   	{
	   		i=0;
	   		
	   		count=sc.nextInt();
	   		if(count==0)
	   			break;
	   		
	   		a= new int[count];
	   		
		   	 while(i<count)
		   	 {
			    	 m=sc.nextInt(); // number of row columns
			    	 a[i]=m;
			    	  
			    	 i++;
			    
		   	 }
		   	 
		   	DP1DMaximumSum(a);
	   	}
   	 
    }

       public void DP1DMaximumSum(int a[])
       {
    	   int max=0;
    	   int sum[]=new int[a.length];
    	   
    	   sum[0]=a[0];
    	   
    	   for(int i=1;i<a.length;i++)
    		   
    	   {
    		   sum[i]=a[i];
    		   if(a[i]+sum[i-1]>a[i])
    			   sum[i]=a[i]+sum[i-1];
    		   
    		   if(sum[i]>max)
    			   max=sum[i];
    		   
    	   }
    	   if(max<=0)
    		   System.out.printf("Losing streak.\n");
    	  else
    		  System.out.printf("The maximum winning streak is %d.\n",max);
    	 
    	  
    	   
       }
	
	public static void main(String args[])
	{
		prob10684 ob=new prob10684();
         ob.x();
      //   ob.SortList();
        
	}


}


