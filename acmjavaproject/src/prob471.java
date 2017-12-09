import java.util.Scanner;


public class prob471
{
	//BitSet flag=new BitSet();

	long max=9876543210L;

	public void Magic()
	{
		Scanner sc=new Scanner(System.in);
		
	/*	Scanner sc=null;
		try {
			sc = new Scanner(new File("input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

		int x1,y1,i=0,j=0;
		int p=sc.nextInt();
		sc.nextLine();
		
		int t=0,l=0;
		long num=0L,maxIter;
		while(t<p)
		{
			t++;
			sc.nextLine();
			num=sc.nextLong();
			
		//	maxIter=max/num;
			
			if(t>1)
			System.out.println();
			 long s1 = num;
			long   s2 = 1L;
			
			while(true)
			{
				if(NoduplicateDigits(s1) && NoduplicateDigits(s2))
					System.out.printf("%d / %d = %d\n",s1,s2,num);
				
				   s1 += num;
				      s2++;

				      if (s1 > max) {
				        break;
				      }
			}

			
		}
		
	}
	
	public boolean NoduplicateDigits(long num)
	{
		int digits[]={0,0,0,0,0,0,0,0,0,0};
		int digit;
		while(num>0)
		{
			digit=(int) (num%10L);
			digits[digit]++;
			if(digits[digit]>1)
				return false;
			num=num/10L;
			
		}
		return true;
	}

		
	public static void main(String args[] )
	{
		
	    prob471 ob=new prob471();
		ob.Magic();
		
	}
		
	
	

}
