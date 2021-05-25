import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Stack;
import java.util.TimeZone;


public class CalendarTest {
	
	public static void main(String args[])
	{
		try {
			TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Calendar stDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			stDate.setTime(fmt.parse("2019-06-08 00:00:00"));
			
			Calendar temp = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
			System.out.println(stDate.get(Calendar.HOUR_OF_DAY));
			temp.set(stDate.get(Calendar.YEAR), stDate.get(Calendar.MONTH), stDate.get(Calendar.DAY_OF_MONTH), stDate.get(Calendar.HOUR_OF_DAY),0);
		    
			System.out.println(temp.getTime());
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
