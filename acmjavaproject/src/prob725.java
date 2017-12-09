//import java.io.File;
//import java.io.FileNotFoundException;
import java.util.Scanner;


public class prob725{
	//BitSet flag=new BitSet();

	long max=100000L;

	public void Magic()
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
	//	int p=sc.nextInt();
		//sc.nextLine();
		
		int t=0,l=0;
		long num=0L;
		 long s1 = num;
			long   s2 = 1L;
			
			int count=0;
			
		while(true)
		{
			t++;
		
			num=sc.nextLong();
			
			if(num==0)
				break;
			
		//	maxIter=max/num;
			
			if(t>1)
			System.out.println();
			
			 s1 = num;
			 
			 s2 = 1000L;
			
			count=0;
			
			while(s1<=max && s2<=max)
			{
			
				
				   s1 =s2*num;
				   
				   if(s2>=max)
					   break;
				     
				 

					if(ContainAllDigits(s1,s2))
					{
						count++;
					
							System.out.printf("%05d / %05d = %d\n",s1,s2,num);
					}
					  s2++;
			}
			
			if(count==0)
				System.out.printf("There are no solutions for %d.\n",num);
		
				

			
		}
		
	}
	
	public boolean ContainAllDigits(long num1,long num2)
	{
		if(String.valueOf(num1).length()<4 || String.valueOf(num1).length()>5)
			 return false;
		
		if(String.valueOf(num2).length()<4 || String.valueOf(num2).length()>5)
			 return false;
		
		int digits[]={0,0,0,0,0,0,0,0,0,0};
		int digit;
		
		if(String.valueOf(num1).length()==4)
			digits[0]++;
		if(String.valueOf(num2).length()==4)
			digits[0]++;
		
		
		
		while(num1>0)
		{
			digit=(int) (num1%10L);
			digits[digit]++;
			if(digits[digit]>1)
				return false;
			num1=num1/10L;
			
		}
		
		while(num2>0)
		{
			digit=(int) (num2%10L);
			digits[digit]++;
			if(digits[digit]>1)
				return false;
			num2=num2/10L;
			
		}
	//	if(String.valueOf(num).length()>=4 && String.valueOf(num).length()<=5)
		int count=0;
		for(int i=0;i<digits.length;i++)
		{
			if(digits[i]==1)
				count++;
				
		}
		if(count==10)
		 return true;
		else
			return false;
		
	}

		
	public static void main(String args[] )
	{
		
		prob725 ob=new prob725();
		ob.Magic();
		
	}
		
	
	

}
