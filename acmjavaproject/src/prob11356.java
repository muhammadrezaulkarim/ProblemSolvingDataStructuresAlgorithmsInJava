import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class prob11356 {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		String[] Month={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"} ;
		
		int count=sc.nextInt();
		String d=sc.nextLine();
		for(int i=0;i<count;i++)
		{
	         String dt=sc.nextLine();
//	System.out.println(dt.toString());
	         int daysToAdd=Integer.parseInt(sc.nextLine());
		      int firstHypen=dt.indexOf("-");
	          int lastHypen=dt.lastIndexOf("-");
	          int year=Integer.parseInt(dt.substring(0,4));
	          String monthString=dt.substring(firstHypen+1,lastHypen);
	          int day=Integer.parseInt(dt.substring(lastHypen+1));
	          int month=-1;
	          
	          for(int j=0;j<Month.length;j++)
	          {
	        	  if(Month[j].toLowerCase().equals(monthString.toLowerCase()))
	        	  {
	        		  month=j;
	        		  break;
	        	  }
	          }
	           int caseNo=i+1;
	           Calendar cd=new GregorianCalendar(year,month,day);
	           cd.add(Calendar.DAY_OF_MONTH,daysToAdd );
	           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMMM-dd"); 
	           System.out.println("Case "+caseNo+": "+sdf.format(cd.getTime()));
	          
	          
		}
	}

}
