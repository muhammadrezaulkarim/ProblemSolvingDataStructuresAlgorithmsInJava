import java.util.Scanner;
import java.util.Stack;



public class prob10074
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
   	 int a[][]=null,m,n,max=0,temp;
   	 
   	 while(true)
   	 {
	    	 m=sc.nextInt();
	    	 n=sc.nextInt();
	         a=new int[m+1][n+1];
	         
	    	  if( m==0 && n==0)
	    		 break;
	    	
	    	  max=0;
	  	    	
	    	 for(int i=1;i<=m;i++)
	    	 {
	    		 for(int j=1;j<=n;j++)
		    	 {
	    			val=sc.nextInt(); 
	    			a[i][j]= (val==1)? 0:1;
	    			
	    			if(i>1 && a[i][j]==1)
	    				a[i][j]+=a[i-1][j];
		    	 }
	    		 temp=largestArea(a[i], n);
	    		 
	    		 if(temp>max)
	    			 max=temp;
		   	 }
	    	 
	    	System.out.println(max);
   	 }
   	 
    }
	
	int largestArea(int Height[], int len)
	{
		// find the largest rectangle involving this rectangle
		
	int area[]=new int[len+1]; //initialize it to 0
	int n, i, t;
	Stack<Integer> St=new Stack<Integer>();  //include stack for using this #include<stack>
	boolean done;


	
	for (i=1; i<=len; i++)
	{
		// find rectangles on the left which are greater than or equal to this rectangle in height
	while (!St.empty())
	{
	   if(Height[i] <= Height[St.peek()])
	   {
	       St.pop();
	   }
	   else
	       break;
	}
	if(St.empty())
	   t = 0;
	else
	   t = St.peek();
	//Calculating Li
	area[i] = i - t-1;
	St.push(i);
	}

	//clearing stack for finding Ri
	while (!St.empty())
	St.pop();

	for (i=len; i>=1; i--)
	{
	while (!St.empty())
	{
	   if(Height[i] <= Height[St.peek()])
	   {
	       St.pop();
	   }
	   else
	       break;
	}
	if(St.empty())
	   t = len+1;
	else
	   t = St.peek();
	//calculating Ri, after this step area[i] = Li + Ri
	area[i] += t - i-1;
	St.push(i);
	}

	int max = 0;
	//Calculating Area[i] and find max Area
	for (i=1; i<=len; i++)
	{
	area[i] = Height[i] * (area[i] + 1);
	if (area[i] > max)
	   max = area[i];
	}

	return max;
	}

	
	public static void main(String args[])
	{
		prob10074 ob=new prob10074();
         ob.x();
      //   ob.SortList();
        
	}


}


