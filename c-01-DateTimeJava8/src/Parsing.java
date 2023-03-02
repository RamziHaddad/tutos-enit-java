import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.DayOfWeek;

public class Parsing {

	public static void main(String[] args) {
		DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
		System.out.println(sunday);
		int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
		int six = LocalTime.parse("06:30").getHour();
		LocalDateTime.parse("2015-02-20T06:30:00");
		ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");




	}
}
