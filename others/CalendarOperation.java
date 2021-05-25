import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class CalendarOperation 
{
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		String[] Month={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"} ;
		
	
		  /*       String dt=sc.nextLine();
//	System.out.println(dt.toString());
	       int daysToAdd=Integer.parseInt(sc.nextLine());
		      int firstHypen=dt.indexOf("-");
	          int lastHypen=dt.lastIndexOf("-");
	          int year=Integer.parseInt(dt.substring(0,4));
	          String monthString=dt.substring(firstHypen+1,lastHypen);
	          int day=Integer.parseInt(dt.substring(lastHypen+1));*/
	         
	         String monthString="February";
	         
	         int month=-1;
	         int year=2014;
	         int day=28;
	         int daysToAdd=1; // to subtract set a negative number
	          
	          for(int j=0;j<Month.length;j++)
	          {
	        	  if(Month[j].toLowerCase().equals(monthString.toLowerCase()))
	        	  {
	        		  month=j;
	        		  break;
	        	  }
	          }
	          
	         
	          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd"); 
	           
	          Calendar cd=new GregorianCalendar(year,month,day); //Month value is 0-based. e.g., 0 for January.
	           //you can add or subtract 
	           cd.add(Calendar.DAY_OF_MONTH,daysToAdd );
	           System.out.println(sdf.format(cd.getTime()));
	           
	          // cd.add(Calendar.DAY_OF_WEEK,-1 );
	          // System.out.println(sdf.format(cd.getTime()));
	           
	           int monN=cd.get(cd.MONTH)+1; // month is 0-based, so we need to add 1
	           System.out.println( cd.get(Calendar.DAY_OF_MONTH)+" "+monN+" "+cd.get(Calendar.YEAR));
           
	}

}
