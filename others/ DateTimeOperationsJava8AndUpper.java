import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeOperationsJava8AndUpper {
	public static void main(String args[]) {
		// UTC date time
		Instant instant = Instant.now();

		System.out.println(instant);

		//Extract individual fields
		// ZoneId.of("UTC") to print UTC time. Change the zone id for different timezone
		
		System.out.println(String.format("Day of Month (UTC): %s",instant.atZone(ZoneId.of("UTC")).getDayOfMonth()));
		System.out.println(String.format("Day of Month (system): %s",instant.atZone(ZoneId.systemDefault()).getDayOfMonth()));
		
		System.out.println(String.format("Month (UTC): %s",instant.atZone(ZoneId.of("UTC")).getMonth()));
		System.out.println(String.format("Month (system): %s",instant.atZone(ZoneId.systemDefault()).getMonth()));
		
		System.out.println(String.format("Year (UTC): %s",instant.atZone(ZoneId.of("UTC")).getYear()));
		System.out.println(String.format("Year (system): %s",instant.atZone(ZoneId.systemDefault()).getYear()));
		
		System.out.println(String.format("Hour (UTC): %s",instant.atZone(ZoneId.of("UTC")).getHour()));
		System.out.println(String.format("Hour (system): %s",instant.atZone(ZoneId.systemDefault()).getHour()));
		
		
		System.out.println(String.format("Day of week (UTC): %s",instant.atZone(ZoneId.of("UTC")).getDayOfWeek()));
		System.out.println(String.format("Day of week (system): %s",instant.atZone(ZoneId.systemDefault()).getDayOfWeek()));
		
		
		
		// convert to epoch milliseconds
		long epochMilliseconds = instant.toEpochMilli();
		System.out.println(epochMilliseconds);
		
		// Format the UTC time with a DateTimeFormatter.ZoneId needs to be provided
		//*** Date format method not available for the Instant class
		// UTC time
		// For a value in UTC, the Z on the end means UTC, and is pronounced Zulu.
		DateTimeFormatter formatterUTC = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS'Z'")
				.withZone(ZoneId.of("UTC"));
		System.out.println(formatterUTC.format(instant));

		// System default time
		DateTimeFormatter formatter0 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
				.withZone(ZoneId.systemDefault());
		System.out.println(formatter0.format(instant));

		// Mountain time
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
				.withZone(ZoneId.of("America/Edmonton"));
		System.out.println(formatter1.format(instant));

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
				.withZone(ZoneId.of("America/New_York"));
		System.out.println(formatter2.format(instant));

		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
				.withZone(ZoneId.of("America/Los_Angeles"));
		System.out.println(formatter3.format(instant));

		// format with locale
		/*
		 * DateTimeFormatter formatterLocale =
		 * DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
		 * .withLocale(Locale.CANADA);
		 * System.out.println(formatterLocale.format(instant));
		 */

		// add 5 seconds
		Instant addMillis = instant.plusMillis(5000);
		System.out.println(addMillis);

		// ChronoUnit class is the implementation of the TemporalUnit interface
		Instant addEightHours = instant.plus(1L, ChronoUnit.HOURS);
		System.out.println(addEightHours);
		// add 1 day
		Instant addOneDay = instant.plus(1L, ChronoUnit.DAYS);
		System.out.println(addOneDay);

		// add 5 seconds in terms of milliseconds
		Instant addMiliseconds = instant.plus(5000L, ChronoUnit.MILLIS);
		System.out.println(addMiliseconds);

		// add 5 seconds in terms of milliseconds
		Instant minusMilliSeconds = instant.minus(5000L, ChronoUnit.MILLIS);
		System.out.println(minusMilliSeconds);

		// get Instant using parse method
		Instant instantParsed = Instant.parse("2018-11-30T18:35:24.00Z");
		System.out.println("Parsed Instant: " + instantParsed);

		
		
		//Creating a new ZonedDateTime object
		//A ZonedDateTime is an immutable representation of a date-time with a timezone in the ISO-8601 calendar system,
		String inputDate1 = "2007-12-03T10:15:30+01:00[Europe/Paris]";	
		ZonedDateTime zonedDateTime1 = ZonedDateTime.parse(inputDate1);
		//******* format with the specific formatter and then display *****************
		System.out.println( zonedDateTime1.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		//Format ZonedDateTime object in another time zone
		DateTimeFormatter zoneIdToUTCFormatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.of("UTC"));

		System.out.println(zoneIdToUTCFormatter.format(zonedDateTime1));
		
		// plus and minus has the same signature as the Instant class
		// add 5 seconds in terms of milliseconds
		System.out.println(zonedDateTime1.plus(5000L, ChronoUnit.MILLIS));

		// minus 5 seconds in terms of milliseconds
		System.out.println(zonedDateTime1.minus(5000L, ChronoUnit.MILLIS));
		
		//ZonedDateTime with current datetime
		ZoneId z = ZoneId.of("America/Edmonton");
		ZonedDateTime zdtNow = ZonedDateTime.now(z);
		System.out.println(zdtNow.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		
		
	    // Creating an object of LocalDateTime class
        LocalDateTime localDateTimeNow = LocalDateTime.now();
		//****** format with the specific formatter and then display **************
		System.out.println(localDateTimeNow.format(DateTimeFormatter.ISO_DATE_TIME));
		
		
		// plus and minus has the same signature as the Instant class
		// add 5 seconds (5000 milliseconds) in terms of milliseconds
		System.out.println(localDateTimeNow.plus(5000L, ChronoUnit.MILLIS));

		// minus 5 seconds (5000 milliseconds) in terms of milliseconds
		System.out.println(localDateTimeNow.minus(5000L, ChronoUnit.MILLIS));
		
		    
		//An OffsetDateTime is an immutable representation of a date-time with 
		// an offset from UTC/Greenwich in the ISO-8601 calendar system, such as 2007-12-03T10:15:30+01:00
		
		ZoneOffset zoneOffSet= ZoneOffset.of("+01:00");
		OffsetDateTime offsetDateTime = OffsetDateTime.now(zoneOffSet);
		System.out.println(offsetDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
		     
	}

}
