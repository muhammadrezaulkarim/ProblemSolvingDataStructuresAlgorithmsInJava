

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class prob893 {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		String[] Month={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"} ;
	
		while(sc.hasNext())
		{

	         int daysToAdd=sc.nextInt();
	         int day=sc.nextInt();
	         int month=sc.nextInt();
	         int year=sc.nextInt();
	         
	         if(daysToAdd==0 && day==0 && month==0 && year==0)
	        	 break;
	         Calendar cd=new GregorianCalendar(year,month-1,day);
         
	           cd.add(Calendar.DAY_OF_MONTH,daysToAdd );

	          int monN=cd.get(cd.MONTH)+1;
          
	         
	          System.out.println( cd.get(Calendar.DAY_OF_MONTH)+" "+monN+" "+cd.get(Calendar.YEAR));
	     
		}
	}

}
