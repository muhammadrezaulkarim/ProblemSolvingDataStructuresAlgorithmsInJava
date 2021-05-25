import java.math.BigInteger;
import java.util.Scanner;


public class ScannerClassTest1 {
	
	boolean flag[][]=null;
	int input[][]=null;
	//String num1Str=null,x=null;
	//int nodecount=0;
	int minlength;
	//StringBuilder sb=new StringBuilder();
	
	int addRow[]={0,0,-1,1};
	int addCol[]={-1,1,0,0};
	int p=0,q=0;
	int sx=0,sy=0;
	int ex=0,ey=0;
	int mx=0,my=0;
	
 // String[] a=null;
	public void x()
	{

	Scanner sc=null;
		try {

			sc=new Scanner(System.in);
			//BigInteger.ZERO
			BigInteger num1=sc.nextBigInteger();
			BigInteger num2=sc.nextBigInteger();
			
			System.out.println(num1);
			System.out.println(num2);
			
			BigInteger num3=sc.nextBigInteger();
			BigInteger num4=sc.nextBigInteger();
			
			
			System.out.println(num3);
			System.out.println(num4);
			
			// read in a loop until entry finishes
			while(sc.hasNext())
			{

		         int daysToAdd=sc.nextInt();
		         int day=sc.nextInt();
		         int month=sc.nextInt();
		         int year=sc.nextInt();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String args[])
	{
		ScannerClassTest1 ob=new ScannerClassTest1();
		ob.x();
	}

}
