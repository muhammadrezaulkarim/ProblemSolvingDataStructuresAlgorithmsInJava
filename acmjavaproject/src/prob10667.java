import java.util.Scanner;
import java.util.Stack;



public class prob10667
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
   	 
   	 int count=sc.nextInt();
   	int l=0,i=0,t=0, r1,r2,c1,c2,j=0;
   	 while(l<count)
   	 {
	    	 m=sc.nextInt(); // number of row columns
	     	 n=sc.nextInt(); // number of blocks
	         a=new int[m+1][m+1];
	    	
	    	  max=0;
	    	  
	    		 for(i=1;i<=m;i++)
		    	 {
		    		 for(j=1;j<=m;j++)
			    	 {
		    			 a[i][j]=1; // 1 means non-occupied
			    	 }
		    	 }
	    		 
	    		 for(t=1;t<=n;t++)
		    	 {
	    			 // take blocks
	    			 r1=sc.nextInt();
	    			 c1=sc.nextInt();
	    			 r2=sc.nextInt();
	    			 c2=sc.nextInt();
	    			 
	    			 for(i=r1;i<=r2;i++)
	    	    	 {
	    	    		 for(j=c1;j<=c2;j++)
	    		    	 {
	    	    			 a[i][j]=0; // occupied block means zero
	    		    	 }
	    	    	 }
	    			 
		    	 }
		    	 
	  	    	
	    	 for(i=1;i<=m;i++)
	    	 {
	    		 for(j=1;j<=m;j++)
		    	 {
	    			//val=sc.nextInt(); 
	    		//	a[i][j]= val;
	    			
	    			if(i>1 && a[i][j]==1)
	    				a[i][j]+=a[i-1][j];
		    	 }
	    		 temp=largestArea(a[i], m);
	    		 
	    		 if(temp>max)
	    			 max=temp;
		   	 }
	    	 
	    	System.out.println(max);
	    	l++;
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
		prob10667 ob=new prob10667();
         ob.x();
      //   ob.SortList();
        
	}


}


